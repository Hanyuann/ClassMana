<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>教室管理系统——教师界面</title>
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath }/css/user.css">
	</head>
	<frameset rows="95,*" frameborder="no" border="0" framespacing="0">
		<frame src="${pageContext.request.contextPath }/head.jsp" name="head" scrolling="No" noresize="noresize" />
		<frameset cols="242px,*" frameborder="no" border="0" framespacing="0">
			<frame src="${pageContext.request.contextPath }/servlet/TeacherLeftUIServlet?id=${id }&username=${username }" scrolling="No" noresize="noresize" name="left" />
			<frame src="${pageContext.request.contextPath }/servlet/MainUIServlet" scrolling="No" noresize="noresize" name="main" />
		</frameset>
	</frameset>
	<body>
	</body>
</html>
