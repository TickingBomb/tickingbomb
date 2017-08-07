<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<title>Insert title here</title>
<style type="text/css">
	.size{
		
		font-size: 13px;
		font-family: "微软雅黑";
		background-color:  #c3dde0;
	}

	.so{
		margin-left: 10%;
	}
	.a1:hover{
		background: orange;
		color: white;
		border: none;
	}
	.a2:hover{
		background: orange;
		color: white;
		border: none;
	}
	.a1{
		border-radius:6px;
		background: white;
		border-bottom-color: #D6D6D6;
		margin-left: 40%;
	}
	.a2{
		border-radius:6px;
		background: white;
		border-bottom-color: #D6D6D6;
		
	}
	.ch_1{
		color:white;
		background: red;
		border-radius:6px;
	}
	.men_1{
		width: 130px;
		height: 23px;
	}
	form{margin:0px;display: inline}
	tr:hover{
	background-color: white;
}
.div_info_all_text {
	font-size: 12px;
	margin-top: 7px;
	float: right;
}
.div_input {
	float: left;
	margin-right: 5px;
}
.input_text {
	width: 25px;
	height: 13px;
}
.span_text {
	font-family: "微软雅黑";
	font-size: 12px;
}
.span_txt {
	font-weight: bold;
	margin-left: -3px;
}
</style>
<script type="text/javascript">
function page(pageArg){
	var myform = document.getElementById("myform");
	var pageNo = document.getElementById("pageID");
	pageNo.value = pageArg>=0?pageArg:pageArg+1;
	myform.submit();
}
function pageSubmit(pageArg){
	var myform = document.getElementById("myform");
	var pageNo = document.getElementById("pageID");
	if(pageNo.value>0&&pageNo.value<= pageArg){
		pageNo.value=Number(pageNo.value)-1;
		if(pageNo.value < pageArg){
			if(pageNo.value>-1){
				myform.submit();
			}
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
function fun(){
	var myform = document.getElementById("myform");
	var pageNo = document.getElementById("pageID");
	pageNo.value = 0;
	myform.submit();
}
function resetAll(){
	document.getElementById("nameid").innerHTML="";
	document.getElementById("starttime").value="";
	document.getElementById("closetime").value="";
	document.getElementById("selectInfo").value="";
}
</script>
</head>
<body bgcolor="#F3F3F3">
	<form action="statisticsCommodities.do?state=2"  method="post">
		<input type="submit" value="商品销售排行" class="a1" />
	</form>
	
	<form  action="statisticsCommoditiesWithPageview.do?state=2" method="post">
		
		<input type="submit" value="商品访客排行" class="a2"/>
	</form><br>
	<form class="so" action="selectWithPageviewByCondition.do?state=2" method="post" id="myform">
		门店名称：<select class="men_1" name="storename">
				<option id="nameid">${pageBean.storename}</option>
				<c:forEach items="${storelist}" var="temp1" varStatus="state">
					<option>${temp1.storename }</option>
				</c:forEach>
			   </select>
				
					开始时间：<input type="time" name="starttime" id="starttime" value="${pageBean.starttime}"/>
					结束时间：<input type="time" name="closetime" id="closetime" value="${pageBean.closetime}"/>
			   
	<select>
		<option>商品编号</option>
	</select>
	<input type="text" name="selectInfo" id="selectInfo" value="${pageBean.selectInfo}">
	<input type="button" value="搜索" class="ch_1" onclick="fun()">
	<input type="button" class="ch_1" onclick="resetAll()" value="重置">
	<table  border="1" width="100%" cellpadding="1" cellspacing="0" bordercolor="#E0E0E0" >
		<tr style="background-color:  #c3dde0;">
			<th></th>
			<th>商品编号</th>
			<th>商品介绍</th>
			<th>浏览量</th>
			
		</tr>
		<c:forEach items="${list}" var="temp" varStatus="state">
			<tr>
				<th>${state.count }</th>
				<th>${temp.commodity_no }</th>
				<th>${temp.introduce }</th>
				<th>${temp.acount }</th>
			</tr>
		</c:forEach>
	</table><br>
	<div class="div_info_all">
			<div class="div_input">
				<input type="button" class="input_scan" value="首页" onclick="page(0)" />
				<c:if test="${pageBean.previous}">
					<input type="button" class="input_scan" value="上页"
						onclick="page(${pageBean.pageNo - 1})" />
				</c:if>
				<c:if test="${pageBean.next}">
					<input type="button" class="input_scan" value="下页"
						onclick="nextPage(${pageBean.pageNo + 1},${pageBean.totalPage})" />
				</c:if>
				<input type="button" class="input_scan" value="末页"
					onclick="page(${pageBean.totalPage -1})" /> <span class="span_text">跳到第</span>
				<input type="text" class="input_text" name="pageNo" id="pageID" /> <span
					class="span_text">页</span> <input type="button" class="input_scan"
					value="跳转" onclick="pageSubmit(${pageBean.totalPage})" />
			</div>
			<div class="div_info_all_text">
				共 <span class="span_txt">${pageBean.totalCount}</span> 条结果，分成 <span
					class="span_txt">${pageBean.totalPage}</span>页显示，当前第 <span
					class="span_txt">${pageBean.pageNo+1}</span>页
			</div>
		</div>
	</form>
</body>
</html>