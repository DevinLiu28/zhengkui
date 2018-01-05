<%@ page import="com.lanou3g.domain.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/5
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>主页</title>
    <script src="js/jquery-3.2.1.min.js"></script>
  </head>
  <body>
  <c:set var="username" value="${cookie.username.value}" scope="session"/>
  <c:out value="${cookie.username.value}"/>
  ${sessionScope.username}
  <input type = "button" name="exit" value="退出" onclick="location.href='/login'">

<table border="1"></table>
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
