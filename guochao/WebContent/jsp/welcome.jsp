<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>私人订制——就是这么漂亮</title>
<link rel="stylesheet" type="text/css" href="../css/wel.css">
<script type="text/javascript"src="../js/wel.js"></script>
</head>
<body>
	<%
		if (session.getAttribute("userid") != null) {
	%>
	<div class="h">
		<marquee >
			欢迎<%=session.getAttribute("userid")%>进入本系统
		</marquee>
	</div>
	<div id="nav">

    <ul>

        <li><a href="#" >网站首页</a></li>
        
        <li><a href="#" >个人简介</a></li>
        
        <li><a href="#" >产品展示</a></li>
        
        <li><a href="#" >个人动态</a></li>
        
        <li><a href="#" >个人简历</a></li>
        
        <li><a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=815363734&site=qq&menu=yes">联系我们</a></li>
        
        <li><span onclick="addFavorite()">收藏本站</span></li>   

</ul>   

<!-- <div style="text-align:center"> 
  <button onclick="playPause()">播放/暂停</button> 
  <button onclick="makeBig()">放大</button>
  <button onclick="makeSmall()">缩小</button>
  <button onclick="makeNormal()">普通</button>
  <br> 
  <video id="video1" width="420">
    <source src="../video/3482.mp4" type="video/mp4">
    <source src="../video/3482.ogg" type="video/ogg">
    您的浏览器不支持 HTML5 video 标签。
  </video>
</div>  -->

</div>
<%
Set all = (Set) this.getServletContext().getAttribute("online");
%>
<%= all.size() %>
	<div class="div1">
		<p >留言板</p>
		<textarea class="textarea">
	
	</textarea>
	</div>
	<br/>
	<span id="logout" class="">
	<a href="<%=request.getContextPath() %>/jsp/logout.jsp">注销</a>
	</span>
	<%
		} else {
	%>
	<h3>
		请先进行系统的<a href="../index.jsp">登陆</a>
	</h3>
	<%
		}
	%>

</body>
</html>