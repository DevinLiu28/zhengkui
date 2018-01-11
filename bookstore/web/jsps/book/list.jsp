<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		font-size: 10pt;
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
</style>
  </head>
  
  <body>
  <div id="icon"></div>
  <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/8758723-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
  <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/8991366-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/9265169-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/9317290-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/20029394-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/20285763-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/20385925-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/22722790-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/22788412-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>

<%--<c:forEach items="${requestScope.books}" var="book">--%>
    <%--&lt;%&ndash;<div class="icon">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<a href="../../book?method=load&bid=${book.bid}"><img src="/bookstore/${book.image}" alt=""></a>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<br>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<a href="../../book?method=load&bid=${book.bid}">${book.bname}</a>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--<script type="text/javascript">--%>
        <%--console.log("123");--%>

    <%--</script>--%>


<%--</c:forEach>--%>


  </body>




  <script src="../../js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript">
      var url = "http://localhost:8080/bookstore/book?method=";
      var search = location.search;
      var number = search.indexOf("=");
      var cid = search.substring(number+1);
      switch (cid){
//          case "1":url = url+"category&category="+cid; break;
//          case "2":url = url+"category&category="+cid;break;
//          case "3":url = url+"category&category="+cid;break;
//          default:url = url+"findAll";
          case "0":url = url+"findAll";break;
          default:url=url+"category&category="+cid;break;
      }
      $.getJSON(url,
          function (data,status) {
            if(status=="success"){
                if (data!=null){
                    $.each(data,function (index,objcet) {
                        var image = objcet['image'];
                        $('#icon')
                            .append($('<div>').attr("class","icon")
                                .append($('<a>').attr("href","../../book?method=load&bid="+objcet['bid']).html($('<img>').attr("src","/bookstore/"+image)))
                                .append($('<br>'))
                                .append($('<a>')
                                    .attr("href","../../user/book?method=load&bid="+objcet['bid'])
                                    .text(objcet['bname']))
                            )
                    })
                }
            }

        })






  </script>
</html>

