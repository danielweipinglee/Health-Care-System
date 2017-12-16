<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatePatient.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
 <body bgcolor="CCEFE0">
     <center>   
    <h3>Update Patient Record</h3>
    <form method = "post" action="updatePatient_action">
        Appointment ID: <input type="text" style="width: 125px" name="aptID"><br>
        Height: <input type="text" style="width: 50px"  name="height">  inches<br>
        Weight: <input type="text" style="width: 50px"  name="weight"> lbs<br>
        Blood Pressure: <input type="text" style="width: 50px"  name="bp"><br>
        Reason for appointment: <input type="text" style="width: 120px"  name="reason"><br>
        <input type="submit" value="Submit">
    </form>
    </center>
  </body>
</html>
