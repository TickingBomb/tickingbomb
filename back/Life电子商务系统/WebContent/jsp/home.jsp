<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<title>乐鲜后台主页</title>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="bookmark" href="favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/manager.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/asyncbox/asyncbox.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/home.css" />
</head>
<body class="easyui-layout">
	<div id="left" data-options="region:'west',title:'',collapsed:false"
		style="width: 200px; background-color: #3E4042;">
		<div style="width: 100%; height: 170px; background: #3E4042"
			class="headwrap clear">
			<div class="leftimg">
				<img src="../img/head.png" />
			</div>
			<div class="infomation2">
				<div>
					<a id="userName"></a>
				</div>
				<div>
					<a id="loginTime"></a>
				</div>
			</div>
			<div
				style="display: inline-block; position: absolute; right: 20px; top: 30px">
				<a href="javascript:logout()">退出登录</a>
			</div>
			<div
				style="display: inline-block; position: absolute; right: 20px; top: 60px">
				<a href="changePassword.do" id="changePassword">修改密码</a>
			</div>
		</div>
		<div class="easyui-accordion" data-options="border:false"
			id="leftMenus">
			<div title="权限管理" style="width: 200px; overflow: auto;">
				<ul>
<!-- 					<li style="margin: 4px"><a href="managerList.html"
						target="manager">查看权限</a></li>
					<li style="margin: 4px"><a href="managerList.html"
						target="manager">查看菜单</a></li> -->
					<li style="margin: 4px"><a href="manager.do" target="manager">查看后台用户</a></li>
					<li style="margin: 4px"><a href="roleList.do" target="manager">查看角色信息</a></li>
				</ul>
			</div>
			<div title="会员管理" style="width: 200px; overflow: auto;">
				<ul>
					<li style="margin: 4px"><a href="userList.do" target="manager">查看会员信息</a></li>
				</ul>
			</div>

			<div title="商品管理" style="width: 200px; overflow: auto;">
				<ul>
					<li style="margin: 4px"><a href="categoryList.do"
						target="manager">分类管理</a></li>
					<li style="margin: 4px"><a href="commodityList.do"
						target="manager">商品信息管理</a></li>
				</ul>
			</div>

			<div title="门店管理" style="width: 200px; overflow: auto;">
				<ul>
					<li style="margin: 4px"><a href="storesList.do"
						target="manager">门店信息</a></li>
					<li style="margin: 4px"><a href="storeCommoditiesList.do"
						target="manager">门店商品</a></li>
				</ul>
			</div>

			<div title="订单管理" style="width: 200px; overflow: auto;">
				<ul>
					<li style="margin: 4px"><a href="ordersList.do?state=3&states=0&msg=订单列表"
						target="manager">订单列表</a></li>
					<li style="margin: 4px"><a href="ordersList.do?state=3&states=1&msg=未付款订单"
						target="manager">未付款订单</a></li>
					<li style="margin: 4px"><a href="ordersList.do?state=3&states=2&msg=已付款订单"
						target="manager">已付款订单</a></li>
					<li style="margin: 4px"><a href="ordersList.do?state=3&states=3&msg=已发货订单"
						target="manager">已发货订单</a></li>
					<li style="margin: 4px"><a href="ordersList.do?state=3&states=4&msg=已完成订单"
						target="manager">已完成订单</a></li>
				</ul>
			</div>
			<!-- 	
			<div title="版块管理" style="width: 200px;overflow:auto;">
				<ul >
						<li style="margin:4px"><a
							href="specialList.html" target="manager">特定活动</a></li>
					</ul>
			</div> -->

			<div title="数据统计" style="width: 200px; overflow: auto;">
				<ul>
					<li style="margin: 4px"><a
						href="statisticsCommodities.do?state=2" target="manager">商品销售概况</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div id="center" data-options="region:'center',border:true">
		<div id="centerin">
			<iframe name="manager" scrolling="auto"
				src="<%=basePath%>jsp/welcome.jsp"> </iframe>
		</div>
	</div>

	<script type="text/javascript" src="<%=basePath%>js/String.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/AsyncBox.v1.4.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/validate.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
		$(function() {
			$(".panel-body >ul >li >a").live("click", function() {
				$(".panel-body >ul >li >a").css("color", "#ffffff");
				$(this).css("color", "#f0983d");
			});

			$(".accordion-header").click(
					function() {
						$(".accordion-header").removeClass(
								"accordion-header-selected");
						$(this).addClass("accordion-header-selected");
					});
		});
	</script>
</body>
</html>

