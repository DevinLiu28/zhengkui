<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>
	  <script src="../../js/jquery-3.2.1.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>注册</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="../../user" method="post">
	<input type="hidden" name="method" value="regist"/>
	用户名：<input id="username" type="text" name="username" value=""/><br/>
	密　码：<input id="password" type="password" name="password"/><br/>
	邮　箱：<input id="email" type="text" name="email" value=""/><br/>
	<input type="submit" value="注册"/>
	<a href="login.jsp"><input type="button" value="点击去登录"/></a>
</form>
  <c:if test="${sessionScope.exception!=null}">
	  <script type="text/javascript">
          $('#username').val();
          $('#password').val();
          $('#email').val();
          window.alert("${sessionScope.exception}");
	  </script>
  </c:if>
  </body>

  <c:remove var="exception" scope="session"/>
<c:if test="${sessionScope.user!=null}">
	<script type="text/javascript">
	$('#username').val(${sessionScope.user.username});
	$('#password').val(${sessionScope.user.password});
	$('#email').val(${sessionScope.user.email});
	</script>
</c:if>
</html>
