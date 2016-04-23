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
			<c:if test="${empty room_no }">
				<form
					action="${pageContext.request.contextPath }/servlet/AddClassroomServlet"
					method="post">
					<span class="info">教室号：</span>
					<input type="text" name="room_no" class="txt"
						value="${form.room_no }" />
					<span class="info">请输入不超过4位的教室号</span>
					<span class="message">${form.errors.room_no }</span>
					<br />
					<span class="info">教室位置：</span>
					<input type="text" name="location" class="txt"
						value="${form.location }" />
					<span class="info">请输入教室位置</span>
					<span class="message">${form.errors.location }</span>
					<div id="button">
						<input type="reset" value="重  置" class="myButton" />
						<input type="submit" value="添加教室" class="myButton" />
					</div>
				</form>
			</c:if>
			<c:if test="${!empty room_no }">
			<form
					action="${pageContext.request.contextPath }/servlet/UpdateClassroomServlet"
					method="post">
					<span class="info">教室号：</span>
					<input type="text" name="room_no" class="txt" value="${room_no }" />
					<span class="message">${form.errors.room_no }</span>
					<br />
					<span class="info">教室位置：</span>
					<input type="text" name="location" class="txt"
						value="${form.location }" />
					<span class="info">请输入教室位置</span>
					<span class="message">${form.errors.location }</span>
					<div id="button">
						<input type="reset" value="重  置" class="myButton" />
						<input type="submit" value="确认更改" class="myButton" />
					</div>
				</form>			
			</c:if>
		</div>
	</body>
</html>
