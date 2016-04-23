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
			<c:if test="${!empty name }">
				<form
					action="${pageContext.request.contextPath }/servlet/AddArrangeServlet?select=name"
					method="post">
					<span class="info">教室号：</span>
					<input type="text" name="room_no" class="txt" value="${form.room_no }" />
					<span class="message">${form.errors.room_no }</span>
					<br />
					<span class="info">课程名：</span>
					<input type="text" name="name" class="txt"
						value="${requestScope.name }" />
					<span class="message">${form.errors.name }</span>
					<br />
					<select name="day" class="txt">
						<option value="1" ${form.day=='1'?'selected':'' }>
							星期一
						</option>
						<option value="2" ${form.day=='2'?'selected':'' }>
							星期二
						</option>
						<option value="3" ${form.day=='3'?'selected':'' }>
							星期三
						</option>
						<option value="4" ${form.day=='4'?'selected':'' }>
							星期四
						</option>
						<option value="5" ${form.day=='5'?'selected':'' }>
							星期五
						</option>
						<option value="6" ${form.day=='6'?'selected':'' }>
							星期六
						</option>
						<option value="7" ${form.day=='7'?'selected':'' }>
							星期日
						</option>
					</select>
					<span class="info">&nbsp&nbsp第</span>
					<select name="start_section" class="txt">
						<option value="1" ${form.start_section=='1'?'selected':'' }>
							1
						</option>
						<option value="2" ${form.start_section=='2'?'selected':'' }>
							2
						</option>
						<option value="3" ${form.start_section=='3'?'selected':'' }>
							3
						</option>
						<option value="4" ${form.start_section=='4'?'selected':'' }>
							4
						</option>
						<option value="5" ${form.start_section=='5'?'selected':'' }>
							5
						</option>
						<option value="6" ${form.start_section=='6'?'selected':'' }>
							6
						</option>
						<option value="7" ${form.start_section=='7'?'selected':'' }>
							7
						</option>
						<option value="8" ${form.start_section=='8'?'selected':'' }>
							8
						</option>
						<option value="9" ${form.start_section=='9'?'selected':'' }>
							9
						</option>
						<option value="10" ${form.start_section=='10'?'selected':'' }>
							10
						</option>
					</select>
					<span class="info">节 到 第</span>
					<select name="end_section" class="txt">
						<option value="1" ${form.end_section=='1'?'selected':'' }>
							1
						</option>
						<option value="2" ${form.end_section=='2'?'selected':'' }>
							2
						</option>
						<option value="3" ${form.end_section=='3'?'selected':'' }>
							3
						</option>
						<option value="4" ${form.end_section=='4'?'selected':'' }>
							4
						</option>
						<option value="5" ${form.end_section=='5'?'selected':'' }>
							5
						</option>
						<option value="6" ${form.end_section=='6'?'selected':'' }>
							6
						</option>
						<option value="7" ${form.end_section=='7'?'selected':'' }>
							7
						</option>
						<option value="8" ${form.end_section=='8'?'selected':'' }>
							8
						</option>
						<option value="9" ${form.end_section=='9'?'selected':'' }>
							9
						</option>
						<option value="10" ${form.end_section=='10'?'selected':'' }>
							10
						</option>
					</select>
					<span class="info">节</span>
					<span class="message">${form.errors.day }</span>
					<div id="button">
						<input type="reset" value="重  置" class="myButton" />
						<input type="submit" value="添加课程安排" class="myButton" />
					</div>
				</form>
			</c:if>
			<c:if test="${!empty room_no }">
				<form
					action="${pageContext.request.contextPath }/servlet/AddArrangeServlet?select=room_no"
					method="post">
					<span class="info">教室号：</span>
					<input type="text" name="room_no" class="txt" value="${requestScope.room_no }" />
					<span class="message">${form.errors.room_no }</span>
					<br />
					<span class="info">课程名：</span>
					<input type="text" name="name" class="txt"
						value="${form.name }" />
					<span class="info">请输入课程名</span>
					<span class="message">${form.errors.name }</span>
					<br />
					<select name="day" class="txt">
						<option value="1" ${form.day=='1'?'selected':'' }>
							星期一
						</option>
						<option value="2" ${form.day=='2'?'selected':'' }>
							星期二
						</option>
						<option value="3" ${form.day=='3'?'selected':'' }>
							星期三
						</option>
						<option value="4" ${form.day=='4'?'selected':'' }>
							星期四
						</option>
						<option value="5" ${form.day=='5'?'selected':'' }>
							星期五
						</option>
						<option value="6" ${form.day=='6'?'selected':'' }>
							星期六
						</option>
						<option value="7" ${form.day=='7'?'selected':'' }>
							星期日
						</option>
					</select>
					<span class="info">&nbsp&nbsp第</span>
					<select name="start_section" class="txt">
						<option value="1" ${form.start_section=='1'?'selected':'' }>
							1
						</option>
						<option value="2" ${form.start_section=='2'?'selected':'' }>
							2
						</option>
						<option value="3" ${form.start_section=='3'?'selected':'' }>
							3
						</option>
						<option value="4" ${form.start_section=='4'?'selected':'' }>
							4
						</option>
						<option value="5" ${form.start_section=='5'?'selected':'' }>
							5
						</option>
						<option value="6" ${form.start_section=='6'?'selected':'' }>
							6
						</option>
						<option value="7" ${form.start_section=='7'?'selected':'' }>
							7
						</option>
						<option value="8" ${form.start_section=='8'?'selected':'' }>
							8
						</option>
						<option value="9" ${form.start_section=='9'?'selected':'' }>
							9
						</option>
						<option value="10" ${form.start_section=='10'?'selected':'' }>
							10
						</option>
					</select>
					<span class="info">节 到 第</span>
					<select name="end_section" class="txt">
						<option value="1" ${form.end_section=='1'?'selected':'' }>
							1
						</option>
						<option value="2" ${form.end_section=='2'?'selected':'' }>
							2
						</option>
						<option value="3" ${form.end_section=='3'?'selected':'' }>
							3
						</option>
						<option value="4" ${form.end_section=='4'?'selected':'' }>
							4
						</option>
						<option value="5" ${form.end_section=='5'?'selected':'' }>
							5
						</option>
						<option value="6" ${form.end_section=='6'?'selected':'' }>
							6
						</option>
						<option value="7" ${form.end_section=='7'?'selected':'' }>
							7
						</option>
						<option value="8" ${form.end_section=='8'?'selected':'' }>
							8
						</option>
						<option value="9" ${form.end_section=='9'?'selected':'' }>
							9
						</option>
						<option value="10" ${form.end_section=='10'?'selected':'' }>
							10
						</option>
					</select>
					<span class="info">节</span>
					<span class="message">${form.errors.day }</span>
					<div id="button">
						<input type="reset" value="重  置" class="myButton" />
						<input type="submit" value="添加课程安排" class="myButton" />
					</div>
				</form>
			</c:if>
		</div>
	</body>
</html>
