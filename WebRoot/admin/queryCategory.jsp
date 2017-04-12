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
    
    <title>My JSP 'saveCategory.jsp' starting page</title>
    
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
		$("document").ready(function(){
			//$("#table1 tr:odd").addClass("red");//偶数行变色
			$("#table1 tr").not(":first").mouseover(function(){
				$(this).addClass("trBg");
			});
			$("#table1 tr").not(":first").mouseout(function(){
				$(this).removeClass("trBg");
			});
			$(".updStn").click(function(){
				var chkbox=$(this).parent().prev().prev().children();//按钮的父亲的兄弟的兄弟的儿子
				var ctyprTd=$(this).parent().prev().prev().prev().children();
				if($(this).val()=="更新"){
					chkbox.removeAttr("disabled");
					ctyprTd.removeAttr("disabled");
					$(this).val("确认");
				}else{
					$(this).val("更新");
					chkbox.attr("disabled","disabled");
					ctyprTd.attr("disabled","disabled");
				}
			});
		});
	</script>
	<style type="text/css">
		.trBg{
			background-color:gray;
		}
		.red{
			background-color:red;
		}
	</style>
  </head>
  
  <body>
    <form action="/shopping/CategorySer" method="post">
    	查询:<input type="text" name="ctype" /><br> 
    <input type="submit" value="提交" />
    <input type="hidden" value="queryCategory" name="status">
    </form>
    <c:if test="${requestScope.cyList!=null}">
    	<table border="1" id="table1">
    		<tr>
    			<th>编号</th>
    			<th>类别名</th>
    			<th>是否推荐</th>
    			<th>所属客服</th>
    			<th>更新</th>
    		</tr>
    		<c:forEach items="${requestScope.cyList}" var="category" varStatus="num">
    		<tr>
    			<td>${num.count}</td>
    			<td><input type="text" value="${category.ctype }" disabled="disabled" size="8"></td>
    			<td>
					<c:choose>
						<c:when test="${category.chot=='true' }">
							<input type="checkbox" checked="checked" value="true" disabled="disabled" >
						</c:when>
						<c:otherwise>
							<input type="checkbox" value="true" disabled="disabled" >
						</c:otherwise>
					</c:choose>
				</td>
    			<td>${category.account.aname }</td>
    			<td><input type="button" value="更新" class="updStn"></td>
    		</tr>
    		</c:forEach>
    	</table>
    </c:if>
  </body>
</html>
