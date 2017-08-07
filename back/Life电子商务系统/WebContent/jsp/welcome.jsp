<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title>乐鲜后台</title>
	<link rel="stylesheet" type="text/css"　href="<%=basePath%>js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/asyncbox/asyncbox.css" />
	<style>
		.logo,.text {
			text-align: center;
		}
		
		.logo {
			margin-top: 5%;
		}
		.wli {
			width: 70%;
			margin: 30px auto;
		}
		
		.wli ul li {
			list-style: none;
			line-height: 30px
		}
	</style>
</head>
<body>
	<div class="main">
		<div class="logo">
			<img src="../img/logo1.png" />
		</div>
		<div class="text">
			<img src="../img/text.png" />
		</div>
		<div class="wli">
			<ul>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/AsyncBox.v1.4.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/validate.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/String.js"></script>
</body>
</html>