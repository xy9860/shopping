<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <c:choose>
    	<c:when test="${sessionScope.users==null }">你好游客请<a href="/shopping/ulogin.jsp">登录</a></c:when>
    	<c:otherwise>${sessionScope.users.uname}欢迎你,如果账号错误,请<a href="/UsersSer?status=signout">退出</a></c:otherwise>
    </c:choose><br>
<c:forEach items="${applicationScope.bigList }" var="list">
<table width="100%" border="1">
  <tr>
    <td colspan="4">
    ${list[0].category.ctype }
    </td>
  </tr>
  <tr>
    <c:forEach items="${list }" var="goods">
    <td height="184">
 
    <table width="100%" height="100%" border="0" cellpadding="1" cellspacing="1">
      <tr>
        <td height="162">
        <c:url value="/detail.jsp" var="detail">
        	<c:param name="gid" value="${goods.gid }"/>
        	<c:param name="gname" value="${goods.gname }"/>
        	<c:param name="gprice" value="${goods.gprice }"/>
        	<c:param name="gpic" value="${goods.gpic }"/>
        	<c:param name="ctype" value="${list[0].category.ctype }"/>
        </c:url>
        <a href="${detail }"><img src="/shopping/image/${goods.gpic }"></a>
        </td>
      </tr>
      <tr>
        <td height="25">价格:¥${goods.gprice }</td>
      </tr>
      <tr>
        <td>${goods.gname }&nbsp;&nbsp;&nbsp;&nbsp; ${goods.gxremark }</td>
      </tr>
    </table>

     <!-- 循环4次-->
    </td>
        </c:forEach>
  </tr>
</table>
</c:forEach>
  </body>
</html>
