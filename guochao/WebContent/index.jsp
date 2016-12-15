<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全球最好看的的个人页面</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">
</script>
<script type="text/javascript" src="js/index.js"></script>

</head>
<body style="background-image: url('image/bg.jpg');">
	<div class="firstDiv">
		<h1 class="h" id="blink">Login</h1>
	</div>
	<center>
		<div class="sndDiv">
			<form action="<%=request.getContextPath() %>/servlet/Check" method="post"
				style="width: 100%; text-align: center;">
				<input name="uname" type="text" placeholder="userName" onfocus="removedis()"
				onblur="adddis()"> <br />
				<span class="span dis" id="span">请输入用户名:由字母、数字、下划线组成</span> <br /> <input
					name="upass" type="password" placeholder="passWord"> <br />
					<span class="span"><a href="forgetps.jsp">忘记密码</a></span>
				<br /> <input id="login" class="input2" type="submit" value="Login"
					onmousemove="mn()" onmouseout="mout()"> 
					<br /> <br />
				<button class="input2" id="button" onmousemove="mn1()"
					onmouseout="mout1()"><a hover="color:orange;" href="register.jsp"style="text-decoration: none; color: black;">register</a></button>
					
			
				</table>
			</form>
		</div>
	</center>
	<img  class="image dis" id="ps" alt="ps" src="image/4.jpg">
	

</body>
</html>