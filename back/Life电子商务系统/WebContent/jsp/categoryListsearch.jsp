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
	background-color: #c3dde0;
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
.headmanager{
	font-family: "微软雅黑";
	font-size: 17px;
	height: 20px;
}
.div_info_all_text {
	font-size: 12px;
	margin-top: 7px;
	float: right;
}
.like{

	margin-left: 1322px;
	margin-top: -20px;
}
.table_txt {
	font-family: "微软雅黑";
	font-size: 12px;
	height: 20px;
	border: 0.1px solid gray;
	text-align: center;
	width: 100%
}
.span_text {
	font-family: "微软雅黑";
	font-size: 12px;
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
tr:hover{
	background-color: white;
}

</style>
<script type="text/javascript">
function search(){
	var ret= document.getElementById("input").value;
	var like= document.getElementById("select").value;
	if(ret!=null&&ret!=""){
		location.href="selectByName.do?name=" + ret+"&like="+like;
	}
	
}
function deleteByPK(id){
	var ret=confirm(id+"确定删除");
	if(ret){
		location.href="delete.do?id="+ id;
}
	else{
		location.href="categoryList.do";
	}
	
}
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
<body >
	<div style="width:100%;overflow:auto;" class="headmanager">商品管理      > 分类管理   >搜索商品</div>
	
	<div class="like">	
		<select name="type" class="textarea" id="select" >
			<option value="1">分类名称</option>
			<option value="2">分级</option>
		</select>
			<input type="text" class="input" id="input"></input>
			<input type="button" onclick="search()" value="搜索"></input>
			<input type="button" onclick="location.href='addCategory.do'" value="添加"></input>
	</div>
	<hr color="#E6E6E7" size="1">
	
	<div>
		<table class="table_txt" border="1px" width="100%" cellspacing="0px" cellpadding="5px" >
			<tr style="background-color:  #c3dde0;">
				<th></th>
				<th>分类名称</th>
				<th>分级</th>
				<th>商品分类ID</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${categorylist}" var="temp" varStatus="state">
			<tr>
				<td>${state.count}</td>
				<td> ${temp.categoryname} </td>
				<td> ${temp.type} </td>
				<td>${temp.id}</td>
				<td><a href="jumpToUpdate.do?id=${temp.id}" style="color:blue;text-decoration:none">修改 </a>
				<a onclick="javascript:deleteByPK(${temp.id})" style="color:red;text-decoration:none"> 删除</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<br>
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
</body>
</html>