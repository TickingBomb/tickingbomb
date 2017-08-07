package com.chinasofti.lexian.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.chinasofti.lexian.bean.PageBean;


	/**
	 * args 对应方法的参数
	 * method 想要拦截的方法
	 * type 想要拦截的类
	 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }),
		@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class }) })
public class PageInterceptor implements Interceptor {

	/**
	 * SELECT * FROM USER ORDER BY ID LIMIT 0,2
	 */
	private static final String SELECT_ID = "Page";
	
	//在intercept方法中获取mybatis.xml中的property属性值为PageCount赋值
	private Properties properties;
	
	//通过PageBean对象获取Count值的where条件后参数
	private PageBean pageBean;
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		if (invocation.getTarget() instanceof StatementHandler) {
			
			//获取mappedStatement对象 通过mappedStatement，metaStatementHandler获取对SQL语句和参数进行操作
			StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
			MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
			MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
					.getValue("delegate.mappedStatement");
			
			
			//mappedStatement.getId() 获取被截取的方法名字 输出的方法名为 包名.类名.方法名
			String selectId = mappedStatement.getId();
			
			//判断如果方法名字中出现Page 则为需要进行分页操作的方法
			if (selectId.indexOf(SELECT_ID) != -1) {
				
				//boundSql.getSql() 获取当前方法执行的Sql语句
				BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
				String sql = boundSql.getSql();
				sql = sql.replaceAll("\n", " ").replaceAll("\t", "");
				/*
				 * boundSql.getParameterObject() 获取被截获方法的参数 需要强转
				 * PageBean 需要分页的Bean数据的父类
				 * User Controller方法中的参数类 获取User为了给Count的Where后条件 赋值
				 * 被拦截的方法中未赋值
				 */
				pageBean = (PageBean) (boundSql.getParameterObject());
				
				//获取mybatis.xml中的值(每页的条数) 为 PageCount赋值
				pageBean.setPageCount(Integer.parseInt(this.properties.getProperty("pageCount")));

				//concatCountSql()方法 截取sql查询方法 获取需要分页的表名 计算共有多少条数据
				String countSql="";
				if(pageBean.getState()==2){
					countSql ="select count(*) from (" + concatCountSql(sql) + ") as name";
				}else if(pageBean.getState()==3){
					countSql = concatCountSql_ji(sql);
				}else{
					countSql = concatCountSql(sql);
				}
				//获取数据库连接对象
				Connection connection = (Connection) invocation.getArgs()[0];
				
				//执行countSql语句 并获得Count值 为PageBean的totalCount赋值
				PreparedStatement countStmt = null;
				ResultSet rs = null;
				int totalCount = 0;
				try {
					countStmt = connection.prepareStatement(countSql);
					rs = countStmt.executeQuery();
					if (rs.next()) {
						totalCount = rs.getInt(1);
					}

				} catch (SQLException e) {
//					System.out.println("Ignore this exception" + e);
				} finally {
					try {
						rs.close();
						countStmt.close();
					} catch (SQLException e) {
						System.out.println("Ignore this exception" + e);
					}
				}
				
				//判断若下一页条数大于最大数 则按最大数取值
				pageBean.setTotalCount(totalCount);
				pageBean.setPageLimit(pageBean.getPageNo() * pageBean.getPageCount());
				if (pageBean.getPageLimit() > totalCount) {
					pageBean.setPageLimit(totalCount);
				}
				
				//将处理好的SQL语句绑定
				String pageSql = concatPageSql(sql, pageBean);
				metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
			}
		}

		return invocation.proceed();
	}

	/**
	 * 如果类型为StatementHandler则返回他本身
	 * 用于封装目标对象，通过该方法可以返回目标对象本身
	 */
	@Override
	public Object plugin(Object target) {
		if (target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}
	
	/**
	 * setProperties方法在intercept方法之前调用
	 * 需要在mybatis-config.xml中的<plugins>中配置property
	 * 能获取xml文件中对应的property值
	 */
	@Override
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * 
	 * @param sql 根据Sql 截取出获得查询数据条数的Sql语句
	 * @return 返回select count(*) from 表名 (where name = 值)
	 */
	public String concatCountSql_ji(String sql) {
		StringBuffer sb = new StringBuffer("select count(*) from ");
		//select count(*) from user
		//转小写
		sql = sql.toLowerCase();
//		System.out.println("-------------原sql文:"+sql);
		
		//sql.lastIndexOf("order") > sql.lastIndexOf(")") 如果有order by 则不截取order后  不需要排序
		if (sql.lastIndexOf("order by") > sql.lastIndexOf(")")) {
			sb.append(sql.substring(sql.indexOf("from") + 4, sql.lastIndexOf("order by")));
		} else {
			//截取from 后所有条件
			sb.append(sql.substring(sql.indexOf("from") + 4));
		}
		
		//StringBuffer转成String
		String newSql = sb.toString().replaceAll("\n", " ").replaceAll("\t", "");
//		System.out.println("去空格后的sql文："+newSql);
		
		//判断 如果 sql语句为有参查询 则替换参数
		/**
		 * select count(*) from  orders o,store s,commodity c
			where o.store_no = s.store_no 
			and o.commodity_no = c.commodity_no
			and o.states = ?
			and o.createtime >= ?
			and o.createtime <= ?
			and order_no like "%"?"%"
		 */
		//循环替换sql文中的?
		
		//只有一个?
		if(newSql.indexOf("?") > 0 && newSql.indexOf("?") == newSql.lastIndexOf("?")){
			return newSql.replaceAll("\\?", "'"+this.pageBean.getSelectInfo()+"'");
		}
		
		//有多个?
		while(newSql.indexOf("?") > 0) {
			
			String condition = newSql.substring(0, newSql.indexOf("?"));
			/**
			 * condition =
			 * select count(*) from  orders o,store s,commodity c
				where o.store_no = s.store_no 
				and o.commodity_no = c.commodity_no
				and o.states = 
			 */
			condition = condition.substring(condition.lastIndexOf("and")+3);
			/**
			 * condition =
			 *  o.states =
			 */
			/**
			 * 判断condition中的逻辑运算符
			 * >=、<=、>、<，需要保留，以便判断需要的是哪个参数
			 */
			if(condition.indexOf(">=") > 0 || condition.indexOf("<=") > 0){
				condition = condition.substring(condition.indexOf(".") > 0 ? condition.indexOf(".")+1 : 0, condition.indexOf("=")+1).trim();
			}else if(condition.indexOf(">") > 0){
				condition = condition.substring(condition.indexOf(".") > 0 ? condition.indexOf(".")+1 : 0, condition.indexOf(">")+1).trim();
			}else if(condition.indexOf("<") > 0){
				condition = condition.substring(condition.indexOf(".") > 0 ? condition.indexOf(".")+1 : 0, condition.indexOf("<")+1).trim();
			}else if(condition.indexOf("=") > 0){
				condition = condition.substring(condition.indexOf(".") > 0 ? condition.indexOf(".")+1 : 0, condition.indexOf("=")).trim();
			}else {
				condition = condition.substring(condition.indexOf(".") > 0 ? condition.indexOf(".")+1 : 0, condition.indexOf("like")).trim();
			}
			//去参数中的空格
			condition = condition.replace(" ", "");
			
			//去掉参数中的"_"并将后一字母大写
			while (condition.indexOf("_") > 0) {						//order_no
				int location = condition.indexOf("_");				//5
				String upCase = condition.substring(location+1, location+2).toUpperCase();//N
				String target = condition.substring(location, location+2);//_n
				condition = condition.replaceFirst(target, upCase); //orderNo
			}
			//调用pageBean的getSelectInfo方法根据参数名获取对应的参数值
			String strInfo = "'" + this.pageBean.getInfoHashMap(condition) + "'";
			
			newSql = newSql.replaceFirst("\\?", strInfo);// ?需要转义-->\?,\也需要转义-->\\,\?就要写成\\?
		}
		return newSql;
	}
	
	public String concatCountSql(String sql) {
		StringBuffer sb = new StringBuffer("select count(*) from ");
		//select count(*) from user
		//转小写
		sql = sql.toLowerCase();
		//sql.lastIndexOf("order") > sql.lastIndexOf(")") 如果有order by 则不截取order后  不需要排序
		if (sql.lastIndexOf("order") > sql.lastIndexOf(")")) {
			sb.append(sql.substring(sql.indexOf("from") + 4, sql.lastIndexOf("order")));
		} else {
			//截取form 后所有条件
			sb.append(sql.substring(sql.indexOf("from") + 4));
		}
		
		//StringBuffer转成String
		String newSql = sb.toString();
		//判断 如果 sql语句为有参查询 则替换参数
		if (sb.indexOf("?") > 0) {
			if(pageBean.getState()!=2){
				String strInfo = "'" + this.pageBean.getSelectInfo() + "'";
				newSql = newSql.replace("?", strInfo);
			}else{
				String [] arr = newSql.split("\\?");
				String storename=pageBean.getStorename();
				String starttime=pageBean.getStarttime();
				String closetime=pageBean.getClosetime();
				String selectInfo = pageBean.getSelectInfo();
				switch (arr.length) {
				case 2:
					if(storename != null&&(!storename.equals(""))){
//						System.out.println("a1");
						newSql=arr[0]+"'"+storename+"'"+arr[1];
					}else if(starttime!=null&&(!starttime.equals(""))){
//						System.out.println("a2");
						newSql=arr[0]+"'"+starttime+"'"+arr[1];
					}else if(closetime!=null&&(!closetime.equals(""))){
//						System.out.println("a3");
						newSql=arr[0]+"'"+closetime+"'"+arr[1];
					}else{
						newSql=arr[0]+"'"+selectInfo+"'"+arr[1];
					}
					break;
				case 3:
					if((storename==null||storename.equals(""))&&(starttime==null||starttime.equals(""))){
						newSql=arr[0]+"'"+closetime+"'"+arr[1]+"'"+selectInfo+"'"+arr[2];
					}else if((storename==null||storename.equals(""))&&(closetime==null||closetime.equals(""))){
						newSql=arr[0]+"'"+starttime+"'"+arr[1]+"'"+selectInfo+"'"+arr[2];
					}else if((storename==null||storename.equals(""))&&(selectInfo==null||selectInfo.equals(""))){
						newSql=arr[0]+"'"+starttime+"'"+arr[1]+"'"+closetime+"'"+arr[2];
					}else if((starttime==null||starttime.equals(""))&&(closetime==null||closetime.equals(""))){
						newSql=arr[0]+"'"+storename+"'"+arr[1]+"'"+selectInfo+"'"+arr[2];
					}else if((selectInfo==null||selectInfo.equals(""))&&(closetime==null||closetime.equals(""))){
						newSql=arr[0]+"'"+storename+"'"+arr[1]+"'"+starttime+"'"+arr[2];
					}else{
						newSql=arr[0]+"'"+storename+"'"+arr[1]+"'"+closetime+"'"+arr[2];
					}
					break;
				case 4:
					if(storename==null||storename.equals("")){
						newSql=arr[0]+"'"+starttime+"'"+arr[1]+"'"+closetime+"'"+arr[2]+"'"+selectInfo+"'"+arr[3];
					}else if(starttime==null||starttime.equals("")){
						newSql=arr[0]+"'"+storename+"'"+arr[1]+"'"+closetime+"'"+arr[2]+"'"+selectInfo+"'"+arr[3];
					}else if(closetime==null||closetime.equals("")){
						newSql=arr[0]+"'"+storename+"'"+arr[1]+"'"+starttime+"'"+arr[2]+"'"+selectInfo+"'"+arr[3];
					}else{
						newSql=arr[0]+"'"+storename+"'"+arr[1]+"'"+starttime+"'"+arr[2]+"'"+closetime+"'"+arr[3];
					}
					break;
				case 5:
					newSql=arr[0]+"'"+storename+"'"+arr[1]+"'"+starttime+"'"+arr[2]+"'"+closetime+"'"+arr[3]+"'"+selectInfo+"'"+arr[4];
					break;
				default:
					break;
				}
			}
		}
		return newSql;
	}
	
	/**
	 * 
	 * @param sql 为截取到的Sql语句
	 * @param pageBean 分页model类 为limit 添加参数 
	 * @return 拼接好的Sql语句
	 * limit(初始从0开始，条数)
	 */
	public String concatPageSql(String sql, PageBean pageBean) {
		StringBuffer sb = new StringBuffer();
		sb.append(sql);
		sb.append(" limit ").append(pageBean.getPageLimit()).append(" ,").append(pageBean.getPageCount());
		return sb.toString();
	}

}