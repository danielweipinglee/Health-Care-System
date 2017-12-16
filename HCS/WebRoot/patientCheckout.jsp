<%@ page language="java" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
  <head>
    
    <title>insertPayment.html</title>

	

  </head>
  
  <body bgcolor="CCEFE0">
  <div align=center>
    <form method="post" action="reference">
    
    ApointmentID: <input type="text" name="appointmentid"><br><br>
    Total Amount: <input type="text" name="amount"><br><br>
    Reference Number: <input type="text" name="ref"><br><br>
    
    
    
    
    <h3>Please enter payment information: </h3>
    Card Number:<br>
  	<input type="number" name="cardNum" min="1000000000000000" max="9999999999999999"><br><br>
  	Expiration Date (mm/yy):<br>
  	<input type="number" name="expDateMo" min="01" max="12" size="3"> /
  	<input type="number" name="expDateYear" min="17" max="25" size="3"><br><br>
  	Cardholder's Name:<br>
  	<input type="text" name="cardName"><br><br>
  	CVC:<br>
  	<input type="number" name="cvcNum" min="100" max="999" size="2"><br><br>
  	<input type="submit" value="Submit"><br>
    </form>
    </div>
  </body>
  
</html>
