<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分类列表</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {background: rgb(254,238,189);}
	table {font-family: 宋体; font-size: 11pt; border-color: rgb(78,78,78);  width: 60%;}
	#th {background: rgb(78,78,78);}
</style>
  </head>
  
  <body>
    <h2 style="text-align: center;">分类列表</h2>
    <table align="center" border="1" cellpadding="0" cellspacing="0">
    	<tr id="th" bordercolor="rgb(78,78,78)">
    		<th>分类名称</th>
    		<th>操作</th>
    	</tr>

		<c:forEach var="category" items="${categorys}">
			<script type="text/javascript">
				$('#th').after($('<tr>').css("bordercolor","rgb(78,78,78)")
					.append($('<td>').text("${category.cname}"))
					.append($('<td>')
						.append($('<a>')
							.attr("href","<c:url value='/adminjsps/admin/category/mod.jsp?cname=${category.cname}&cid=${category.cid}'/>").text("修改"))
						.append(" | ")
						.append($('<a>')
							.attr("href","<c:url value='/adminjsps/admin/category/del.jsp?cname=${category.cname}'/>").text("删除"))))


			</script>
		</c:forEach>
<c:if test="${delete!=null}">
	<script type="text/javascript">
		window.alert("${delete}")
	</script>
	${sessionScope.delete=null}
</c:if>
    </table>
  </body>
</html>
