<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
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
	* {
		font-size: 11pt;
	}
	div {
		border: solid 2px gray;
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	
	#buy {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -902px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#buy:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -938px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
</style>
  </head>
  
  <body>
<h1>我的订单</h1>
<%--${orders}--%>
<%--${orderitem}--%>
<table id="table1" border="1" width="100%" cellspacing="0" background="black">

	

	<tr bgcolor="gray" bordercolor="gray">
		<c:forEach items="${orderitem}" var="orderitems">
			<script type="text/javascript">
                $('#table1').append($('<tr>')
                    .attr({"bgcolor":"gray","bordercolor":"gray"})
                    .append($('<td>').attr("colspan","6")
                        .html("订单编号: ${orderitems.key.oid}　成交时间: "+
                            "${orderitems.key.orderTime} 金额: <font color=\"red\"><b>"+
                            "${orderitems.key.total}</b></font>  <a href=\"<c:url value='/order?method=load&oid=${orderitems.key.oid}'/>\">付款</a>  等待发货  <a href=\"<c:url value='/order?method=confirm&oid=${orderitems.key.oid}'/>\"  确认收货</a>订单结束")))
			</script>
			<c:forEach items="${orderitems.value}" var="order">
				<c:forEach items="${books}" var="book">
					<c:if test="${order.bid==book.bid}">

			<script type="text/javascript">
                $('#table1').append($('<tr>').attr({"bordercolor":"gray","align":"center"})
                    .append($('<td>').css("width","15%").html("<div><img src=\"/bookstore/${book.image}\" height=\"75\"/></div>"))
                    .append($('<td>').text("书名: ${book.bname}"))
                    .append($('<td>').text("单价: ${book.price}"))
                    .append($('<td>').text("作者: ${book.author}"))
                    .append($('<td>').text("数量: ${order.count}"))
                    .append($('<td>').text("小计: ${order.count*book.price}"))
                )
			</script>




					</c:if>
				</c:forEach>
			</c:forEach>
		</c:forEach>


	<%--<c:forEach items="${orders}" var="order">--%>
		<%--<c:forEach items="${orderitem}" var="orderitems">--%>
			<%--<c:forEach items="${orderitems}" var="item">--%>
				<%--<c:if test="${item.oid==order.oid}">--%>
					<%--<script type="text/javascript">--%>
                        <%--$('#table1').append($('<tr>')--%>
                            <%--.attr({"bgcolor":"gray","bordercolor":"gray"})--%>
                            <%--.append($('<td>').attr("colspan","6")--%>
                                <%--.html("订单编号: ${order.oid}　成交时间: "+--%>
                                    <%--"${order.orderTime} 金额: <font color=\"red\"><b>"+--%>
                                    <%--"${order.total}</b></font>  <a href=\"<c:url value='/order?method=load&oid=${order.oid}'/>\">付款</a>  等待发货  <a href=\"<c:url value='/order?method=confirm&oid=${order.oid}'/>\"  确认收货</a>订单结束")))--%>
					<%--</script>--%>
				<%--<c:forEach items="${books}" var="book">--%>
					<%--<c:if test="${item.bid==book.bid}">--%>
						<%--<script type="text/javascript">--%>
                            <%--$('#table1').append($('<tr>').attr({"bordercolor":"gray","align":"center"})--%>
									<%--.append($('<td>').css("width","15%").html("<div><img src=\"/bookstore/${book.image}\" height=\"75\"/></div>"))--%>
									<%--.append($('<td>').text("书名: ${book.bname}"))--%>
									<%--.append($('<td>').text("单价: ${book.price}"))--%>
									<%--.append($('<td>').text("作者: ${book.author}"))--%>
									<%--.append($('<td>').text("数量: ${item.count}"))--%>
									<%--.append($('<td>').text("小计: ${item.count*book.price}"))--%>
								<%--)--%>
						<%--</script>--%>

						<%--</c:if>--%>
					<%--</c:forEach>--%>
				<%--</c:if>--%>
			<%--</c:forEach>--%>
		<%--</c:forEach>--%>
	<%--</c:forEach>--%>

</table>
<c:if test="${requestScope.msg!=null}">
  <script type="text/javascript">
	 window.alert("${requestScope.msg}")
  </script>
</c:if>
  </body>
</html>
