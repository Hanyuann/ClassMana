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
    	function delc(name,id,room_no,select){
    		if(window.confirm("您确认删除"+name+"吗？")){
    			location.href='${pageContext.request.contextPath}/servlet/DelArrangeServlet?id=' + id + '&name=' + name + '&room_no=' + room_no + '&select=' + select;
    		}
    	}
    	function dela(name,aid,room_no){
    		if(window.confirm("您确认删除"+name+"吗？")){
    			location.href='${pageContext.request.contextPath}/servlet/DelActivityServlet?aid=' + aid + '&room_no=' + room_no;
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
								ID
							</th>
							<th width="164px">
								教室号
							</th>
							<th width="165px">
								课程名
							</th>
							<th width="165px">
								上课时间
							</th>
							<th width="164px">
								操作
							</th>
						</tr>
						<c:forEach var="c" items="${requestScope.c_list }">
							<tr>
								<td>
									${c.id }
								</td>
								<td>
									${c.room_no }
								</td>
								<td>
									${c.name }
								</td>
								<c:if test="${c.start_section!=c.end_section }">
									<td>
										<c:if test="${c.day=='1' }">
									星期一  第${c.start_section }节-第${c.end_section }节
								</c:if>
										<c:if test="${c.day=='2' }">
									星期二  第${c.start_section }节-第${c.end_section }节
								</c:if>
										<c:if test="${c.day=='3' }">
									星期三  第${c.start_section }节-第${c.end_section }节
								</c:if>
										<c:if test="${c.day=='4' }">
									星期四  第${c.start_section }节-第${c.end_section }节
								</c:if>
										<c:if test="${c.day=='5' }">
									星期五  第${c.start_section }节-第${c.end_section }节
								</c:if>
										<c:if test="${c.day=='6' }">
									星期六  第${c.start_section }节-第${c.end_section }节
								</c:if>
										<c:if test="${c.day=='7' }">
									星期日  第${c.start_section }节-第${c.end_section }节
								</c:if>
									</td>
								</c:if>
								<c:if test="${c.start_section==c.end_section }">
									<td>
										<c:if test="${c.day=='1' }">
									星期一  第${c.start_section }节
								</c:if>
										<c:if test="${c.day=='2' }">
									星期二  第${c.start_section }节
								</c:if>
										<c:if test="${c.day=='3' }">
									星期三  第${c.start_section }节
								</c:if>
										<c:if test="${c.day=='4' }">
									星期四  第${c.start_section }节
								</c:if>
										<c:if test="${c.day=='5' }">
									星期五  第${c.start_section }节
								</c:if>
										<c:if test="${c.day=='6' }">
									星期六  第${c.start_section }节
								</c:if>
										<c:if test="${c.day=='7' }">
									星期日  第${c.start_section }节
								</c:if>
									</td>
								</c:if>
								<td>
									<a href="javascript:void(0)"
										onclick="delc('${c.name }','${c.id }','${c.room_no }',${empty room_no }?'name':'room_no')">删除</a>
								</td>
							</tr>
						</c:forEach>
						<c:if test="${!empty requestScope.a_list[0].aid}">
							<tr>
								<th width="165px">
									ID
								</th>
								<th width="164px">
									教室号
								</th>
								<th width="165px">
									活动名
								</th>
								<th width="165px">
									活动时间
								</th>
								<th width="164px">
									操作
								</th>
							</tr>
							<c:forEach var="a" items="${requestScope.a_list }">
								<tr>
									<td>
										${a.aid }
									</td>
									<td>
										${a.room_no }
									</td>
									<td>
										${a.name }
									</td>
									<c:if test="${a.start_section!=a.end_section }">
										<td>
											<c:if test="${a.day=='1' }">
									星期一  第${a.start_section }节-第${a.end_section }节
								</c:if>
											<c:if test="${a.day=='2' }">
									星期二  第${a.start_section }节-第${a.end_section }节
								</c:if>
											<c:if test="${a.day=='3' }">
									星期三  第${a.start_section }节-第${a.end_section }节
								</c:if>
											<c:if test="${a.day=='4' }">
									星期四  第${a.start_section }节-第${a.end_section }节
								</c:if>
											<c:if test="${a.day=='5' }">
									星期五  第${a.start_section }节-第${a.end_section }节
								</c:if>
											<c:if test="${a.day=='6' }">
									星期六  第${a.start_section }节-第${a.end_section }节
								</c:if>
											<c:if test="${a.day=='7' }">
									星期日  第${a.start_section }节-第${a.end_section }节
								</c:if>
										</td>
									</c:if>
									<c:if test="${a.start_section ==a.end_section }">
										<td>
											<c:if test="${a.day=='1' }">
									星期一  第${a.start_section }节
								</c:if>
											<c:if test="${a.day=='2' }">
									星期二  第${a.start_section }节
								</c:if>
											<c:if test="${a.day=='3' }">
									星期三  第${a.start_section }节
								</c:if>
											<c:if test="${a.day=='4' }">
									星期四  第${a.start_section }节
								</c:if>
											<c:if test="${a.day=='5' }">
									星期五  第${a.start_section }节
								</c:if>
											<c:if test="${a.day=='6' }">
									星期六  第${a.start_section }节
								</c:if>
											<c:if test="${a.day=='7' }">
									星期日  第${a.start_section }节
								</c:if>
										</td>
									</c:if>
									<td>
										<a href="javascript:void(0)"
											onclick="dela('${a.name }','${a.aid }','${room_no }')">删除</a>
									</td>
								</tr>
							</c:forEach>
						</c:if>
						<tr>
							<c:if test="${!empty requestScope.room_no}">
								<td id="add" colspan="5">
									<a
										href="${pageContext.request.contextPath }/servlet/AddArrangeUIServlet?room_no=${requestScope.room_no }">+添加课程安排</a>
								</td>
							</c:if>
							<c:if test="${!empty requestScope.name}">
								<td id="add" colspan="5">
									<a
										href="${pageContext.request.contextPath }/servlet/AddArrangeUIServlet?name=${requestScope.name }">+添加课程安排</a>
								</td>
							</c:if>
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
								ID
							</th>
							<th width="210px">
								教室号
							</th>
							<th width="210px">
								课程名
							</th>
							<th width="210px">
								上课时间
							</th>
						</tr>
						<c:forEach var="c" items="${requestScope.c_list }">
							<tr>
								<td>
									${c.id }
								</td>
								<td>
									${c.room_no }
								</td>
								<td>
									${c.name }
								</td>
								<c:if test="${c.start_section!=c.end_section }">
									<td>
										<c:if test="${c.day=='1' }">
									星期一  第${c.start_section }节-第${c.end_section }节
								</c:if>
										<c:if test="${c.day=='2' }">
									星期二  第${c.start_section }节-第${c.end_section }节
								</c:if>
										<c:if test="${c.day=='3' }">
									星期三  第${c.start_section }节-第${c.end_section }节
								</c:if>
										<c:if test="${c.day=='4' }">
									星期四  第${c.start_section }节-第${c.end_section }节
								</c:if>
										<c:if test="${c.day=='5' }">
									星期五  第${c.start_section }节-第${c.end_section }节
								</c:if>
										<c:if test="${c.day=='6' }">
									星期六  第${c.start_section }节-第${c.end_section }节
								</c:if>
										<c:if test="${c.day=='7' }">
									星期日  第${c.start_section }节-第${c.end_section }节
								</c:if>
									</td>
								</c:if>
								<c:if test="${c.start_section==c.end_section }">
									<td>
										<c:if test="${c.day=='1' }">
									星期一  第${c.start_section }节
								</c:if>
										<c:if test="${c.day=='2' }">
									星期二  第${c.start_section }节
								</c:if>
										<c:if test="${c.day=='3' }">
									星期三  第${c.start_section }节
								</c:if>
										<c:if test="${c.day=='4' }">
									星期四  第${c.start_section }节
								</c:if>
										<c:if test="${c.day=='5' }">
									星期五  第${c.start_section }节
								</c:if>
										<c:if test="${c.day=='6' }">
									星期六  第${c.start_section }节
								</c:if>
										<c:if test="${c.day=='7' }">
									星期日  第${c.start_section }节
								</c:if>
									</td>
								</c:if>
							</tr>
						</c:forEach>
						<c:if test="${!empty requestScope.a_list[0].aid}">
							<tr>
								<th width="210px">
									ID
								</th>
								<th width="210px">
									教室号
								</th>
								<th width="210px">
									活动名
								</th>
								<th width="210px">
									活动时间
								</th>
							</tr>
							<c:forEach var="a" items="${requestScope.a_list }">
								<tr>
									<td>
										${a.aid }
									</td>
									<td>
										${a.room_no }
									</td>
									<td>
										${a.name }
									</td>
									<c:if test="${a.start_section!=a.end_section }">
										<td>
											<c:if test="${a.day=='1' }">
									星期一  第${a.start_section }节-第${a.end_section }节
								</c:if>
											<c:if test="${a.day=='2' }">
									星期二  第${a.start_section }节-第${a.end_section }节
								</c:if>
											<c:if test="${a.day=='3' }">
									星期三  第${a.start_section }节-第${a.end_section }节
								</c:if>
											<c:if test="${a.day=='4' }">
									星期四  第${a.start_section }节-第${a.end_section }节
								</c:if>
											<c:if test="${a.day=='5' }">
									星期五  第${a.start_section }节-第${a.end_section }节
								</c:if>
											<c:if test="${a.day=='6' }">
									星期六  第${a.start_section }节-第${a.end_section }节
								</c:if>
											<c:if test="${a.day=='7' }">
									星期日  第${a.start_section }节-第${a.end_section }节
								</c:if>
										</td>
									</c:if>
									<c:if test="${a.start_section ==a.end_section }">
										<td>
											<c:if test="${a.day=='1' }">
									星期一  第${a.start_section }节
								</c:if>
											<c:if test="${a.day=='2' }">
									星期二  第${a.start_section }节
								</c:if>
											<c:if test="${a.day=='3' }">
									星期三  第${a.start_section }节
								</c:if>
											<c:if test="${a.day=='4' }">
									星期四  第${a.start_section }节
								</c:if>
											<c:if test="${a.day=='5' }">
									星期五  第${a.start_section }节
								</c:if>
											<c:if test="${a.day=='6' }">
									星期六  第${a.start_section }节
								</c:if>
											<c:if test="${a.day=='7' }">
									星期日  第${a.start_section }节
								</c:if>
										</td>
									</c:if>
								</tr>
							</c:forEach>
						</c:if>
					</table>
					<div id="alert">
						<span>${alert }</span>
					</div>
				</div>
			</div>
		</c:if>
	</body>
</html>
