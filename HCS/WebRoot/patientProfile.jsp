<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'patientProfile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  <body bgcolor="CCEFE0">

<center>
<h3>Patient Profile</h3>

<form method = "post" action="Pcreate_action">

ID:            <input type="text" name="id" ><br>
First Name:    <input type="text" name="firstname" ><br>
Last Name:     <input type="text" name="lastname" ><br>
Phone Number:  <input type="text" name="phone" ><br>
Email Address: <input type="text" name="email" ><br><br>

          
<input type="submit" value="Submit">
</form>
</center>

</body>
</html>
