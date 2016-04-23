<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    	function del(room_no){
    		if(window.confirm("您确认删除"+room_no+"吗？")){
    			location.href='${pageContext.request.contextPath}/servlet/DelClassroomServlet?room_no=' + room_no;
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
							<th width="210px">
								教室号
							</th>
							<th width="210px">
								教室位置
							</th>
							<th width="210px">
								查看
							</th>
							<th width="210px">
								操作
							</th>
						</tr>
						<c:forEach var="c" items="${requestScope.queryresult.list }">
							<tr>
								<td>
									${c.room_no }
								</td>
								<td>
									${c.location }
								</td>
								<td>
									<a
										href="${pageContext.request.contextPath }/servlet/SelectClassroomServlet?room_no=${c.room_no }">查看教室安排</a>
								</td>
								<td>
									<a
										href="${pageContext.request.contextPath }/servlet/AddClassroomUIServlet?room_no=${c.room_no }">更改教室信息</a>
									<a href="javascript:void(0)" onclick="del('${c.room_no }')">删除教室信息</a>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td id="add" colspan="4">
								<a
									href="${pageContext.request.contextPath }/servlet/AddClassroomUIServlet">+添加教室信息</a>
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
							<th width="280px">
								教室号
							</th>
							<th width="280px">
								教室位置
							</th>
							<th width="280px">
								查看
							</th>
						</tr>
						<c:forEach var="c" items="${requestScope.queryresult.list }">
							<tr>
								<td>
									${c.room_no }
								</td>
								<td>
									${c.location }
								</td>
								<td>
									<a
										href="${pageContext.request.contextPath }/servlet/SelectClassroomServlet?room_no=${c.room_no }&username=${username }">查看教室安排</a>
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
