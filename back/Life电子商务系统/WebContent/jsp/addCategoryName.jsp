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
.like{
	margin-left: 20px;
	margin-top: 20px;
}
.select{
	width: 215px;
	height: 28px;
}
.input{
	width: 210px;
	height: 28px;
}
.sure{
	font-size:16px;
	color:white;
	background-color:grey;
	width: 60px;
	height: 34px;
}

</style>
<script type="text/javascript">
	function search(){
		var ret= document.getElementById("input").value;
		location.href="selectByName.do?name=" + ret;
	}
	/* function status(a,b){
		location.href="user.do?id=" + a + "&status=" + b; 	
	} */
</script>	
</head>
<body >
	<div style="width:100%;overflow:auto;">商品管理      > 分类管理      > 添加商品分类     <a href="javascript:history.back()" style="text-decoration:none">返回</a></div>
	<hr color="#E6E6E7" size="1">
	<div class="like">
		
			
				分类名称：
				<input type="text" class="input" name="categoryType" ><br>
			
	
		<input type="button" class="sure" value="保存">
		
	</div>
	
	
</body>
</html>