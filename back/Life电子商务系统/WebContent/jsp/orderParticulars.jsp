<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情</title>
<style type="text/css">
.whole {
	background-color: #F1F1F1;
	font-size: 21PX;
	font-family: "宋体";
}

a {
	text-decoration: none;
	font-size: 13px;
	float: left;
	margin-left: 15px;
	margin-top: 5px;
	color: #6B6BEF;
}

.begin {
	margin-left: 750px;
}

.message {
	margin-left: 120px;
	margin-top: 10px;
}

table {
	margin-left: 100px;
	margin-top: 15px;
	border-width: 0px 0px 0px 0px;
	text-align: center;
	border-collapse: collapse;
}
.zhideng{
	margin-top: 40px;
	margin-left: 150px;
}
</style>
</head>
<body class="whole">
		<a href="javascript:history.back()"><b>返回</b></a>
		<div class="begin">
			<b>订单详情</b>
		</div>
	<div class="zhideng">
		<div class="message">
			<span>订单编号：<b>${order.orderNo}</b></span>
			<br /> <br /> 
			<span>门店名称：<b>${order.store.storename }</b></span>
			<br /><br /> 
			<span>订单时间：<b><spring:eval expression="order.createtime" /></b></span>
			<br /> <br /> 
			<span>客户姓名：<b>${order.user.username }</b></span>
			<br /><br /> 
			<span>客户电话：<b>${order.user.phone }</b></span><br />
		</div>
		<table border="1" bordercolor="#A8A5A3">
			<tr bgcolor="#E9E5E3">
				<th width="200">商品编号</th>
				<th width="420">名称</th>
				<th width="160">图片</th>
				<th width="160">单价(元)</th>
				<th width="60">数量</th>
				<th width="160">单价(元)</th>
			</tr>
			<c:forEach items="${order.commodity }" var="commodity">
				<tr bgcolor="#F1F1F1" height="110px">
					<td>${commodity.commodityNo}</td>
					<td>${commodity.name}</td>
					<td><img height="110" src="${pageContext.request.contextPath}${commodity.pictureurl}"></td>
					<td>${commodity.orderitem.listprice}</td>
					<td>${commodity.orderitem.amount}</td>
					<td>${commodity.orderitem.totalprice}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>