<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>welcome</title>
<style type="text/css">
table.hovertable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
	width: 100%;
}

table.hovertable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	
	
}


table.hovertable td {
	background-color: #d4e3e5;
	border-width: 1px;
	padding: 1px;
	border-style: solid;
	
	text-align: center;
}

.checkbox{

	width:400px;
	float:right;
	
}

</style>

</head>
<body>
	会员管理>查看角色信息>修改角色信息
	<a href="roleList.do">返回</a><br><br>
	<form action="updateRoleList.do" method="post">
		角色名称<input type="text" name="name" value="${name }"><br><br>
		角色描述<input type="text" name="description" value="${des }"><br><br><br>
		<input type="hidden" name="id" value="${id}"/>
		<input type="submit" value="保存">
	</form>
	
	
	
	
	
</body>
</html>