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
@WebServlet("/viewTreatment_action")
public class viewTreatment_action extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Customer";
	static final String USER = "root";
	static final String PASS = "root";
    private static Connection connection;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
       
	   String aID;
       aID = request.getParameter("appointmentid");
 
       
       try{
    	   Class.forName("com.mysql.jdbc.Driver").newInstance();
    	   connection = DriverManager.getConnection(DB_URL, USER, PASS);
    	   PreparedStatement ps3 = connection.prepareStatement("select count(*) as number from (select * from appointment where id = '"+aID+"') as aID;");
    	   PreparedStatement ps2 = connection.prepareStatement("Select doctor.lastname as dname, patient.lastname as pname, time, date, treatmentrecord from appointment inner join doctor on doctorid = doctor.id inner join patient on patient.id = patientid where appointment.id = '"+aID+"';");
    	   ResultSet rs = ps2.executeQuery();
    	   ResultSet rs1 = ps3.executeQuery();
    	   
    	   if(rs1.next() && rs1.getInt("number") == 0){ 
  	         out.print("No Appointment Found");
  	         out.println("<html><body><center><a href = 'Nurse.jsp'> Back to home page</a></center></body></html>");
  	        }else {
  	    	if (rs.first())
  	    	{
  	    		out.println("Treatment Record Found" + " | ");
  	    		out.println("Doctor: " + rs.getString("dname") + " | " + "Patient: " + rs.getString("pname") + " | " + "Date: " + rs.getString("date") + " | " + "Time: " + rs.getString("time") + " | " + "Treatment Record: " + rs.getString("treatmentrecord"));  
  	    		out.println("<html><body><center><a href = 'Nurse.jsp'> Back to home page</a></center></body></html>");	    	
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
