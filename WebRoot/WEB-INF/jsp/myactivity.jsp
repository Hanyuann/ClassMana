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
   	    function del(aid,name,username){
    		if(window.confirm("您确认删除"+name+"吗？")){
    			location.href='${pageContext.request.contextPath}/servlet/DelActivityServlet?aid=' + aid + '&username=' + username;
    		}
    	}
    	</script>
	</head>
	<body>
		<div id="container">
			<div id="table">
				<table class="altrowstable" id="alternatecolor">
					<tr>
						<th width="113px">
							活动ID
						</th>
						<th width="112px">
							申请者
						</th>
						<th width="113px">
							活动名称
						</th>
						<th width="113px">
							申请教室号
						</th>
						<th width="113px">
							申请时间
						</th>
						<th width="112px">
							申请状态
						</th>
						<th width="113px">
							操作
						</th>
					</tr>
					<c:forEach var="a" items="${requestScope.a_list }">
						<tr>
							<td>
								${a.aid }
							</td>
							<td>
								${a.username }
							</td>
							<td>
								${a.name }
							</td>
							<td>
								${a.room_no }
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
							<c:if test="${a.start_section==a.end_section }">
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
								<c:if test="${a.status=='0' }">
									管理员未批准
								</c:if>
								<c:if test="${a.status=='1' }">
									管理员已批准
								</c:if>
							</td>
							<td>
								<a href="javascript:void(0)"
									onclick="del('${a.aid }','${a.name }','${a.username }')">删除</a>
							</td>
							<c:set var="username" value="${a.username }"></c:set>
						</tr>
					</c:forEach>
					<tr>
						<td id="add" colspan="7">
							<a
								href="${pageContext.request.contextPath }/servlet/AddActivityUIServlet?username=${username }">+预约申请教室</a>
						</td>
					</tr>
				</table>
				<div id="alert">
					<span>${alert }</span>
				</div>
			</div>
		</div>
	</body>
</html>
