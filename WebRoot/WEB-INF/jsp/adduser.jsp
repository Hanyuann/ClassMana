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
				action="${pageContext.request.contextPath }/servlet/AddUserServlet"
				method="post">
				<span class="info">登录账号：</span>
				<input type="text" name="username" class="txt"
					value="${form.username }" />
				<span class="info">用户名由3-8位字符组成</span>
				<span class="message">${form.errors.username }</span>
				<br />
				<span class="info">输入密码：</span>
				<input type="password" name="password" class="txt"
					value="${form.password }" />
				<span class="info">密码由3-8位字母或数字组成</span>
				<span class="message">${form.errors.password }</span>
				<br />
				<span class="info">确认密码：</span>
				<input type="password" name="password2" class="txt"
					value="${form.password2 }" />
				<span class="info">请再次输入密码</span>
				<span class="message">${form.errors.password2 }</span>
				<br />
				<span class="info">用户类型：</span>
				<select name="type" class="txt">
					<option value="admin" ${form.type=='admin'?'selected':'' }>
						管理员
					</option>
					<option value="teacher" ${form.type=='teacher'?'selected':'' }>
						教师
					</option>
					<option value="student" ${form.type=='student'?'selected':'' }>
						学生
					</option>
				</select>
				<span class="info">请选择用户类型</span>
				<span class="message">${form.errors.type }</span>
				<br />
				<div id="button">
					<input type="reset" value="重  置" class="myButton" />
					<input type="submit" value="注  册" class="myButton" />
				</div>
			</form>
		</div>
	</body>
</html>
