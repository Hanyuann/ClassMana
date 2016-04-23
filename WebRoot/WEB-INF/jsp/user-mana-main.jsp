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
    	function del(username,id){
    		if(window.confirm("您确认删除"+username+"吗？")){
    			location.href='${pageContext.request.contextPath}/servlet/DelUserServlet?id=' + id;
    		}
    	}
    	</script>
	</head>
	<body>
		<div id="container">
			<div id="table">
				<table class="altrowstable" id="alternatecolor">
					<tr >
						<th width="210px">
							用户ID
						</th>
						<th width="210px">
							用户名
						</th>
						<th width="210px">
							用户组
						</th>
						<th width="210px">
							操作
						</th>
					</tr>
					<c:forEach var="u" items="${requestScope.queryresult.list }">
						<tr>
							<td>
								${u.id }
							</td>
							<td>
								${u.username }
							</td>
							<td>
								${u.type }
							</td>
							<td>
								<c:if test="${u.type!='admin' }">
									<a href="javascript:void(0)"
										onclick="del('${u.username }','${u.id }')">删除用户</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td id="add" colspan="4">
							<a
								href="${pageContext.request.contextPath }/servlet/AddUserUIServlet"
								target="main">+添加用户</a>
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
