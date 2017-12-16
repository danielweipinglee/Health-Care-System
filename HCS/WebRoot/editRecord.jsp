<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editRecord.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body bgcolor="CCEFE0">
  <center>
    <h3>Edit Treatment Record and Prescription</h3>

<form method = "post" action="editRecord_action">
Appointment ID: <input type="text" name="appointmentid" value=""><br><br>
<h5>Treatment Record</h5>
 <textarea rows="10" cols="50" name="comment">
Enter treatment record here...</textarea>

<h5>Prescription</h5>
<textarea rows="10" cols="50" name="comment2">
Enter prescription here...</textarea><br>

Appointment Completion: <input type="text" name="status">y for Yes / n for No<br><br>



<input type="submit" value="Submit">
</form>
</center>
  </body>
</html>
