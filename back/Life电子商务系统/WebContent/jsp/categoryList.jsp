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
	font-family: "微软雅黑";
	font-size: 12px;
	height: 20px;
	border: 0.1px solid black;
	text-align: center;
	width: 100%;
}

table.hovertable th {
	background-color: #c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

table.hovertable td {
	/* background-color: #d4e3e5;  */
	border-width: 1px;
	padding: 1px;
	font-size: 11px;
	border-style: solid;
	border-color: #E3E3E3;
	text-align: center;
}
.headmanager{
	font-family: "微软雅黑";
	font-size: 17px;
	height: 20px;
}
.like{

	margin-left: 1322px;
	margin-top: -20px;
}
.div_info_all_text {
	font-size: 12px;
	margin-top: 7px;
	float: right;
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
.table_txt {
	font-family: "微软雅黑";
	font-size: 12px;
	height: 20px;
	border: 0.1px solid gray;
	text-align: center;
	width: 100%
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
	function page(pageArg,type){
		var myform1 = document.getElementById("myform1");
		var myform2 = document.getElementById("myform2");
		var myform3 = document.getElementById("myform3");
		var pageNo1 = document.getElementById("pageID1");
		var pageNo2 = document.getElementById("pageID2");
		var pageNo3 = document.getElementById("pageID3");
		if(type==1){
			pageNo1.value = pageArg;
			myform1.submit();
		}
		else if(type==2){
			pageNo2.value = pageArg;
			myform2.action="selectPageLikeByName2.do?pageNo="+pageArg;
			myform2.submit();
		}
		else{
			pageNo3.value = pageArg;
			myform3.action="selectPageLikeByName3.do?pageNo="+pageArg;
			myform3.submit();
		}
		
	}
	function pageSubmit(pageArg,type){
		var myform1 = document.getElementById("myform1");
		var myform2 = document.getElementById("myform2");
		var myform3 = document.getElementById("myform3");
		var pageNo1 = document.getElementById("pageID1");
		var pageNo2 = document.getElementById("pageID2");
		var pageNo3 = document.getElementById("pageID3");
		if(pageNo1.value!=""&&pageNo1.value!=null){
		if(type==1)
		{
			if(pageNo1.value-1 < pageArg){
				pageNo1.value=Number(pageNo1.value)-1;
				if(pageNo1.value>-1){
					myform1.submit();
				}
				else{
					pageNo1.value="";
				}
			}
		}
		}
		else if(pageNo2.value!=""&&pageNo2.value!=null){
		if(type==2){
			if(pageNo2.value-1 < pageArg){
				pageNo2.value=Number(pageNo2.value)-1;
				if(pageNo2.value>-1){
					myform2.action="selectPageLikeByName2.do";
					myform2.submit();
				}
				else{
					pageNo2.value="";
				}
			}
		}
		}
		else if(pageNo3.value!=""&&pageNo3.value!=null){
		
			if(pageNo3.value -1< pageArg){
				pageNo3.value=Number(pageNo3.value)-1;
				if(pageNo3.value>-1){
					myform3.action="selectPageLikeByName3.do";
					myform3.submit();
				}
				else{
					pageNo3.value="";
				}
			}
		}
	}
	
	function nextPage(pageArg,totalPage,type){
		var myform1 = document.getElementById("myform1");
		var myform2 = document.getElementById("myform2");
		var myform3 = document.getElementById("myform3");
		var pageNo1 = document.getElementById("pageID1");
		var pageNo2 = document.getElementById("pageID2");
		var pageNo3 = document.getElementById("pageID3");
		
		if(pageArg<totalPage){
			if(type==1){
				pageNo1.value = pageArg;
				myform1.submit();
			}
			else if(type==2){
				pageNo2.value = pageArg;
				myform2.action="selectPageLikeByName2.do?pageNo="+pageArg;
				myform2.submit();
			}
			else{
				pageNo3.value = pageArg;
				myform3.action="selectPageLikeByName3.do?pageNo="+pageArg;
				myform3.submit();
			}
		}
			
	}
	

</script>	
</head>
<body >

	<div style="width:100%;overflow:auto;"class="headmanager">商品管理      > 分类管理</div>
	
	<div class="like">	
		<select name="type" class="textarea" id="select" value="${like}">
			<option selected value="1">分类名称</option>
			<option value="2">分级</option>
		</select>
			<input type="text" class="input" id="input"></input>
			<input type="button" onclick="search()" value="搜索"></input>
			<input type="button" onclick="location.href='addCategory.do'" value="添加"></input>
	</div>
	<hr color="#E6E6E7" size="1">
	<form action="selectPageLikeByName1.do" method="post" id="myform1">
	<div>
		<table class="table_txt" border="1px" width="100%" cellspacing="0px" cellpadding="5px" >
			<tr style="background-color:  #c3dde0;">
				<th></th>
				<th>分类名称</th>
				<th>分级</th>
				<th>一级分类ID</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${categorylist1}" var="temp" varStatus="state">
			<tr>
				<td>${state.count}</td>
				<td> ${temp.categoryname} </td>
				<td> ${temp.type} </td>
				<td>${temp.id}</td>
			<!-- 	<input type="hidden" name="type" value="1"/> -->
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
				共 <span class="span_txt">${pageBean1.totalCount}</span> 条结果，分成 
				  <span class="span_txt">${pageBean1.totalPage}</span>页显示，当前第
				  <span class="span_txt">${pageBean1.pageNo+1}</span>页
			</div>
			<div class="div_input">
					<input type="button" class="input_scan" value="首页" onclick="page(0,1)"/> 												
					<c:if test="${pageBean1.previous}">
					<input type="button" class="input_scan" value="上页" onclick="page(${pageBean1.pageNo - 1},1)"/> 
					</c:if>
					<c:if test="${pageBean1.next}">
					<input type="button" class="input_scan" value="下页" onclick="nextPage(${pageBean1.pageNo + 1},${pageBean1.totalPage},1)"/>
					</c:if>
					<input type="button" class="input_scan" value="末页" onclick="page(${pageBean1.totalPage -1},1)"/> 
					<span class="span_text">跳到第</span>
					<input type="text" class="input_text" name="pageNo" id="pageID1" value="${pageBean1.pageNo + 1}"/>
					<%-- <input type="hidden" name="pageNo" id="pageID1" value="${pageBean1.pageNo}"/> --%>
					<span class="span_text">页</span> 
					<input type="button" class="input_scan" value="跳转" onclick="pageSubmit(${pageBean1.totalPage},1)"/>
			</div>
		</div>
	</form>
	<br><br>
	<form  method="post" id="myform2">
	<div>
		<table class="table_txt" border="1px"  width="100%" cellspacing="0px" cellpadding="5px" >
			<tr style="background-color:  #c3dde0;">
				<th></th>
				<th>分类名称</th>
				<th>分级</th>
				<th>二级分类名称</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${categorylist2}" var="temp" varStatus="state">
			<tr>
				<td>${state.count}</td>
				<td> ${temp.categoryname} </td>
				<td> ${temp.type} </td>
				<td> ${temp.parentname}</td>
				<td><a href="jumpToUpdate.do?id=${temp.id}" style="color:blue;text-decoration:none">修改 </a>
				<a onclick="javascript:deleteByPK(${temp.id})" style="color: red ;text-decoration:none"> 删除</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<div class="div_info_all">
			<div class="div_info_all_text">
				共 <span class="span_txt">${pageBean2.totalCount}</span> 条结果，分成 
				  <span class="span_txt">${pageBean2.totalPage}</span>页显示，当前第
				  <span class="span_txt">${pageBean2.pageNo+1}</span>页
			</div>
			<div class="div_input">
					<input type="button" class="input_scan" value="首页" onclick="page(0,2)"/> 												
					<c:if test="${pageBean2.previous}">
					<input type="button" class="input_scan" value="上页" onclick="page(${pageBean2.pageNo - 1},2)"/> 
					</c:if>
					<c:if test="${pageBean2.next}">
					<input type="button" class="input_scan" value="下页" onclick="nextPage(${pageBean2.pageNo + 1},${pageBean2.totalPage},2)"/>
					</c:if>
					<input type="button" class="input_scan" value="末页" onclick="page(${pageBean2.totalPage -1},2)"/> 
					<span class="span_text">跳到第</span>
					<input type="text" class="input_text" name="pageNo" id="pageID2" value="${pageBean2.pageNo + 1}"/>
					<%-- <input type="hidden" name="pageNo" id="pageID2" value="${pageBean2.pageNo}"/> --%>
					<span class="span_text">页</span> 
					<input type="button" class="input_scan" value="跳转" onclick="pageSubmit(${pageBean2.totalPage},2)"/>
			</div>
		</div>
	</form>
	<br><br>
	<form  method="post" id="myform3">
	<div>
		<table class="table_txt" border="1px"  width="100%" cellspacing="0px" cellpadding="5px" >
			<tr style="background-color:  #c3dde0;">
				<th></th>
				<th width="23.5%">分类名称</th>
				<th>分级</th>
				<th>三级分类名称</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${categorylist3}" var="temp" varStatus="state">
			<tr>
				<td>${state.count}</td>
				<td> ${temp.categoryname} </td>
				<td> ${temp.type} </td>
				<td>${temp.parentname}</td>
				 
				<!-- <input type="hidden" name="type" value="3"/> -->
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
				共 <span class="span_txt">${pageBean3.totalCount}</span> 条结果，分成 
				  <span class="span_txt">${pageBean3.totalPage}</span>页显示，当前第
				  <span class="span_txt">${pageBean3.pageNo+1}</span>页
			</div>
			<div class="div_input">
					<input type="button" class="input_scan" value="首页" onclick="page(0,3)"/> 												
					<c:if test="${pageBean3.previous}">
					<input type="button" class="input_scan" value="上页" onclick="page(${pageBean3.pageNo - 1},3)"/> 
					</c:if>
					<c:if test="${pageBean3.next}">
					<input type="button" class="input_scan" value="下页" onclick="nextPage(${pageBean3.pageNo + 1},${pageBean3.totalPage},3)"/>
					</c:if>
					<input type="button" class="input_scan" value="末页" onclick="page(${pageBean3.totalPage -1},3)"/> 
					<span class="span_text">跳到第</span>
					<input type="text" class="input_text" name="pageNo" id="pageID3" value="${pageBean3.pageNo + 1}"/>
				<%-- 	<input type="hidden" name="pageNo" id="pageID3" value="${pageBean3.pageNo}"/> --%>
					<span class="span_text">页</span> 
					<input type="button" class="input_scan" value="跳转" onclick="pageSubmit(${pageBean3.totalPage},3)"/>
			</div>
		</div>
	</form>
</body>
</html>