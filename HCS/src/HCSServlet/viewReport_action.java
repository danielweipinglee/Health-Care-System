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
@WebServlet("/viewReport_action")
public class viewReport_action extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Customer";
	static final String USER = "root";
	static final String PASS = "root";
    private static Connection connection;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
       
 
       
       try{
    	   Class.forName("com.mysql.jdbc.Driver").newInstance();
    	   connection = DriverManager.getConnection(DB_URL, USER, PASS);
    	   PreparedStatement ps2 = connection.prepareStatement("Select  concat(Doctor.FirstName,' ', Doctor.LastName) as Name, Numberofpatient, date, totalincome from dailyreport inner join doctor on doctorid = doctor.id;");
    	   ResultSet rs = ps2.executeQuery();
    	   
  	    
  	    	while(rs.next())
  	    	{
  	    		
  	    		out.println("Doctor Name: " + rs.getString("Name") + " | " + "Number Of Patient: " + rs.getString("Numberofpatient") + " | " + "Total Income: " + rs.getString("totalincome") + " | " + " Date: " + rs.getDate("date"));  
  	    		out.println("<html><body><center>-----------------------------------------</center></body></html>");	    	    	
  	    	}
    	   
  	    	out.println("<html><body><center><a href = 'CEO.jsp'> Back to home page</a></center></body></html>");	    	
  	        

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
