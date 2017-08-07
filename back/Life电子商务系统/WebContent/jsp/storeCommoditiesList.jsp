<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.colorchange:hover{color:red;}
a:hover{color:red;}
table.hovertable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}

table.hovertable th {
	background-color: #c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}


table.hovertable td {
	background-color: #d4e3e5;
	border-width: 1px;
	padding: 1px;
	border-style: solid;
	border-color: #a9c6c9;
	text-align: center;
}

.div_info_all {
	float: left;
	width: 100%;
	height: 24px;
	font-family: "微软雅黑";
}

.div_info_all_text {
	font-size: 12px;
	margin-top: 7px;
	float: right;
}

.span_txt {
	font-weight: bold;
	margin-left: -3px;
}

.div_input {
	float: left;
	margin-right: 5px;
}

.input_scan {
	border: 1px solid black;
	margin-left: -1px;
	margin-right: -1px;
}

.input_text {
	width: 25px;
	height: 13px;
}

.span_text {
	font-family: "微软雅黑";
	font-size: 12px;
}
</style>
<script type="text/javascript">
function page(pageArg){
	var myform = document.getElementById("myform");
	var pageNo = document.getElementById("pageID");
	pageNo.value = pageArg;
	myform.submit();
}
function pageSubmit(pageArg){
	var myform = document.getElementById("myform");
	var pageNo = document.getElementById("pageID");
	pageNo.value=Number(pageNo.value)-1;
	if(pageNo.value < pageArg){
		if(pageNo.value>-1){
			myform.submit();
		}
	}
}
function nextPage(pageArg,totalPage){
	
	var myform = document.getElementById("myform");
	var pageNo = document.getElementById("pageID");
	pageNo.value = pageArg;
 	if(pageArg<totalPage)
		myform.submit();
}

</script>
</head>
<body>
	<form action="storeSearch.do" method="post" name="form1" id="myform">
	<b>商品管理  〉上下架管理</b>
		<select class="select">
			<option>店铺名称</option>
		</select>
		<input type="text" name="selectInfo" value="${pageBean.selectInfo}" >
		<input type="button" onclick="page(0)" width=15px value="检索">
	 
	<table class="hovertable" width="70%">
		<!-- 头部 -->
		<tr>
			<th class="colorchange">序列</th>
			<th class="colorchange">商品编号</th>
			<th class="colorchange">店铺名称</th>
			<th class="colorchange">操作</th>
		</tr>
		<!-- 明细 -->
		<c:forEach items="${clzlist}" var="temp" varStatus="state">
			<tr >
				<td class="colorchange">${state.count}</td>
				<td class="colorchange">${temp.storeNo}</td>
				<td class="colorchange">${temp.storename}</td>
				<td class="colorchange"><a href="storeMessage.do?store_no=${temp.storeNo}&selectInfo=${temp.storeNo}">店铺商品管理</a></td>
				<!--&selectInfo=${temp.storeNo}  -->
			</tr>
		</c:forEach>
		
	</table>
	<div class="div_info_all">
			<div class="div_info_all_text">
				共 <span class="span_txt">${pageBean.totalCount}</span> 条结果，分成 <span class="span_txt">${pageBean.totalPage}</span>页显示，当前第
				<span class="span_txt">${pageBean.pageNo+1}</span>页
			</div>
			<div class="div_input">
					<input type="button" class="input_scan" value="首页" onclick="page(0)"/> 
					<c:if test="${pageBean.previous}">
					<input type="button" class="input_scan" value="上页" onclick="page(${pageBean.pageNo - 1})"/> 
					</c:if>
					<c:if test="${pageBean.next}">
					<input type="button" class="input_scan" value="下页" onclick="nextPage(${pageBean.pageNo + 1},${pageBean.totalPage})"/>
					</c:if>
					<input type="button" class="input_scan" value="末页" onclick="page(${pageBean.totalPage -1})"/> 
					<span class="span_text">跳到第</span>
					<input type="text" class="input_text" name="pageNo" id="pageID"/>
					<span class="span_text">页</span> 
					<input type="button" class="input_scan" value="跳转" onclick="pageSubmit(${pageBean.totalPage})"/>
			</div>
		</div>
	
</form>
</body>
</html>