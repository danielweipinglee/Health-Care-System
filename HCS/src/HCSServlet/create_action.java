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
@WebServlet("/create_action")
public class create_action extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Customer";
	static final String USER = "root";
	static final String PASS = "root";
    private static Connection connection;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
       String id;
	   String fname, lname, phone, email, pin;
       id = request.getParameter("ID");
       fname = request.getParameter("FName");
       lname = request.getParameter("LName");
       phone = request.getParameter("Phone");
       email = request.getParameter("Email");
       pin = request.getParameter("PIN");
       
       try{
    	   Class.forName("com.mysql.jdbc.Driver").newInstance();
    	   connection = DriverManager.getConnection(DB_URL, USER, PASS);
   
    	   PreparedStatement s1 = connection.prepareStatement("Select count(*) as count from (select * from person where id = '"+id+"') as per;");
    	   ResultSet rs = s1.executeQuery();
    	   if (rs.next()&&rs.getInt("count")==0)
    	   {
    		   Statement s = connection.createStatement();
    	   
        	   int i = s.executeUpdate("Insert into Person value ('"+id+"','"+fname+"','"+lname+"','"+phone+"','"+email+"','"+pin+"')");
    	       if (i>0){
    	   out.print("You are successfully registered!");
    	   out.println("<html><body><center><a href = 'login.jsp'> Back to Login</a></center></body></html>");
    	   }
    	   }
    	       else
    	       {
    	    	   out.print("StaffID Already in the System! We are sorry!");
    	    	   out.println("<html><body><center><a href = 'login.jsp'> Back to Login</a></center></body></html>");
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
