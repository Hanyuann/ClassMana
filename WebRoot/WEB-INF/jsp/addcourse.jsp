<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath }/css/form.css">
	</head>

	<body>
		<div id="container">
		<c:if test="${empty course_id }">
			<form
				action="${pageContext.request.contextPath }/servlet/AddCourseServlet"
				method="post">
				<span class="info">课程号：</span>
				<input type="text" name="course_id" class="txt"
					value="${form.course_id }" />
				<span class="info">请输入4位课程号</span>
				<span class="message">${form.errors.course_id }</span>
				<br />
				<span class="info">课程名：</span>
				<input type="text" name="name" class="txt"
					value="${form.name }" />
				<span class="info">请输入课程名</span>
				<span class="message">${form.errors.name }</span>
				<br />
				<span class="info">代课教师：</span>
				<input type="text" name="teacher" class="txt"
					value="${form.teacher }" />
				<span class="info">请输入教师名</span>
				<span class="message">${form.errors.teacher }</span>
				<div id="button">
					<input type="reset" value="重  置" class="myButton" />
					<input type="submit" value="添加课程" class="myButton" />
				</div>
			</form>
			</c:if>
			<c:if test="${!empty course_id }">
			<form
				action="${pageContext.request.contextPath }/servlet/UpdateCourseServlet"
				method="post">
				<span class="info">课程号：</span>
				<input type="text" name="course_id" class="txt"
					value="${course_id }" />
				<span class="message">${form.errors.course_id }</span>
				<br />
				<span class="info">课程名：</span>
				<input type="text" name="name" class="txt"
					value="${name }" />
				<span class="message">${form.errors.name }</span>
				<br />
				<span class="info">代课教师：</span>
				<input type="text" name="teacher" class="txt"
					value="${form.teacher }" />
				<span class="info">请输入教师名</span>
				<span class="message">${form.errors.teacher }</span>
				<div id="button">
					<input type="reset" value="重  置" class="myButton" />
					<input type="submit" value="确认更改" class="myButton" />
				</div>
			</form>
			</c:if>
		</div>
	</body>
</html>