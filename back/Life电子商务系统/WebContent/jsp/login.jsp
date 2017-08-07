<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html  >
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
	<script type="text/javascript">
		function status(){
			  if(${status}==2){
				alert("已被禁用");
			}
		}
	</script>
</head>

<body>
	<div class="center">
		<form action="<%=basePath%>login/login.do" id="login-form">
			<div class="content" style="margin-top: 10%">
				<div class="login-input">
					<p class="title b-hr">乐鲜生活平台管理系统</p>
					<div class="item">
						<label class="label-icon">
						<img src="../img/icon/icon-user.png" alt="" /></label>
						<input id="phone" name="userName" type="text" placeholder="管理员账号" autofocus />
					</div>
					<div class="item">
						<label class="label-icon">
							<img src="../img/icon/icon-pswd.png" alt="" />
						</label>
						<input type="password" id="passwd" name="passWord" value="123456" placeholder="管理员密码" onkeydown="if(event.keyCode==13)login()" />
					</div>
					<!-- <div class="item">
	               		<label class="label-icon">
	               			<img src="../img/icon/icon-yzm.png" alt="" />
	               		</label>
	                	<input type="text" id="num" placeholder="验证码"/>
	                	<span class="yzm"><img id="imgyan" alt=""></span>
	            	</div>  -->
					<div class="div-btn">
						<a class="a-btn" id="login" href="javascript:void(0);" onclick="status()">登&nbsp;&nbsp;&nbsp;&nbsp;录</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/validate.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/String.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/AsyncBox.v1.4.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#phone").focus();
			$("#phone").val("13800138000");
			$("#login").click(function() {
				login();
			});
		});
	
		function login() {
			var phone = $.trim($("#phone").val());
			var passwd = $.trim($("#passwd").val());
			var num = $.trim($("#num").val());
			if (!validateUtil.validateEmpty(phone)) {
				asyncbox.tips("账号不能为空！", asyncbox.Level.error);
				return;
			}
			;
			if (!validateUtil.validateEmpty(passwd)) {
				asyncbox.tips("密码不能为空！", asyncbox.Level.error);
				return;
			}
			;
			var data = {
				passWord : passwd,
				userName : phone
			};
			$('#login-form').submit();
		}
	</script>
</body>
</html>