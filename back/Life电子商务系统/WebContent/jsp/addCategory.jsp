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
	background-color: #F1F1F1;
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
.like{
	margin-left: 20px;
	margin-top: 20px;
}
.select{
	width: 215px;
	height: 28px;
}
.input{
	width: 210px;
	height: 28px;
}
.sure{
	font-size:16px;
	color:white;
	background-color:grey;
	width: 210px;
	height: 34px;
}

</style>
<script src="<%=basePath%>js/easyui/jquery.min.js" type="text/javascript"></script>									

<script type="text/javascript">
 
	function change(value){						
		var id_1=value; 
		if(id_1==""){
			$("#id_2").empty();				
			$("#id_2").append("<option value=''>--请选择所属类别--</option>");				
			//$("#id_3").empty();				
			//$("#id_3").append("<option value=''>--请选择--</option>");				
		}else{
			location.href="selectByTypes.do?type="+id_1;
		}
	};
	
 	function submit(){
 		
		var ret= document.getElementById("input").value;
	 	 var selectType=document.getElementById("type").value;  
	 /* 	var selectType=id_1; */
		var parentId=document.getElementById("id_2").value;
	 if(ret!=""){
		 if(selectType=="" || parentId==1){
				location.href="insertCategory.do?categoryTypeName=" + ret+"&selectType="+1+"&parentId=";
		 }else{
				location.href="insertCategory.do?categoryTypeName=" + ret+"&selectType="+selectType+"&parentId="+parentId;
		 }
	
	}else{
		alert("请添加商品名称");
	} 
 	}
	
</script>	
</head>
<body >
	<div style="width:100%;overflow:auto;" class="headmanager">商品管理      > 分类管理      > 添加商品分类     <a href="javascript:history.back()" style="text-decoration:none">返回</a></div>
	<hr color="#E6E6E7" size="1">
	
	<div class="like">
		<table>
			<tr>
				<td>级别：</td>
				<td> <select class="select" name="id_1" id="id_1" onchange="change(value)"> 
			<!-- 	<select class="select" name="id_1" id="id_1">  -->
					<option value="">分类级别</option>
					<option value="1" >一级分类</option>
					<option value="2" >二级分类</option>
					<option value="3" >三级分类</option>
				</select>
				 </td>
				 <td>
				 <select name="id_2" id="id_2">
				 <option value="" disabled="disabled">所属分类级别</option>
				 <c:forEach items="${categoriesList}" var="cate">
				 <option value="${cate.id}"> ${cate.categoryname}</option>
				 </c:forEach>
				 </select>
				 </td>
			</tr>
			<tr>
				<td>类别名称：</td>
				<td><input type="text" class="input" id="input" name="categoryTypeName" ></td>
				<td><input type="hidden" id="type" value="${types}"></td>
			</tr>
		</table>
		<input type="button" class="sure" value="保    存" onclick="submit()"> 
	</div>
	
	
</body>
</html>