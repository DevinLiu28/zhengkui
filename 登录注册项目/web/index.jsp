<%@ page import="com.lanou3g.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/2
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.2.1.min.js"></script>
  </head>
  <body>
  <%
    if(session.getAttribute("user")!=null){
      User user = (User)session.getAttribute("user");
      session.setAttribute("username",user.getUsername());
      out.write("登录成功");
      %>
  <table border="1" style="border: 1px solid black;text-align: center"></table>
      <%
    }else {
        out.write("请先登录");
        %>
  <br>
  <a href="http://localhost:8080/login1.html">点击去登录</a>
  <%
    }
  %>

  <input type = "button" name="exit" value="退出" onclick="location.href='/login'">

  </body>
<script type="text/javascript">
    $.getJSON("http://localhost:8080/show",
        function (data, status) {
            if(status=="success"){
                if(data!=null){
                    $('table')
                        .append($('<tr>')
                            .append($('<th>').text("书名"))
                            .append($('<th>').text("作者"))
                            .append($('<th>').text("价格")));
                    $.each(data,function (index,obj){
                        $('table')
                            .append($('<tr>')
                                .append($('<td>').append($('<a id="book" href="showBook.jsp">'+obj['bookName']+'</a>')))
                                .append($('<td>').text(obj['writer']))
                                .append($('<td>').text(obj['money'])));
                    })
                }
            }
        });


  </script>
</html>
