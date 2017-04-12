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
    
    <title>My JSP 'showCar.jsp' starting page</title>
    
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
    这里显示购物车也就是购买的商品列表<br>
    <table>
    	<tr>
    		<td>商品编号</td>
    		<td>商品名称</td>
    		<td>商品数量</td>
    		<td>商品价格</td>
    		<td>删除商品</td>
    	</tr>
    	<c:forEach items="${sessionScope.forder.sorders }" var="sorder">
    		<tr>
    			<td>${sorder.goods.gid }</td>
    			<td>${sorder.sname }</td>
    			<td><input value="${sorder.snumber }" size="2"></td>
    			<td>${sorder.sprice }</td>
    			<td><a href="/shopping/ForderSer?status=delSorder&gid=${sorder.goods.gid }">删除</a></td>
    		</tr>
    	</c:forEach>
    </table>
    <div>总价:${sessionScope.forder.ftotal }</div><br>
    <a href="/shopping">继续购物</a><br><a href="/shopping/ForderSer?status=delForder">清空购物车</a><br><a href="/shopping/users/forderInfo.jsp">结算</a>
  </body>
</html>
