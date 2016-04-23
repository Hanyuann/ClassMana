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
    	function del(aid,name){
    		if(window.confirm("您确认删除"+name+"吗？")){
    			location.href='${pageContext.request.contextPath}/servlet/DelActivityServlet?aid=' + aid;
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
					<c:forEach var="a" items="${requestScope.queryresult.list }">
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
									未批准
								</c:if>
								<c:if test="${a.status=='1' }">
									已批准
								</c:if>
							</td>
							<td>
								<c:if test="${a.status=='0' }">
									<a
										href="${pageContext.request.contextPath }/servlet/ChangeStatusServlet?aid=${a.aid }&status=0">批准</a>
								</c:if>
								<c:if test="${a.status=='1' }">
									<a
										href="${pageContext.request.contextPath }/servlet/ChangeStatusServlet?aid=${a.aid }&status=1">取消批准</a>
								</c:if>
								<a href="javascript:void(0)"
									onclick="del('${a.aid }','${a.name }')">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div id="alert">
					<span>${alert }</span>
				</div>
			</div>
		</div>
	</body>
</html>
