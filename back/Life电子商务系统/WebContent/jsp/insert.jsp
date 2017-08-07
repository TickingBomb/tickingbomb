<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     管理员管理>查看角色信息>添加角色&nbsp;&nbsp;&nbsp;&nbsp;<a href="roleList.do">返回</a>
		<br><br><br>
		<form action="insert.do" method="post">
		角色名称：<input type="text" name="name" onkeyup="value=value.replace(/[^a-zA-Z]+/g, '');"/>
		请输入英文<br><br>
		角色描述：<input type="text" name="description"><br>
			<input type="submit" value="保存">
		</form>
</body>
</html>