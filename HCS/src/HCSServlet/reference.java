package HCSServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;


@SuppressWarnings("serial")
@WebServlet("/reference")
public class reference extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Customer";
	static final String USER = "root";
	static final String PASS = "root";
    private static Connection connection;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
       
	   String r,appointmentid,tm;
       r = request.getParameter("ref");
       appointmentid = request.getParameter("appointmentid");
       tm = request.getParameter("amount");
     
       
       try{
    	   Class.forName("com.mysql.jdbc.Driver").newInstance();
    	   connection = DriverManager.getConnection(DB_URL, USER, PASS);
    	   Statement s = connection.createStatement();
    	   Statement x = connection.createStatement();
    	   PreparedStatement ps5 = connection.prepareStatement("select count(*) as number from (select * from ReferenceNumber where ref = '"+r+"') as pok");
    	   ResultSet rs5 = ps5.executeQuery();
    	   PreparedStatement p = connection.prepareStatement("select count(*) as count from (select * from Appointment where id = '"+appointmentid+"') as pok");
    	   ResultSet rs = p.executeQuery();
    	   if (rs5.next() && rs5.getInt("number")!= 0)
    	   {
    		   out.println("Reference Number already been used!");
    		   out.println("<html><body><center><a href = 'Staff.jsp'> Back to home page</a></center></body></html>");
    	   }
    	   else if (rs.next() && rs.getInt("count") == 0)
    	   {
    		   out.println("AppointmentID not found!");
    		   out.println("<html><body><center><a href = 'Staff.jsp'> Back to home page</a></center></body></html>");
    	   }
     
    	  else {
    	   
    	  int i = s.executeUpdate("Insert into ReferenceNumber value ('"+r+"')");
    	  int j = x.executeUpdate("update appointment set TotalAmount = "+tm+", PaymentStatus = 'completed' where id = '"+appointmentid+"'");
    	  if (i>0 && j >0)
    	  {
    		 out.print("Co-Payment Completed");
     	     out.println("<html><body><center><a href = 'email.jsp'> Send Email</a></center></body></html>");
    	  }
    	  }

       } catch (SQLException se)
       {
    	   se.printStackTrace();
       }
       catch (Exception e){
    	   e.printStackTrace();
       }finally{
    	   try{
    		   if(connection!=null) connection.close();
    	   }catch (SQLException se)
    	   {
    		   se.printStackTrace();
    	   }
       }
	}
}
