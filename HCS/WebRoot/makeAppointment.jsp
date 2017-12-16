<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'makeAppointment.jsp' starting page</title>
    


  </head>
  
  <body bgcolor="CCEFE0">

<div align="center">
<h3>Make Appointment</h3>

<form method ="post" action="makeAppointment_action">

Appointment ID: <input type="text" name="appointmentid" value=""><br>
Doctor ID:      <input type="text" name="doctorid" value=""><br>
Patient ID:     <input type="text" name="patientid" value=""><br>
Nurse ID:       <input type="text" name="nurseid" value=""><br>
Date:           <input type="date" name="date" value="">(yyyy-mm-dd)<br> 
Time:          <select name="time">
  <option value="9:00" >9:00 A.M.</option>
  <option value="9:30" >9:30 A.M.</option>
  <option value="10:00">10:00 A.M.</option>
  <option value="10:30">10:30 A.M.</option>
  <option value="11:00">11:00 A.M.</option>
  <option value="11:30">11:30 A.M.</option>
  <option value="12:00">12:00 P.M.</option>
  <option value="12:30">12:30 P.M.</option>
  <option value="13:00">1:00 P.M.</option>
  <option value="13:30">1:30 P.M.</option>
  <option value="14:00">2:00 P.M.</option>
  <option value="14:30">2:30 P.M.</option>
  <option value="15:00">3:00 P.M.</option>
  <option value="15:30">3:30 P.M.</option>
  <option value="16:00">4:00 P.M.</option>
  <option value="16:30">4:30 P.M.</option>
</select><br>
          
<input type="submit" value="Submit">
</form>
</div>

</body>
</html>
