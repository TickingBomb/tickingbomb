<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table.hovertable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #E3E3E3;
	border-collapse: collapse;
}

table.hovertable th {
	background-color: #c3dde0;
	border-width: 1px;
	padding: 8px;
	font-size: 11px;
	border-style: solid;
	border-color: #E3E3E3;
}

table.hovertable td {
	/* background-color: #d4e3e5; */
	border-width: 1px;
	padding: 1px;
	font-size: 11px;
	border-style: solid;
	border-color: #E3E3E3;
	text-align: center;
}

.text1 {
	float: right;
}

.sub1 {
	float: right;
}

.select {
	float: right;
	height: 21px;
}
.class2
{
	color:black;
}
.class2:hover
{
	color:red;
}






table.hovertable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #E3E3E3;
	border-collapse: collapse;
}

table.hovertable th {
	background-color: #c3dde0;
	border-width: 1px;
	padding: 8px;
	font-size: 11px;
	border-style: solid;
	border-color: #E3E3E3;
}


table.hovertable td {
	/* background-color: #d4e3e5; */
	border-width: 1px;
	padding: 1px;
	font-size: 11px;
	border-style: solid;
	border-color: #E3E3E3;
	text-align: center;
}
 .text1
{
	float:right;
	
} 
.sub1
{
	float:right;
	
} 
 .select
{
	float:right;
	height:21px;
} 


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
</style>

<script type="text/javascript">
	function updateManagerPassword(id){
		  var flag=confirm("确认重置密码为'123456'？"); 
	       if(flag==true){
	    	  location.href="updateManagerPassword.do?id1="+id;
	      }

	}
	
	function deleteManager(id){
		 var flag=confirm("确认要删除此条信息吗？");
	     if(flag==true){
	    	 location.href="deleteManager.do?id2=" +id;
	     }    
	}

	
	
	
	
	function page(pageArg){
		var myform = document.getElementById("myform");
		var pageNo = document.getElementById("pageID");
		pageNo.value = pageArg;
		myform.submit();
	}
	function pageSubmit(pageArg){
		var myform = document.getElementById("myform");
		var pageNo = document.getElementById("pageID");
		if(pageNo.value-1 < pageArg){
			pageNo.value=Number(pageNo.value)-1;
			if(pageNo.value>-1){
				myform.submit();
			}else{
				pageNo.value=1;
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
<body  background="#F3F3F3" style="font-family: 微软雅黑">

	<form action="addRole.do" method="post">
		<input type="submit" width=15px value="添加" class="sub1">
	</form>
<form action="managersearch.do" method="post" id="myform">
		<img src="/springMVC-helloWorld/img/icon1.png" class="a1">
		  管理员管理 >查看管理员信息
		 <input type="button" width=15px value="检索" class="sub1" onclick="page(0)"> 
		 <input type="text" name="selectInfo" class="text1"  value="${Info}"  placeholder="请输入管理员账号"  />
		<select class="select">
			<option>管理员账号</option>
		</select>
	<br>
	
	<table class="hovertable" width="100%">
		<!-- 头部 -->
		<tr>
			<th>No</th>
			<th>管理员账号</th>
			<th>描述</th>
			<th>创建时间</th>
			<th>更新时间</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<!-- 明细 -->
		<c:forEach items="${clzlistmanager}" var="temp" varStatus="state">
			<!-- <tr onmouseover="this.style.backgroundColor='#ffff66';"
				onmouseout="this.style.backgroundColor='#d4e3e5';"> -->
			<tr>
				<td class="class2">${state.count}</td>
				<td class="class2">${temp.name}</td>
				<td class="class2">${temp.info}</td>
				<td class="class2">${temp.createtime}</td>
				<td class="class2">${temp.updatetime}</td>
				<td class="class2"><c:if test="${temp.status eq 1}">
						<c:set var="status" value="激活"></c:set>
					</c:if> <c:if test="${temp.status eq 2}">
						<c:set var="status" value="禁用"></c:set>
					</c:if> ${status}</td>
				<td ><c:set var="status3" value="修改"></c:set> 
				<a href="modification.do?name=${temp.name}&info=${temp.info}" style="text-decoration: none; color: black" class="class2">${status3 }&nbsp&nbsp</a>
				<a href="relevance.do?name=${temp.name}&managerid=${temp.id}"style="text-decoration: none;" class="class2">关联角色</a> 
				<a href="#"onclick="deleteManager(${temp.id })" style="text-decoration: none; color: black" class="class2">删除</a> 
				<c:set var="status2" value="重置密码"></c:set> 
				<a href="#" onclick="updateManagerPassword(${temp.id})" style="text-decoration: none; color: black" class="class4">${status2 }&nbsp&nbsp</a>
				<c:if test="${temp.status eq 1}">
					<c:set var="status1" value="禁用"></c:set>
					<a href="updateManager.do?id1=${temp.id}&status1=${temp.status}&Info=${Info}&pageNo=${pageBean.pageNo}" style="text-decoration: none; color: #6CB9F1">${status1}</a>
				</c:if> <c:if test="${temp.status eq 2}">
					<c:set var="status1" value="激活"></c:set>
					<a href="updateManager.do?id1=${temp.id}&status1=${temp.status}&Info=${Info}&pageNo=${pageBean.pageNo}" style="text-decoration: none">${status1}</a>
				</c:if></td>
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