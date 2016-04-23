<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>全局消息显示页面</title>
		<style>
html {
	width: 100%;
	height: 100%;
	overflow: hidden;
}

body {
	margin: 0px auto;
	padding: 0px;
	width: 100%;
	height: 100%;
	background-image: url(../images/background.gif);
	overflow: hidden;
}

#container{
	padding-top: 20px;
	padding-left: 30px; 	
}

#message {
	font-size : 16px;
	color: #354967;
	font-weight: bold;
	font-size: 16px;
}
</style>
	</head>

	<body>
	<meta http-equiv="refresh" content="3; url=${pageContext.request.contextPath }/index.jsp">
	<div id="container">
		<span id="message">${message }<br>浏览器将会在3秒后跳转到首页。</span>
	</div>
	</body>
</html>
