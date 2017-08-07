<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>登录</title>
	<link rel="shortcut icon" href="favicon.ico" />
	<link rel="bookmark" href="favicon.ico" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/base.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/asyncbox/asyncbox.css" />

<title>修改密码</title>
<style type="text/css">
.checkbox1 {
	margin-bottom:5.5px;
	width: 300px;
	float: left;
}
</style>
		<script type="text/javascript">
		function fun() {
			var newValue = document.getElementById("new").value;
			var originValue = document.getElementById("origin").value;
			
				if(newValue==originValue){
					document.getElementById("s1").innerHTML="新密码与原密码相同";
				}else{
					document.getElementById("s1").innerHTML="";
				}
			}
		function fun1() {
			var newValue = document.getElementById("new").value;
			var confirmValue = document.getElementById("confirm").value;
				if(confirmValue==newValue){
					document.getElementById("s2").innerHTML="";
				}else{
					document.getElementById("s2").innerHTML="两次密码不一致";
				}
			}
		</script>

</head>
<body>
	<img src="${pageContext.request.contextPath}/img/icon1.png"
		width="25px" height="25px"> 修改密码 &nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:history.back()">返回</a>
	
		 <div class="center">
		<form action="updatePassword.do" method="post">
		
			<div class="content" style="margin-top: 10%">
				<div class="login-input">
					<p class="title b-hr">请修改密码</p>
					<div class="item">
						<label class="label-icon">
						<img src="../img/icon/icon-user.png" alt="" /></label>
						 <input name="phone" id="phone" type="text" value="请输入手机号" />
					</div>
					<div class="item">
						<label class="label-icon">
							<img src="../img/icon/icon-pswd.png" alt="" />
						</label>
						 <input name="rnpwd" id="origin" type="text" value="请输入原密码"/>
					</div>
					<div class="item">
						<label class="label-icon">
							<img src="../img/icon/icon-pswd.png" alt="" />
						</label>
						<input name="npwd" id="new" type="text" name="password" value="请输入新密码" onblur="fun()" />
						<div id="s1"></div>
					</div>
					<div class="item">
						<label class="label-icon">
							<img src="../img/icon/icon-pswd.png" alt="" />
						</label>
						  <input name="passwd" id="confirm" type="text" value="确认新密码" onblur="fun1()"/>
						  <div id="s2"></div>
					</div>
					<div class="div-btn">
						<input class="a-btn" type="submit" value="确认修改" />
					</div>
				</div>
			</div>
		</form>
	</div>
                        
</body>
</html>