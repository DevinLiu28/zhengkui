<%@ page import="com.lanou3g.bean.User" %>
<%@ page import="com.lanou3g.bean.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/2
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.2.1.min.js"></script>
  </head>
  <body>
  <%

    User user = (User)session.getAttribute("user");
    if(user!=null){
      session.setAttribute("username",user.getUsername());
      out.write("登录成功");
      %>
  <table border="1" style="text-align: center"></table>
      <%
    }else {
      response.sendRedirect("http://localhost:8080/login1.jsp");
//        out.write("请先登录");
        %>
  <br>
  <a href="http://localhost:8080/login1.jsp">点击去登录</a>
  <%
    }
  %>

  <input type = "button" name="exit" value="退出" onclick="location.href='/login'">
  <input type = "button" name="exit" value="查看图书" onclick="location.href='/show'">

  </body>
<script type="text/javascript">

    <%

          List<Book> books = (List<Book>) request.getAttribute("books");
          if(books!=null){
              %>
    $('table')
        .append($('<tr>')
            .append($('<th>').text("书名"))
            .append($('<th>').text("作者"))
            .append($('<th>').text("价格")));
    <%
    for (int i = 0;i < books.size();i++) {

    %>
    $('table')
        .append($('<tr>')
            .append($('<td>').append($('<a id="book" ></a>')
                .text("<%=books.get(i).getBookName()%>")
                .attr("href","/showbook?name="+"<%=books.get(i).getBookName()%>")))
            .append($('<td>').text("<%=books.get(i).getMoney()%>"))
            .append($('<td>').text("<%=books.get(i).getWriter()%>")));
    <%
    }
}

%>

  </script>
</html>
