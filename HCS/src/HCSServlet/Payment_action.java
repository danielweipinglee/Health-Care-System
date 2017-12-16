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
@WebServlet("/Payment_action")
public class Payment_action extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Customer";
	static final String USER = "root";
	static final String PASS = "root";
    private static Connection connection;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
       
	   String ref;
       ref = request.getParameter("ref");
    
       
       try{
    	   Class.forName("com.mysql.jdbc.Driver").newInstance();
    	   connection = DriverManager.getConnection(DB_URL, USER, PASS);
    	   PreparedStatement ps5 = connection.prepareStatement("select count(*) as number from (select * from ReferenceNumber where ref = '"+ref+"') as pok");
    	   ResultSet rs5 = ps5.executeQuery();
    	  
    	   if ( rs5.next() && rs5.getInt("number") > 0)
    	   {
    		   out.println("I found it! Good!");
    		   out.println("<html><body><center><a href = 'credit.jsp'>Continue</a></center></body></html>");
    	   }
    	   else 
    	   {
    		   out.println("Sorry! I cannot find a match!");
    		   out.println("<html><body><center><a href = 'Actor.jsp'>Go back and try again</a></center></body></html>");
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
