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
@WebServlet("/viewDoctor_action")
public class viewDoctor_action extends HttpServlet {
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
    	   PreparedStatement ps2 = connection.prepareStatement("Select ID, concat(FirstName,' ', LastName) as Name, Phone from Doctor;");
    	   ResultSet rs = ps2.executeQuery();
    	   
  	    
  	    	while(rs.next())
  	    	{
  	    		
  	    		out.println("Doctor ID: " + rs.getString("ID") + " | " + "Name: " + rs.getString("Name") + " | " + "Phone: " + rs.getString("Phone"));  
  	    		out.println("<html><body><center>-----------------------------------------</center></body></html>");	
  	    	}
    	   
  	    	out.println("<html><body><center><a href = 'Staff.jsp'> Back to home page</a></center></body></html>");	    	
  	        

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
