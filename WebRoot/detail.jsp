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
    
    <title>My JSP 'detail.jsp' starting page</title>
    
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
	商品名:${param.gname }<br>
	商品价格${param.gprice }<br>
	所属类别:${param.ctype}<br>
	<img src="/shopping/image/${param.gpic }"><br>
	<c:url value="/ForderSer" var="buy">
		<c:param name="status" value="buy" />
		<c:param name="gid" value="${param.gid }"/>
		<c:param name="gname" value="${param.gname }"/>
        <c:param name="gprice" value="${param.gprice }"/>
        <c:param name="gpic" value="${param.gpic }"/>
        <c:param name="ctype" value="${param.ctype }"/>
	</c:url>
	<a href="${buy }"> 购买</a>
  </body>
</html>
