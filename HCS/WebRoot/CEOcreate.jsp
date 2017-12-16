<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CEOcreate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 <body bgcolor="CCEFE0">
  <center>
       <form method="post" action="CEOcreate_action">
        ID Number: <input type="text" name="ID"/><br/>
        First Name:<input type="text" name="FName" /><br/>
        Last Name:<input type="text" name="LName" /><br/>
        Phone Number:<input type="text" name="Phone" /><br/>
        Email:<input type="text" name="Email" /><br/>
        PIN:<input type="text" name="PIN" /><br/>
        <br/><input type="submit" value="Create" />
        </form>
        </center> 
  </body>
</html>
