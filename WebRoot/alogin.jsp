<%@ page language="java" import="java.util.*" import="com.xy9860.shopping.pojo.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'alogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><%-- <%
  List<List<Goods>> bigList=(List<List<Goods>>)application.getAttribute("bigList");
 for(List<Goods> goods: bigList){
 	for(Goods g: goods){
 		out.println(g);
 	}
 
 }
  
  
   %> --%>
    <form action="/shopping/AccountSer" method="post" >
    	登录名:<input type="text" name= "alogin" /><br>
    	登陆密码:<input type="password" name="apass" /><br>
    	<input type="submit" value="提交" />
    	<input type="hidden" name="status" value="login" /><br>
    	${error}<br><!-- 显示刚才设置的错误消息 -->
    </form>
  </body>
</html>
