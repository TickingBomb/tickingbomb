<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="changePrice.do?commodity_no=${commodity_no}" method="post">
		现价<input type="text" name="commodityprice" ><br><br>
		原价<input type="text" name="realprice" ><br><br>
		<input type="submit"  value="保存">
	</form>
</body>
</html>