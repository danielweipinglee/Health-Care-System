<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CEO.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body bgcolor="CCEFE0">
  <center>
<h3>View Report</h3>
<form method = "post" action="viewReport_action">
    <input type="submit" value="View Daily Report" />
</form>

<form method = "post" action="viewMReport_action">
    <input type="submit" value="View Monthly Report" />
</form>
<button type="button" onclick="window.location = 'index.jsp';">Log Out</button><br>
</center>
  </body>
</html>
