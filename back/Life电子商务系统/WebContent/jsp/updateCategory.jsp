<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title>乐鲜会员信息</title>
	<style type="text/css">
table.hovertable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: black;
	border-collapse: collapse;
}

table.hovertable th {
	background-color: #F1F1F1;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}


table.hovertable td {
	background-color:  #F1F1F1;
	border-width: 1px;
	padding: 1px;
	border-style: solid;
	border-color: #E6E6E7;
	text-align: center;
}
.headmanager{
	font-family: "微软雅黑";
	font-size: 17px;
	height: 20px;
}
.like{

	margin-left: 1322px;
	margin-top: -20px;
}

</style>
<script type="text/javascript">
	function search(){
		var ret= document.getElementById("input").value;
		location.href="selectByName.do?name=" + ret;
	}
	
	function deleteByPK(id){
		alert(id+"确定删除");
		location.href="delete.do?id="+ id;
	}
	/* function status(a,b){
		location.href="user.do?id=" + a + "&status=" + b; 	
	} */
</script>	
</head>
<body >
	<div style="width:100%;overflow:auto;" class="headmanager">商品管理      > 分类管理    >修改商品&nbsp<a href="javascript:history.back()" style="text-decoration:none">返回</a></div>
	<br>
	<form action="update.do" method="post">
	<input type="text" name="categoryname" value="${categoryname}"/>
	<input type="hidden" name="id" value="${id}"/>
	<input type="submit" value="保存"/>
	</form>

	
</body>
</html>