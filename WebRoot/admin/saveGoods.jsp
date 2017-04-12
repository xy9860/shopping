<%@ page language="java" import="java.util.*" import="java.io.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'saveGoods.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script  type="text/javascript" src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
	</script>
	<script type="text/javascript">
		//jq 的构造方法转换
		/* $(document).ready(abc);//当载入documnet载入时 注册abc
		function abc(){
			alert("----------------");
		} */
		$(document).ready(function (){//直接使用一个匿名的函数直接进行执行
			//CSS中ID选择器只能在页面中显示一次
			/*$("#gname").val();//获得id为ganme的值  */
			$("#gname").blur(function (){
				$.post("/shopping/GoodsSer",{status:"checkGoods",gname:$(this).val()},callBack);
			});
			$("#gname").focus(function (){
				$("#ctypeError").html("");
				$("#ctypeRight").html("");
			});
		});
		function callBack(data){
/* 			alert(data); */
			 if(data=="true"){
				$("#ctypeError").html("<b>✘</b>");
				
			}else{
				$("#ctypeRight").html("<b>✔</b>");
			} 
		}
	</script>
  </head>
  
  <body>
   <%
   
   application.getAttribute("websiteInfo"); 
   %>
   	<form action="/shopping/GoodsSer" method="post">
   		<!-- 商品编号:<input type="text" name="gid"><br> -->
   		商品名称:<input type="text" name="gname" id="gname"><span class="error" id="ctypeError"></span><span class="right" id="ctypeRight"></span><br>
   		商品价格:<input type="text" name="gprice"><br>
   		商品图片:<input type="text" name="gpic"><br>
   		商品品牌:<input type="text" name="gremark"><br>
   		商品描述:<textarea rows="3" cols="20" name="gxremark"></textarea><br>
   		商品是否推荐:<input type="checkbox" name="giscommend" value="true"><br>
   		商品是否启用:<input type="checkbox" name="gisopen" value="true"><br>
   		商品类别:	<%-- <c:if test="${applicationScope.cyList!=null}">
   					<c:forEach items="${applicationScope.cyList}" var="category">
   						<input type="radio" name="cid" value=${category.cid } />${category.ctype}
   					</c:forEach>
   				</c:if> --%>
   				<select name="cid" id="cid">
								<c:forEach items="${applicationScope.cyList}" var="category">
									<option value="${category.cid}">${category.ctype}</option>
								</c:forEach>
							</select><br>
   				<input type="hidden" name="status" value="saveGoods">
   		<input type="submit" value="添加">
   	</form>
  </body>
</html>
