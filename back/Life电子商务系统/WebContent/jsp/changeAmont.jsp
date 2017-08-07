<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="changeAmont.do?commodity_no=${commodity_no}" method="post">
		更改库存：<input type="text" name="amont" ><br><br>
		<input type="submit"  value="保存">
	</form>
</body>
</html>