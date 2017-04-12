<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'queryGoods.jsp' starting page</title>
    
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
  	<form action="/shopping/GoodsSer" method="post">
    商品名字:<input type="text" name="gname">商品品牌:<input type="text" name="gremark"><br>
    <input type="submit" value="提交">
    <input type="hidden" name="status" value="queryGoods">
    </form>
    <c:if test="${requestScope.gdList!=null}">
    	<table border=1>
    		<tr>
    			<td>商品编号</td>
    			<td>商品名称</td>
    			<td>商品价格</td>
    			<td>商品图片</td>
    			<td>商品品牌</td>
    			<td>商品描述</td>
    			<td>商品添加时间</td>
    			<td>商品是否推荐</td>
    			<td>商品是否启用</td>
    			<td>商品类别</td>
    		</tr>
    		<c:forEach items="${requestScope.gdList}" var="goods" varStatus="num">
    		<tr>
    			<td>${goods.gid}</td>
    			<td>${goods.gname}</td>
    			<td>${goods.gprice}</td>
    			<td>${goods.gpic}</td>
    			<td>${goods.gremark}</td>
    			<td>${goods.gxremark}</td>
    			<td>${goods.gdate}</td>
    			<td>
					<c:choose>
						<c:when test="${goods.giscommend=='true' }">
							<input type="checkbox" checked="checked" value="true" disabled="disabled" >
						</c:when>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${goods.gisopen=='true' }">
							<input type="checkbox" checked="checked" value="true" disabled="disabled" >
						</c:when>
					</c:choose>
				</td>
    			<td>${goods.category.ctype }</td>
    		</tr>
    		</c:forEach>
    	</table>
    </c:if>
  </body>
</html>
