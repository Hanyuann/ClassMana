<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath }/css/form.css">
	</head>

	<body>
		<div id="container">
			<form
				action="${pageContext.request.contextPath }/servlet/UpdateUserServlet"
				method="post">
				<input type="hidden" name="id" value="${user.id }">
				<input type="hidden" name="username" value="${user.username }">
				<input type="hidden" name="type" value="${user.type }"> 
				<span class="info">请输入您的密码：</span>
				<input type="password" name="oldpassword" class="txt"
					value="${form.oldpassword }" />
				<span class="message">${form.errors.oldpassword }</span>
				<br />
				<span class="info">请输入您的新密码：</span>
				<input type="password" name="password" class="txt"
					value="${form.password }" />
				<span class="message">${form.errors.password }</span>
				<br />
				<span class="info">确认新密码：</span>
				<input type="password" name="password2" class="txt"
					value="${form.password2 }" />
				<span class="message">${form.errors.password2 }</span>
				<div id="button">
					<input type="reset" value="重  置" class="myButton" />
					<input type="submit" value="确认更改" class="myButton" />
				</div>
			</form>
		</div>
	</body>
</html>
