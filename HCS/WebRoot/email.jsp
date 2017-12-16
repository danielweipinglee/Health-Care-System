<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<body bgcolor="CCEFE0">

<p>
Email link:
<a href="mailto:?Subject=Thank%20You" target="_top">Send Reference Number to Patient</a><br><br>
<a href="Staff.jsp">Back to HomePage</a>
</p>


</body>
</html>