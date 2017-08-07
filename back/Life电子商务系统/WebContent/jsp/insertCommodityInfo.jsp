<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		hr{
			float: left;
			width: 1000px;
		}
		.top_box{
			width: 1000px;
			float:left;
			margin-top: 10px;
			margin-bottom: 10px;
		}
		.table_info{
			width: 500px;
			height:30px;
			float:left;
		}
		.td_txt{
			width: 80px;
		}
		.input_sunmit{
			width: 200px;
			height: 30px;
			font-size: 20px;
			color: white;
			background-color: grey;
			border: 1px solid grey;
		}
	</style>
	<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
      	  $("#firstInfo").change(function(){
      		var info=$("#firstInfo").val();
      		$("#secondInfo").html("");
           	$.get("secondInfo.do",{info:info},function(data) {
                var strInfo=data.split("#");
            	for(var i=0;i<strInfo.length;i++){
            		var arr=strInfo[i].split(":");
            		$('#secondInfo').append('<option value="' + arr[0] + '">' + arr[1] + '</option>');
            	}
            });
        });
      	  
      	 $("#secondInfo").change(function(){
      		var info=$("#secondInfo").val();
      		$("#thirdInfo").html("");
           	$.get("secondInfo.do",{info:info},function(data) {
                var strInfo=data.split("#");
            	for(var i=0;i<strInfo.length;i++){
            		var arr=strInfo[i].split(":");
            		$('#thirdInfo').append('<option value="' + arr[0] + '">' + arr[1] + '</option>');
            	}
            });
        });
    });
	</script>
	</head>
	<body background="#F3F3F3">
		<form action="insertCommodity.do" method="post">
		<div class="top_box">
			<span>商品管理&nbsp;&nbsp;>&nbsp;&nbsp;商品基本信息&nbsp;&nbsp;>&nbsp;&nbsp;信息添加</span>
			<a href="commodityList.do">返回</a>
		</div>
	<hr>
	<div class="top_box">
	<table class="table_info">
		<tr>
			<td class="td_txt">商品编号：</td>
			<td>
				<input type="text" name="commodityNo" />
			</td>
		</tr>
		<tr>
			<td class="td_txt">商品名称：</td>
			<td>
				<input type="text" name="name" />
			</td>
		</tr>
	</table>
	</div>
	<hr>
	<div class="top_box"> 
	类别信息：
	
	<select name="firstInfo" id="firstInfo">
	<c:forEach items="${catList}" var="key" >
		<option value="${key.id}">${key.categoryname}</option>
	</c:forEach>
	</select>
	<select name="secondInfo" id="secondInfo">
		<option>二级分类</option>
	</select>
	<select name="thirdInfo" id="thirdInfo">
		<option>三级分类</option>
	</select>
	</div>
	<hr>
	<div class="top_box"> 
	商品简介：
	<br>
	<textarea cols="150" rows="7" name="introduce"></textarea>
	</div>
	<hr>
	<div class="top_box"> 
	<center>
		<input type="submit" value="保存信息" class="input_sunmit"/>
	</center>
	</div>
	</form>
	</body>
</html>