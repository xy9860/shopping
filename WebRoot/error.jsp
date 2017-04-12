<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="javascript">
   function delayURL(url) {
        var delay = document.getElementById("time").innerHTML;
        if(delay > 0) {
            delay--;
            document.getElementById("time").innerHTML = delay;
        } else {
            window.top.location.href = url;
        }
       t = setTimeout("delayURL(‘"+ url + "‘)", 1000);
    }

function stop1(){   
t && clearTimeout(t);
}
</script>
  </head>
  
  <body>
    恭喜你出错了<br>
   <span id="time" style="background: #00BFFF">10</span>秒钟后自动跳转，如果不跳转，请点击下面的链接<a href="index.jsp">返回首页</a>
<input type="button" value="停止跳转" onclick="stop1();">
<script type="text/javascript">
	delayURL("index.jsp"); 
</script>
  </body>
</html>
