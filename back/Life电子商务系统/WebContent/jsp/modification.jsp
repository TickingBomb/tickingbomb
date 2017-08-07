<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

#submit_id{
	width:172px;
	height:32px;
	background-color: #606E83;
	color:#FFFFFF;
	float:left;
	margin-left:88px;
}
.div1{
	width:500px;
	height:200px;
}
#text_id1{
    width:172px;
	height:28px;
}
#text_id2{
    width:172px;
	height:28px;
}


</style>
</head>
<body background="#F3F3F3" style="font-family: 微软雅黑">
 <div class ="div1">
<font id = "font_id">管理员管理>查看管理员信息>修改管理员信息
 <a href = "return.do">返回</a>
 </font><br><br><br>
<form action="modification1.do">
	管理员账号:&nbsp<input type = "text" name = "name"  readonly = "readonly" id ="text_id1" value ="${name}"><br><br>
	&nbsp&nbsp&nbsp管理描述:&nbsp<input type= "text" name = "info"  id ="text_id2" value="${info}"><br><br>
	            <input type = "submit" value = "提交" id = "submit_id">

</form>
</div>


</body>
</html>