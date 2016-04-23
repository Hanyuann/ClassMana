<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath }/css/form.css">
	</head>

	<body>
		<div id="container">
			<form
				action="${pageContext.request.contextPath }/servlet/UpdateUserUIServlet"
				method="post">
				<span class="info">登录账号：${requestScope.user.username }</span>
				<input type="hidden" name="username" value="${requestScope.user.username }">
				<br />
				<br />
				<span class="info">账号ID：${requestScope.user.id }</span>
				<input type="hidden" name="id" value="${requestScope.user.id }">
				<br />
				<br />
				<span class="info">用户组：${requestScope.user.type }</span>
				<input type="hidden" name="type" value="${requestScope.user.type }">
				<br />
				<br />
				<div id="button">
					<input type="submit" value="修改密码" class="myButton" />
				</div>
			</form>
			<div id="alert">
				<span>${alert }</span>
			</div>
		</div>
	</body>
</html>
