<%@page import="com.chinasofti.lexian.manager.order.vo.Orders"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员信息</title>
<style type="text/css">
#ul_top_r {
	padding-right: 35px;
	float: right;
}
table{
	border-collapse:collapse;
}
.fonta {
	color: #FC2B2B;
	text-decoration: none;
}
.fontb {
	color: #61AED5;
	text-decoration: none;
}
.inputbotom {
	width: 30px;
	height: 23px;
	vertical-align: middle;
}
.seek {
	color: #A7A7A7;
}
#pageID{
	width: 30px; 
	text-align: center;
}
#searchButton{
	width:18px; 
	height:18px;
}
#orderInfo{
	height:17px;
	color:#A7A7A7;
}
.tiao{
	width: 40px;
	height: 25px;
	border-radius: 5px;
	background-color:#FBFBFB;
	border-top:1px solid #D6D6D6;
	border-bottom:1px solid #D6D6D6;
	border-left:1px solid #D6D6D6;
	border-right:1px solid #D6D6D6;
	margin-left: 5px;
	cursor:pointer;
}
.tbotom{
	margin-top: 6px;
}
.center{
	margin-top: 6px;
}
.a1{
	vertical-align: middle;
	width:25px;
	height:25px;
}
.condition{
	height: 23px;
	margin-right: -6px;
}
td:hover{
	color:red;
}
</style>
<script language="javascript" type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.min.js"></script>
<script type="text/javascript" async="async">
	
	//订单详情
	function commodity(id) {
		location.href = "orderParticulars.do?id=" + id;
	}
	//发货
	function deliverGoods(id) {
		location.href = "deliverGoods.do?state=3&id=" + id + "&states=2&msg=" + $("#msg").val();
	}
	function searchOrders() {
		$("#searchOrderForm").submit();
	}
	function page(pageArg){
		$("#pageID").val(pageArg);
		searchOrders();
	}
	function pageSubmit(pageArg){
		//如果总页数为0说明没有数据，不做操作
		if(pageArg != 0){
			var pageNo = $("#pageID").val();
			//如果输入数字小于等于0，变成1
			if(Number(pageNo) <= 0){
				$("#pageID").val(1);
			}//如果输入页数大于总页数则变为总页数
			else if(Number(pageNo)>pageArg){
				$("#pageID").val(pageArg);
			}
			//如果text文本中为当前页数则不做操作
			if(Number($("#pageID").val())!=Number($("#thisPageNo").html())){
				$("#pageID").val(Number($("#pageID").val())-1);
				searchOrders();
			}
		}
	}
	function nextPage(pageArg,totalPage){
		$("#pageID").val(pageArg);
		
		if(pageArg<totalPage)
			searchOrders();
	}
	
	var orderInfo;
	function orderInfoFocus(){
		orderInfo = $.trim($("#orderInfo").val());
		if(orderInfo=="请输入搜索内容"){
			$("#orderInfo").val('');
		}
	}
	function orderInfoBlur(){
		$("#orderInfo").val($.trim($("#orderInfo").val()) == '' ? '请输入搜索内容' : $.trim($("#orderInfo").val()));
	}
	$(function() {
		$("#orderInfo").focus(function(){
			orderInfoFocus();
		});
		$("#orderInfo").blur(function(){
			orderInfoBlur();
		});
		$("#searchButton").click(function() {
			$("#pageID").val(0);
			$("#starttime").val($("#stime").val());
			$("#endtime").val($("#etime").val());
			searchOrders();
		});
	});
</script>
</head>
<body bgcolor="#FEFEFE" style="font-family: 微软雅黑">
<form action="searchOrders.do?state=3" id="searchOrderForm" method="post">
	<div id="ul_top">
		<img src="${pageContext.request.contextPath}/img/icon1.png" class="a1"> 订单管理    >  ${msg}
		<input type="hidden" value="${msg }" name="msg" id="msg">
		<div id="ul_top_r" align="right">
			下单时间： <input type="text" id="stime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${pageBean.starttime }">
			<input type="hidden" name="starttime" id="starttime" value="${pageBean.starttime }">
			&nbsp&nbsp:&nbsp&nbsp
			<input type="text" id="etime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${pageBean.endtime }">
			<input type="hidden" name="endtime" id="endtime" value="${pageBean.endtime }">
			<select name="condition" class="condition">
				<!-- value的值写成数据库中对应的列名 -->
				<option value="order_no"  ${pageBean.condition == 'order_no' ? 'selected' : ''}>订单编号</option>
				<option value="storename" ${pageBean.condition == 'storename' ? 'selected' : ''}>取货门店</option>
			</select>
			<span>
				<%Orders order = (Orders)request.getAttribute("pageBean"); 
				String orderInfo = "请输入搜索内容";
				if(order != null && order.getOrderInfo() != null && order.getOrderInfo() != "")
					orderInfo = order.getOrderInfo();%>
				<input type="text" name="orderInfo" id="orderInfo" style="position: relative;left:1px" value="<%=orderInfo %>">
				<!-- 提交按钮 -->
				<input type="image" style="position:relative;right:23px;top:4px" src="${pageContext.request.contextPath}/img/4.bmp" id="searchButton">
			</span>
			<input type="hidden" name="states" value="${pageBean.states}">
		</div>
	</div>
	<div class="center">
		<table border="1" align="center" bordercolor="#E4E4E4" cellspacing="0">
			<tr bgcolor="#c3dde0" align="center" >
				<th width="30"></th>
				<th width="270">订单编号</th>
				<th width="330">下单时间</th>
				<th width="150">订单状态</th>
				<th width="170">订单总额</th>
				<th width="350">取货门店</th>
				<th width="350">订单详情</th>
			</tr>
			<c:forEach items="${requestScope.ordersList}" var="order" varStatus="state">
				<tr align="center">
					<td>${state.count }</td>
					<td>${order.orderNo}</td>
					<td><spring:eval expression="order.createtime" /></td>
					<td>${order.states==1?'待付款':order.states==2?'待发货':order.states==3?'已发货':'已结单'}</td>
					<td>${order.totalamount}</td>
					<td>${order.store.storename}</td>
					<td>
						<a href="javascript:commodity(${order.id })" class="fontb">查看订单详情</a>
						<c:if test="${pageBean.states==2}">
							&nbsp&nbsp&nbsp&nbsp
							<a href="javascript:deliverGoods(${order.id })" class="fontb">发货</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="tbotom">
		<!-- 首页 -->
		<input class="inputbotom" type="image" ${pageBean.previous == 'true'?'':'disabled'} src="${pageContext.request.contextPath}/img/aa.bmp" onclick="page(0)">
		<c:if test="${pageBean.previous}">
			<!-- 上一页 -->
			<input class="inputbotom" type="image" src="${pageContext.request.contextPath}/img/a.bmp" onclick="page(${pageBean.pageNo - 1})">
		</c:if>
		第
		<input id="pageID" name="pageNo" type="text" value="${pageBean.pageNo+1}">
		页
		<c:if test="${pageBean.next}">
			<!-- 下一页 -->
			<input class="inputbotom" type="image" src="${pageContext.request.contextPath}/img/c.bmp" onclick="nextPage(${pageBean.pageNo + 1},${pageBean.totalPage})">
		</c:if>
		<!-- 末页 -->
		<input class="inputbotom" type="image" ${pageBean.next == 'true'?'':'disabled'} src="${pageContext.request.contextPath}/img/cc.bmp" onclick="page(${pageBean.totalPage -1})">
		<!-- 跳转 -->
		<input class="tiao" type="button" value="跳转" onclick="javascript:pageSubmit(${pageBean.totalPage})">
		当前第<span class="span_txt" id="thisPageNo">${pageBean.pageNo+1}</span>页
		共 <span class="span_txt">${pageBean.totalPage}</span>页
		<div style="float: right;">共<span class="span_txt">${pageBean.totalCount}</span>条记录</div>
	</div>
</form>
</body>
</html>