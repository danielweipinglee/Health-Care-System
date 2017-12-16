<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    
    <title>insertPayment.html</title>

	

  </head>
  
  <body bgcolor="CCEFE0">
  <div align=center>
    <form method="post" action="result">    
   <h3>Please enter payment information: </h3>
    Card Number:<br>
  	<input type="number" name="cardNum" value = "0000000000000000" min="1000000000000000" max="9999999999999999"><br><br>
  	Expiration Date (mm/yy):<br>
  	<input type="number" name="expDateMo" value = "00" min="01" max="12" size="3"> /
  	<input type="number" name="expDateYear" value = "00" min="17" max="25" size="3"><br><br>
  	Cardholder's Name:<br>
  	<input type="text" name="cardName"><br><br>
  	CVC:<br>
  	<input type="number" name="cvcNum" value = "00" min="100" max="999" size="2"><br><br>
  	<input type="submit" value="Submit"><br>
    </form>
    </div>
  </body>
  
</html>