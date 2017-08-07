<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>welcome</title>
<style type="text/css">
table.hovertable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
	width: 100%;
}

table.hovertable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	
	
}


table.hovertable td {
	border-width: 1px;
	padding: 1px;
	border-style: solid;
	
	text-align: center;
}

.checkbox {
	margin-bottom:5px;
	width: 400px;
	float: right;
}
.checkbox1 {
	margin-bottom:5.5px;
	width: 300px;
	float: left;
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
<body bgcolor="#f1f1f1">

<form action="roleInfo.do" method="post" id="myform">
	
	<div class="checkbox1">
	<img src="${pageContext.request.contextPath}/img/icon1.png"
		width="25px" height="25px"> 会员管理&nbsp;>&nbsp;查看角色信息
	</div>
		<div class="checkbox">
			<!-- 下拉框 -->
			<select name="selectType">
				<option value="name" ${pageBean.selectType=='name' ? 'selected' : ""}>角色名称</option>
				<option value="description" ${pageBean.selectType=='description' ? 'selected' : ""}>描述</option>
			</select> 
			<input type="text" name="selectInfo" value="${pageBean.selectInfo }">
			<input type="button" value="搜索" onclick="page(0)"> 
			<a href="insertInfo.do"><input type="button" value="添加" /></a>
		</div>

	<table class="hovertable" width="30%">
		<!-- 头部 -->
		<tr bgcolor="D4E3E5">
			<th></th>
			<th>角色名称</th>
			<th>描述</th>
			<th>创建时间</th>
			<th>修改时间</th>
			<th>操作</th>
			
		</tr>
		<!-- 明细 -->
		<c:forEach items="${rolelist}" var="temp" varStatus="state">
			<tr onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor='#f1f1f1'">
				<td>${state.count}</td>
				<td>${temp.name}</td>
				<td>${temp.description}</td>
				<td><spring:eval expression="temp.createtime" /></td>
				<td><spring:eval expression="temp.updatetime" /></td>
				<td><a href="updateRole.do?id=${temp.id }&name=${temp.name }&description=${temp.description}">修改</a>&nbsp;&nbsp;授权&nbsp;&nbsp;添加菜单</td>
			</tr>
		</c:forEach>
	</table><br>
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

