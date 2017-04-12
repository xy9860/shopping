<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chooseBank.jsp' starting page</title>
    
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
   	 您的订单编号为${sessionScope.forder.fid }要支付的价格是${sessionScope.forder.ftotal }<br>
              请选择要支付的银行<br>
    <table border="1">
    	<tr>
    	<c:forEach items="${applicationScope.fileNames }" var="fileName" varStatus="num">
 			   <td><input type="radio" value="" name="bank"><img alt="" src="/shopping/image/bank/${fileName }"></td>
 			 <c:if test="${ num.count%5==0}">	
 			 	</tr>
 			 	<tr>
 			 </c:if>
    	</c:forEach>
    	</tr>
    </table>
  </body>
</html>
