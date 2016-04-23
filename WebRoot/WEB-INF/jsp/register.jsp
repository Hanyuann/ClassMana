<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>注册</title>
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath }/css/register.css">
		<script type="text/javascript">
            function changeImage(img){
                img.src = img.src + "?" + new Date().getTime();
            }
	</script>
	</head>

	<body>
		<div id="container">
			<div id="container2">
				<div id="title">
					注册须知：
					<br />
				</div>
				<div id="text">
					1:本站主要面向管理员，教师，学生三类用户开放，旨在为教室安排使用提供方便，管理员与教师不对外提供注册，学生作为普通用户
					<br />
					注册后可以实现查看教室信息，预约教室。
					<br />
					2:本站管理员有权利管理其他用户信息，教室预约信息必须经过管理员审核后方可通过。
					<br />
					3:本站教师用户由管理员内部注册。
					<br />
				</div>
				<form action="RegisterServlet" method="post">
					<div id="userinfo">
						<span class="info">登录账号：</span>
						<input type="text" name="username" class="txt" value="${form.username }"/>
						<span class="info">用户名由3-8位字符组成</span> <span class="message">${form.errors.username }</span>
						<br />
						<span class="info">输入密码：</span>
						<input type="password" name="password" class="txt" value="${form.password }"/>
						<span class="info">密码由3-8位字母或数字组成</span>  <span class="message">${form.errors.password }</span>
						<br />
						<span class="info">确认密码：</span>
						<input type="password" name="password2" class="txt" value="${form.password2 }"/>
						<span class="message">${form.errors.password2 }</span>
						<br />
						<span class="info">图片认证：</span>
						<input type="text" name="checkcode" class="txt" value="${form.checkcode }"/>
						<span class="info">请输入下方的验证码</span>  <span class="message">${form.errors.checkcode }</span>
						<br>
						<img
							src="${pageContext.request.contextPath }/servlet/ImageServlet"
							onClick="changeImage(this)" alt="换一张" style="cursor: hand"
							id="image" />
						<br />
						<div id="button">
							<input type="reset" value="重置" class="myButton" />
							<input type="submit" value="注册" class="myButton" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
