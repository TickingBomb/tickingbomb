<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

.save
{
	float:left;
	font-size:18px;
	color:white;
	background-color:#606E83;
	width:200px;
	height:30px;
	margin-left:50px;
}
</style>
</head>
<body background="#F3F3F3" style="font-family: 微软雅黑">
	管理员管理&nbsp&nbsp>&nbsp&nbsp查看管理员信息&nbsp&nbsp>&nbsp&nbsp添加管理员
	<a href="fanhui.do" style="font-size: 12px">返回</a>
	<br><br><br>
	<form action="insertRole.do" method="post">
		<p>
			管理员账号: <input type="text" name="name"><br> <br>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp密码: <input type="text" name="password"><br><br> 
			&nbsp&nbsp&nbsp确认密码: <input type="text" name="repassword"><br><br> 
			管理员描述: <input type="text" name="info"><br><br> 
			&nbsp&nbsp&nbsp角色名称: <input type="checkbox" name="role" value="1">超级管理员
				 <input type="checkbox" name="role" value="2">商品管理员
				 <input type="checkbox" name="role" value="3">订单管理员 
		</p>
		<input type="submit" name="save" class="save" value="保存">
	</form>
</body>
</html>