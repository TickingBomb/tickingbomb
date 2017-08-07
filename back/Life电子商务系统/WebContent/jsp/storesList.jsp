<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.colorchange:hover{color:red;}
a:hover{color:red;}

	.div1{
		/* margin-left: 700px; */
		
		float:right;
		}
	.div2{
		float:left;
		}
</style>
</head>

<body style="font-family:微软雅黑;font-size:15px">
		<div class="div2">门店管理	> 门店信息</div>
<form action="searchStore.do" method="post">
	<div class="div1">
		<select name="storeSelect">
			<option value="门店名称">门店名称</option>
			<option value="门店编号">门店编号</option>
		</select>
		<input type="text" name="storeName">
		<input type="hidden" name="pageNow" value="${page.pageNow }">
		<input type="submit" value="查询">
		<!-- <button onclick="window.location.href='AddStore.do';" style="text-decoration: none;color:black" >添加</button> -->
		<input type="button" value="添加" onclick="location.href='AddStore.do?clazz=1&pageNow=${page.pageNow}'">
	</div>
</form>
	<table  class="table" width="100%"  border="1" align="center" bordercolor="#E4E4E4" cellspacing="0" style="text-align: center;">
		<!-- 头部 -->
		<tr  bgcolor="#c3dde0">
			<th> </th>
			<th  class="colorchange">门店编号</th>
			<th class="colorchange">门店名称</th>
			<th class="colorchange">门店地址</th>
			<th class="colorchange">状态</th>
			<th class="colorchange">操作</th>
		</tr>
		<!-- 明细 -->
		<c:forEach items="${storeslist}" var="temp" varStatus="state">
			<tr>
				<td class="colorchange">${state.count}</td>
				<td class="colorchange">${temp.store_no}</td>
				<td class="colorchange">${temp.storename}</td>
				 <td class="colorchange">${temp.storeaddress}</td>
				 <c:choose>
				 <c:when test="${temp.status == 1}">
				 <td class="colorchange">已启用</td>
				 </c:when>
				  <c:otherwise>
				  <td class="colorchange">已禁用</td>
				  </c:otherwise>
				 </c:choose>
				 <c:choose>
				 <c:when test="${temp.status == 1}">
				 <td>
				 	<a href="store_modify.do?store_no=${temp.store_no}&province_id=${temp.province_id}&citys_id=${temp.citys_id}&county_id=${temp.county_id}" style="text-decoration: none;color:#B4BAC2">修改</a>
				 	<a href="store_operate.do?pageNow=${page.pageNow }&store_no=${temp.store_no}&status=2" style="text-decoration: none;color:red">禁用</a>
				 </td>
				 </c:when>
				  <c:otherwise>
				  <td>
					  <a href="store_modify.do?store_no=${temp.store_no}&province_id=${temp.province_id}&citys_id=${temp.citys_id}&county_id=${temp.county_id}" style="text-decoration: none;color:#B4BAC2">修改</a>
					  <a href="store_operate.do?pageNow=${page.pageNow }&store_no=${temp.store_no}&status=1" style="text-decoration: none; color:blue">启用</a>
				  </td>
				  </c:otherwise>
				 </c:choose>
				
				
			</tr>
		</c:forEach>
	</table>
<form action="skipStore.do">	
	<!-- 分页功能 start -->  
    <div align="center">  
        <font size="2">共 ${page.totalPageCount} 页</font>
         <font size="2">第 ${page.pageNow} 页</font> 
         <a href="storesList.do?pageNow=1&store_no=${stores.store_no}&storename=${stores.storename}">首页</a>  
        	<!-- 当  当前页大于1时——有上一页，当当前页小于等于1时————第一页 -->
        <c:choose>  
            <c:when test="${page.pageNow - 1 > 0}">  
                <a href="storesList.do?pageNow=${page.pageNow - 1}&store_no=${stores.store_no}&storename=${stores.storename}">上一页</a>  
            </c:when>  
            <c:when test="${page.pageNow - 1 <= 0}">  
                <a href="storesList.do?pageNow=1"></a>  
            </c:when>  
        </c:choose>  
        	<!-- 当总页数，当当前页加1小于总页数时，点击跳转下一页，当前页加1 -->
        	<!-- 当当前页加1大于总页数，则跳转到最后一页 -->
        <c:choose>  
            <c:when test="${page.pageNow  < page.totalPageCount}">  
                <a href="storesList.do?pageNow=${page.pageNow +1}&store_no=${stores.store_no}&storename=${stores.storename}">下一页</a>  
            </c:when>  
            <c:when test="${page.pageNow + 1 >= page.totalPageCount}">  
                <a href="storesList.do?pageNow=${page.totalPageCount}"></a>  
            </c:when>  
        </c:choose>  
        <a href="storesList.do?pageNow=${page.totalPageCount}&store_no=${stores.store_no}&storename=${stores.storename}">尾页</a> 
       
        	<input type="text" name="skipPage" style="width:15px;height:15px">
        	<input type="hidden" name="totalPage" value="${page.totalPageCount}">
        	<input type="submit" value="跳转">
        
    </div>  
</form>
</body>
</html>