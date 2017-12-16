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
@WebServlet("/makeAppointment_action")
public class makeAppointment_action extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Customer";
	static final String USER = "root";
	static final String PASS = "root";
    private static Connection connection;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
       
	   String appointmentID, doctorID, patientID, nID,time,date;
       appointmentID = request.getParameter("appointmentid");
       doctorID = request.getParameter("doctorid");
       patientID = request.getParameter("patientid");
       nID = request.getParameter("nurseid");
       date = request.getParameter("date");
       time = request.getParameter("time");
       
       try{
    	   Class.forName("com.mysql.jdbc.Driver").newInstance();
    	   connection = DriverManager.getConnection(DB_URL, USER, PASS);
    	   Statement s = connection.createStatement();
    	   PreparedStatement ps5 = connection.prepareStatement("select count(*) as number from (select * from appointment where id = '"+appointmentID+"') as pok");
    	   ResultSet rs5 = ps5.executeQuery();
    	   PreparedStatement ps2 = connection.prepareStatement("select count(*) as end from (select '"+doctorID+"' from doctor where id = '"+doctorID+"') as doctorok");
    	   ResultSet rs = ps2.executeQuery();
    	   PreparedStatement ps3 = connection.prepareStatement("select count(*) as count from (select '"+patientID+"' from patient where id = '"+patientID+"') as patientok");
    	   ResultSet rs1 = ps3.executeQuery();
    	   PreparedStatement ps4 = connection.prepareStatement("select count(*) as result from (select '"+nID+"' from nurse where id = '"+nID+"') as nurseok");
    	   ResultSet rs2 = ps4.executeQuery();
    	   PreparedStatement ps9 = connection.prepareStatement("select count(*) as conflict from (select * from appointment where doctorid = '"+doctorID+"' and date = '"+date+"' and time = '"+time+"') as nussseok");
    	   ResultSet rs9 = ps9.executeQuery();
    	   if (rs5.next() && rs5.getInt("number")!= 0)
    	   {
    		   out.println("AppoinmentID already in the system!");
    		   out.println("<html><body><center><a href = 'Staff.jsp'> Back to home page</a></center></body></html>");
    	   }
    	   else if (rs9.next() && rs9.getInt("conflict")!=0)
    	   {
    		   out.print("Doctor is budy at that time, please select different date or time");
    	       out.println("<html><body><center><a href = 'makeAppointment.jsp'> Make Again</a></center></body></html>");
    	   }
    	   else if(rs.next() && rs.getInt("end") == 0)
    	   { 
  	         out.print("Doctor NOT Found");
  	         out.println("<html><body><center><a href = 'makeAppointment.jsp'> Make Again</a></center></body></html>");
    	   }
    	   else if(rs1.next() && rs1.getInt("count") == 0)
    	   { 
  	         out.print("Patient NOT Found");
    	     out.println("<html><body><center><a href = 'makeAppointment.jsp'> Make Again</a></center></body></html>");
    	   }
    	   else if(rs2.next() && rs2.getInt("result") == 0)
    	   { 
  	         out.print("Nurse NOT Found");
    	     out.println("<html><body><center><a href = 'makeAppointment.jsp'> Make Again</a></center></body></html>");
    	   }
    	   
    	  else {
    	   
    	  int i = s.executeUpdate("Insert into Appointment value ("+appointmentID+","+doctorID+","+patientID+","+nID+",'"+date+"','"+time+"', '', '', '', '', '', '',0,'','')");
    	  if (i>0)
    	  {
    		 out.print("Appointment Made");
     	     out.println("<html><body><center><a href = 'Staff.jsp'> Back to Homepage</a></center></body></html>");
    	  
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
