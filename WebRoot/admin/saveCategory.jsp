<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'saveCategory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
var xmlhttp=null;
	function checkCtype(){
		//创建XMLHttpRequest对象
		xmlhttp=new XMLHttpRequest();
		//拿到要验证的数据
		var ctype= document.getElementById("ctype").value;
		//构建一个无刷新的异步请求
		xmlhttp.open("post", "/shopping/CategorySer?status=checkCtype&ctype="+ctype,"true" );//状态0
		//设置回调函数 callBack,这里不使用callBack()  不是调用而是事件注册
		xmlhttp.onreadystatechange=callBack;
		//发送异步请求//状态1
		xmlhttp.send(null);
		//状态2
	}
	function callBack(){
		if(xmlhttp.readyState==4&&xmlhttp.status==200){//状态4,并且码为200
			if(xmlhttp.responseText=="true"){
				document.getElementById("ctypeError").innerHTML="<b>✘</b>";
			}else{
				document.getElementById("ctypeRight").innerHTML="<b>✔</b>";
			}
		}
	}
	function clearError(){
		document.getElementById("ctypeError").innerHTML="";
		document.getElementById("ctypeRight").innerHTML="";
	}
</script>
<style type="text/css">
	.error{
		color:"red";
	}
	.right{
		color:"green";
	}
</style>
  </head>
  
  <body>
    <form action="/shopping/CategorySer" method="post">
    类别名:<input type="text" name="ctype" id="ctype" onblur="checkCtype()" onfocus="clearError()" /><span class="error" id="ctypeError"></span><span class="right" id="ctypeRight"></span><br> 
    是否热点:<input type="checkbox" name="chot" value="true" /><br>
    <input type="submit" value="提交" />
    <input type="hidden" value="saveCategory" name="status">
    </form>
  </body>
</html>
