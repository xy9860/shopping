<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'forderInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   	 此次订单信息如下: <br>
    <table border=1>
    	<tr>
    		<td>商品编号</td>
    		<td>商品名称</td>
    		<td>商品数量</td>
    		<td>商品价格</td>
    	</tr>
    	<c:forEach items="${sessionScope.forder.sorders }" var="sorder">
    		<tr>
    			<td>${sorder.goods.gid }</td>
    			<td>${sorder.sname }</td>
    			<td>${sorder.snumber }</td>
    			<td>${sorder.sprice }</td>
    		</tr>
    	</c:forEach>
    </table>
    <div>总价:${sessionScope.forder.ftotal }</div><br>
    <form action="/shopping/ForderSer" method="post">
    	收货人姓名:<input type="text" name="fname" value="${sessionScope.users.uname }"><br>
    	收货人电话:<input type="text" name="fphone" value="${sessionScope.users.uphone }"><br>
    	收货人地址:<input type="text" name="faddress" value="${sessionScope.users.uaddress }"><br>
    	收货人邮编:<input type="text" name="fpost" value="${sessionScope.users.upost }"><br>
    	收货人邮件:<input type="text" name="femail" value="${sessionScope.users.uemail }"><br>
    	收货人留言:<input type="text" name="fremark"><br>
    	<input type="submit" value="确认"><input type="hidden" name="status" value="saveForder">
    </form>
  </body>
</html>
