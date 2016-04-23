<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath }/css/mana-main.css" />
		<script type="text/javascript">
   		function altRows(id){
		    if(document.getElementsByTagName){  
				var table = document.getElementById(id);  
				var rows = table.getElementsByTagName("tr"); 	 
				for(i = 0; i < rows.length; i++){          
					if(i % 2 == 0){
						rows[i].className = "evenrowcolor";
					}else{
						rows[i].className = "oddrowcolor";
					}      
				}
			}
		}

		window.onload=function(){
			altRows('alternatecolor');
		}
    	</script>
		<script type="text/javascript">
    	function del(course_id,name){
    		if(window.confirm("您确认删除"+name+"吗？")){
    			location.href='${pageContext.request.contextPath}/servlet/DelCourseServlet?course_id=' + course_id + '&name=' + name;
    		}
    	}
    	</script>
	</head>
	<body>
		<c:if test="${empty username }">
			<div id="container">
				<div id="table">
					<table class="altrowstable" id="alternatecolor">
						<tr>
							<th width="165px">
								课程号
							</th>
							<th width="165px">
								课程名称
							</th>
							<th width="165px">
								代课教师
							</th>
							<th width="164px">
								查看
							</th>
							<th width="164px">
								操作
							</th>
						</tr>
						<c:forEach var="c" items="${requestScope.queryresult.list }">
							<tr>
								<td>
									${c.course_id }
								</td>
								<td>
									${c.name }
								</td>
								<td>
									${c.teacher }
								</td>
								<td>
									<a
										href="${pageContext.request.contextPath }/servlet/SelectCourseServlet?name=${c.name }">查看课程安排</a>
								</td>
								<td>
									<a
										href="${pageContext.request.contextPath }/servlet/AddCourseUIServlet?course_id=${c.course_id }&name=${c.name }">更改课程信息</a>
									<a href="javascript:void(0)"
										onclick="del('${c.course_id }','${c.name }')">删除课程信息</a>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td id="add" colspan="5">
								<a
									href="${pageContext.request.contextPath }/servlet/AddCourseUIServlet">+添加课程信息</a>
							</td>
						</tr>
					</table>
					<div id="alert">
						<span>${alert }</span>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${!empty username }">
			<div id="container">
				<div id="table">
					<table class="altrowstable" id="alternatecolor">
						<tr>
							<th width="210px">
								课程号
							</th>
							<th width="210px">
								课程名称
							</th>
							<th width="210px">
								代课教师
							</th>
							<th width="210px">
								查看
							</th>
						</tr>
						<c:forEach var="c" items="${requestScope.queryresult.list }">
							<tr>
								<td>
									${c.course_id }
								</td>
								<td>
									${c.name }
								</td>
								<td>
									${c.teacher }
								</td>
								<td>
									<a
										href="${pageContext.request.contextPath }/servlet/SelectCourseServlet?name=${c.name }&username=${username }">查看课程安排</a>
								</td>
							</tr>
						</c:forEach>
					</table>
					<div id="alert">
						<span>${alert }</span>
					</div>
				</div>
			</div>
		</c:if>
	</body>
</html>
