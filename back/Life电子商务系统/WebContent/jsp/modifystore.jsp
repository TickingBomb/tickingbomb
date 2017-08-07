<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%	
String path = request.getContextPath();	
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<base href="<%=basePath%>">  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">
<style type="text/css">
	
		.div2{
		margin-left: 200px;
		margin-top:50px;
		}
		.div3{
		margin-left: 600px;
		margin-top:-215px;
		}
		.div4{
		margin-left: 560px;
		}
		.div5{
		margin-left: 400px;
		margin-top:100px;
		}
</style>
<script src="<%=basePath%>js/easyui/jquery.min.js" type="text/javascript"></script>
			
<script type="text/javascript">			
	$(function(){		
		/*一级Ajax*/						
		$("#id_1").change(function(){						
			var id_1 = $("#id_1").val();					
			if(id_1==""){					
				$("#id_2").empty();				
				$("#id_2").append("<option value='请选择'>--请选择--</option>");				
				$("#id_3").empty();				
				$("#id_3").append("<option value='请选择'>--请选择--</option>");				
			}else{					
				$.ajax({				
					type:"POST",			
					url:"login/findcitysbyparentid.do",			
					dataType:"json",			
					data:{id:id_1},  //id为参数名，id_1为参数值，多个参数用","隔开			
					success:function(data){			
						if(data!="{}"){		
							$("#id_2").empty();//清空标签中内容	
							$("#id_2").append("<option value='请选择'>--请选择--</option>");	
							$("#id_3").empty();//清空标签中内容	
							$("#id_3").append("<option value='请选择'>--请选择--</option>");	
							//添加子标签方法一：html	
							//var html = '';	
							$.each(data,function(i, item)  {	
								// html+= "<option value='"+item.id+"'>"+item.categoryname+"</option>";
								//$("#id_2").html(html);
								//添加子标签方法二：append方法
								var statem = "<option value='"+item.id+"'>"+item.city+"</option>";
								$("#id_2").append(statem);
							});	
						}		
					},			
					error:function(){			
						alert("方法执行不成功!");		
					}			
				});				
			}					
		});						
								
// 		/*二级Ajax*/	"#id_2"					
		$("#id_2").change(function(){						
			/* alert($("#id_2").val()); */					
			var id_2 = $("#id_2").val();					
			if(id_2==""){					
				$("#id_3").empty();				
				$("#id_3").append("<option value='请选择'>--请选择--</option>");				
			}else{					
				$.ajax({				
					type:"POST",			
					url:"login/findcitysbyparentid.do",			
					dataType:"json",			
					data:{id:id_2},			
					success:function(data){			
						/* alert(data); */		
						if(data!="{}"){		
							$("#id_3").html("");  //清空标签中内容	
							$("#id_3").append("<option value='请选择'>--请选择--</option>");	
							$.each(data,function(i, item) {	
								var statem = "<option value='"+item.id+"'>"+item.city+"</option>";
								$("#id_3").append(statem);
							});	
						}		
					},			
					error:function(){			
						alert("方法执行不成功!");		
					}			
				});				
			}					
		});						
	});							
</script>		
</head>

<body >
	<span style="text-align: left;">门店信息管理  >  修改门店信息</span>
	<a href="javascript:history.back()" style="color:blue">返回</a><br>
	<form action="login/updateStore.do" method="post">
		<c:forEach items="${storeslist}" var="temp" varStatus="state">
		<div class="div2">
			门店编号：${temp.store_no }
			<br><br>
			门店名称：<input type="text" name="storename" value="${temp.storename }">
			<br><br>
			门店地址：<input type="text" name="storeaddress" value="${temp.storeaddress }">
			<br><br>
			门店介绍：<input type="text" name="introduce" value="${temp.introduce }">
			<br><br>
			开始营业时间：<input type="time" name="starttime" value="${temp.starttime }" border-radius="50%" style="width:140px">
			<br><br>
			结束营业实现：<input type="time" name="closetime" value="${temp.closetime }" border-radius="50%" style="width:140px">
			</div>
			<div class="div3">
			最大维度：<input type="text" name="maxlatitude" value="${temp.maxlatitude }">
			<br><br>
			最小维度：<input type="text" name="minlatitude" value="${temp.minlatitude }">
			<br><br>
			最大经度：<input type="text" name="maxlongitude" value="${temp.maxlongitude }">
			<br><br>
			最小经度：<input type="text" name="minlongitude" value="${temp.minlongitude }">
			<br><br>
			</div>
			</c:forEach>
			
			<div class="div4">		
				<ul style="list-style:none;">  	 			
           			<li>  			
	                    <label for="name">省份</label>  			
	                    <select name="province_id" id="id_1" style="width:210px">  			
	                        <c:forEach items="${province}" var="p"> 
	                       	<option value="${p.id }">${p.city }</option> 
	                       	</c:forEach> 			
	                        <c:forEach items="${cityslist}" var="v">  			
	                               <option value="${v.id }">${v.city }</option>  			
	                        </c:forEach>                    			
	                    </select>  			
               		</li>  			
                	<li>  			
	                    <label for="name">城市</label>  			
	                    <select name="citys_id" id="id_2" style="width:210px">  			
	                        <c:forEach items="${city}" var="c"> 
	                       		<option value="${c.id }">${c.city }</option> 
	                       	</c:forEach>                        	
	                       			
	                    </select>  			
                	</li>  			
                	<li>  			
	                    <label for="name">区域</label>  			
	                    <select name="county_id" id="id_3" style="width:210px">  			
	                        <c:forEach items="${county}" var="co"> 
	                       		<option value="${co.id }">${co.city }</option> 
	                       	</c:forEach>                        			
	                    </select>  			
               		</li>  			
            	</ul>	
            </div>	
			
					
			<div class="div5">
				<input type="submit" value="保存" style="color:606E83;width:180px;height:22px">
			</div>
</form>


</body>
</html>
 