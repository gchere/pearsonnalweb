<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎你下次再来！</title>
<link rel="stylesheet" type="text/css" href="../css/wel.css">
</head>
<body>
	<%
response.setHeader("refresh", "2;../index.jsp");
session.invalidate();
%>
	<h3 class="h">您已成功退出，2秒后跳转到登陆页面</h3>

</body>
</html>