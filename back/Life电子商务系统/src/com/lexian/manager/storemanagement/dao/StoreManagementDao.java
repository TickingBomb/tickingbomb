package com.chinasofti.lexian.manager.storemanagement.dao;

import java.util.List;

import com.chinasofti.lexian.manager.storemanagement.vo.Citys;
import com.chinasofti.lexian.manager.storemanagement.vo.Page;
import com.chinasofti.lexian.manager.storemanagement.vo.Stores;

public interface StoreManagementDao {

	// 操作店门的状态
	public int updateStatus(Stores stores);

	// 添加部门信息
	public int insertStore(Stores stores);

	// 修改部门信息——查询
	public List<Stores> modifyinfo(Stores stores);

	public List<Citys> updateCitys(int id);
	public int updateStore(Stores stores);

	// 下拉框城市信息(添加按钮)
	public List<Citys> findcity();

	// 下拉框城市信息(修改按钮)
	public List<Citys> findstorecity();

	// 三级联动
	List<Citys> searchCitys(Citys citys);

	List<Citys> searchCitysByParentId(Citys citys);

	// 分页——用户产品分页，通过登录用户ID查询
	public List<Stores> selectUserByP(Page page);
	public List<Stores> selectAllByP(Page page);
	//模糊分页
	public Integer getUserCountLike(Stores stores);
	// * 取得产品数量信息，通过登录用户ID查询
	public Integer getUserCount();
	// public List<String> getUrl(int userId);
	//
	//
	// public LoginVo login(LoginVo loginVo);
	//
	//
	// public List<String> findAllRole(String managerId);
	//
	// //查看数据库表的信息 返回在home.JSP 查看会员信息
	// public List<User> findUser();
	//
	// //登陆时更改登录的最后时间
	// public int updatelastlogintime(LoginVo loginVo);
	//
	// //啓動禁用時时更改用戶的Status
	// public int updateStatus(User user);
	//
	// public List<User> searchSelect(User user);



}
