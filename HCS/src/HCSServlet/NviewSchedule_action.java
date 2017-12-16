package HCSServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/NviewSchedule_action")
public class NviewSchedule_action extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Customer";
	static final String USER = "root";
	static final String PASS = "root";
    private static Connection connection;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
       
	   String dID;
       dID = request.getParameter("doctorid");
 
       
       try{
    	   Class.forName("com.mysql.jdbc.Driver").newInstance();
    	   connection = DriverManager.getConnection(DB_URL, USER, PASS);
    	   PreparedStatement ps3 = connection.prepareStatement("select count(*) as number from (select * from appointment where doctorid = '"+dID+"') as dID;");
    	   PreparedStatement ps2 = connection.prepareStatement("Select appointment.ID as ID, doctor.lastname as dname, patient.lastname as pname, time, date, reason from appointment inner join doctor on doctorid = doctor.id inner join patient on patient.id = patientid where doctorid = '"+dID+"';");
    	   ResultSet rs = ps2.executeQuery();
    	   ResultSet rs1 = ps3.executeQuery();
    	   
    	   if(rs1.next() && rs1.getInt("number") == 0){ 
  	         out.print("No Appointment Found");
  	       out.println("<html><body><center><a href = 'Nurse.jsp'> Back to home page</a></center></body></html>");
  	        }else {
  	    
  	    	while(rs.next())
  	    	{
  	    		out.println("Appointment Found" + " | ");
  	    		out.println("Apointment ID: " + rs.getString("ID") + " | " + "Doctor: " + rs.getString("dname") + " | " + "Patient: " + rs.getString("pname") + " | " + "Date: " + rs.getString("date") + " | " + "Time: " + rs.getString("time") + " | " + "Reason: " + rs.getString("reason"));  
  	    		out.println("<html><body><center>-----------</center></body></html>");	    	    	
  	    	}
    	   
  	    	out.println("<html><body><center><a href = 'Nurse.jsp'> Back to home page</a></center></body></html>");	    	
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
