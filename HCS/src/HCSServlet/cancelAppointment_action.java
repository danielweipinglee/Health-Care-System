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
@WebServlet("/cancelAppointment_action")
public class cancelAppointment_action extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Customer";
	static final String USER = "root";
	static final String PASS = "root";
    private static Connection connection;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
       
	   String appointmentID;
       appointmentID = request.getParameter("appointmentid");
 
       
       try{
    	   Class.forName("com.mysql.jdbc.Driver").newInstance();
    	   connection = DriverManager.getConnection(DB_URL, USER, PASS);
    	   PreparedStatement ps2 = connection.prepareStatement("Delete from Appointment where id = '"+appointmentID+"';");
    	   int rs = ps2.executeUpdate();
    	   
    	   if(rs==0)
    	   { 
  	         out.print("Opps! Appointment does not exist!");
  	         out.println("<html><body><center><a href = 'Staff.jsp'> Back to home page</a></center></body></html>");
    	   }
    	   else 
    	   {
    		   out.print("Appointment Canceled");
    	         out.println("<html><body><center><a href = 'Staff.jsp'> Back to home page</a></center></body></html>");
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
