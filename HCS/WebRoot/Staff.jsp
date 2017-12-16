<%@ page language="java" pageEncoding="UTF-8"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Staff.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
<body bgcolor="CCEFE0">

<center>
<h3>Hello Staff</h3>



<button type="button" onclick="window.location = 'makeAppointment.jsp';">Make Appointment</button><br><br>
<button type="button" onclick="window.location = 'cancelAppointment.jsp';">Cancel Appointment</button><br><br>
<button type="button" onclick="window.location = 'changeAppointment.jsp';">Change Appointment</button><br><br>
<button type="button" onclick="window.location = 'patientProfile.jsp';">Create Patient Profile</button><br><br>
<button type="button" onclick="window.location = 'viewSchedule.jsp';">View Appointment</button><br><br>
<form method = "post" action="viewPatient_action">
    <input type="submit" value="View Patients" />
</form>
<form method = "post" action="viewNurse_action">
    <input type="submit" value="View Nurses" />
</form>
<form method = "post" action="viewDoctor_action">
    <input type="submit" value="View Doctors" />
</form>

<button type="button" onclick="window.location = 'patientCheckout.jsp';">Patient Checkout</button><br><br>

<button type="button" onclick="window.location = 'index.jsp';">Log Out</button><br>


</center>
</body>
</html>