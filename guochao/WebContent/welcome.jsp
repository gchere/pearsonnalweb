<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>私人订制——就是这么漂亮</title>
<link rel="stylesheet" type="text/css" href="../css/wel.css">
</head>
<body>
	<%
		if (session.getAttribute("userid") != null) {
	%>
	<div class="h">
		<marquee vspace=50>
			欢迎<%=session.getAttribute("userid")%>进入本系统
		</marquee>
	</div>
	<div id="nav">

    <ul>

        <li><a href="#" />网站首页</a></li>
        <li><a href="#" />个人简介</a></li>
        <li><a href="#" />产品展示</a></li>
        <li><a href="#" />个人动态</a></li>
        <li><a href="#" />个人简历</a></li>
        <li><a href="#" />联系我们</a></li>
        <li><a href="#" />收藏本站</a></li>   

</ul>   

</div>
	<div class="div1">
		<p >留言板</p>
		<textarea class="textarea">
	
	</textarea>
	</div>
	<br/>
	<span id="logout" class="">
	<a href="<%=request.getContextPath() %>/logout.jsp">注销</a>
	</span>
	<%
		} else {
	%>
	<h3>
		请先进行系统的<a href="/index.jsp">登陆</a>
	</h3>
	<%
		}
	%>

</body>
</html>