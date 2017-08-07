<%@page import="com.chinasofti.lexian.manager.user.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
a{
	text-decoration: none;
}
#div_right {
	width: 100%;
	height: 640px;
	margin: 0 auto;
}

#div_login {
	width: 100%;
	height: 25px;
	padding-top: 4px;
	font-family: "微软雅黑";
	font-size: 13px;
}

.table_txt {
	font-family: "微软雅黑";
	font-size: 12px;
	height: 20px;
	border: 0.1px solid gray;
	text-align: center;
	width: 100%
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

#div_select {
	float: right;
	margin-right: 5px;
	margin-top: -5px;
}
#td_text1{
	color:blue;
}
#td_text2{
	color:red;
}
.img_info{
	width: 40px;
}
tr:hover{
	background-color: white;
}
</style>
<script type="text/javascript">
function page(pageArg){
	var myform = document.getElementById("myform");
	var pageNo = document.getElementById("pageID");
	pageNo.value = pageArg;
	if(pageArg!=-1){
		myform.submit();
	}else{
		pageNo.value ="";
	}
		
}
function pageSubmit(pageArg){
	var myform = document.getElementById("myform");
	var pageNo = document.getElementById("pageID");
	if(pageNo.value-1 < pageArg){
		pageNo.value=Number(pageNo.value)-1;
		if(pageNo.value>-1){
			myform.submit();
		}else{
			pageNo.value="";
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
<body background="#F3F3F3">
<form action="likeCommodityList.do" method="post" id="myform">
	<div id="div_right">
		<div id="div_login">
			商品管理 > 商品基本信息
			<div id="div_select">
					<select name="selectType">
						<option value="name" ${pageBean.selectType=='name' ? 'selected' : ""}>商品名称</option>
						<option value="commodityNo" ${pageBean.selectType=='commodityNo' ? 'selected' : ""}>商品编号</option>
					</select>
					<input type="text" name="selectInfo" value="${pageBean.selectInfo}"/> 
					<input type="button" value="查找" onclick="page(0)"/>
					<input type="button" value="添加" onclick="location.href='insertCommodityInfo.do?type=1'"/>
			</div>
		</div>
		<table border="1px" cellspacing="0px" cellpadding="5px"
			class="table_txt">
			<tr style="background-color:  #c3dde0;">
					<th></th>
					<th>商品编号</th>
					<th>商品名称</th>
					<th>主图片</th>
					<th>创建时间</th>
					<th>更新时间</th>
					<th>简介</th>
					<th>操作</th>
				</tr>

				<c:forEach items="${comList}" var="key" varStatus="state">
					<tr>
						<td>${state.count}</td>
						<td>${key.commodityNo}</td>
						<td>${key.name}</td>
						<td><img src="<%=basePath%>${key.pictureurl}" class="img_info" /></td>
						<td><spring:eval expression="key.createtime" /></td>
						<td><spring:eval expression="key.updatetime" /></td>
						<td>${key.introduce}</td>
						<td><a href="selectCommodityInfo.do?id=${key.id}">修改</a></td>
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
	</div>
	</form>
</body>
</html>