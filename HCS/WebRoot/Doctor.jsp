<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Doctor.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  <body bgcolor="CCEFE0">
    <center>
    <form action="EditRecord_action" method="post">
    <button type="button" onclick="window.location = 'editRecord.jsp';">Edit Record</button><br><br>
    <button type="button" onclick="window.location = 'dviewSchedule.jsp';">View Schedule</button><br><br>
    <button type="button" onclick="window.location = 'index.jsp';">Log Out</button><br>
  	
    </form>
    </center>
  </body>
 
</html>
