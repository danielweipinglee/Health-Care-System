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
@WebServlet("/Ncreate_action")
public class Ncreate_action extends HttpServlet {
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
    	   PreparedStatement ps = connection.prepareStatement("select count(*) as abc from (select * from Nurse where ID = '"+id+"') as asd");
    	   ResultSet rs = ps.executeQuery();
    	   if (rs.next() && rs.getInt("abc")== 0)
    	   {
    		   Statement w = connection.createStatement();
        	   int k = w.executeUpdate("Insert into Nurse value ('"+id+"','"+fname+"','"+lname+"','"+phone+"','"+email+"','"+pin+"')");
    	       if (k>0){
    	       out.print("You are successfully registered!");
    	       out.println("<html><body><center><a href = 'Nlogin.jsp'> Back to Login</a></center></body></html>");
    	       }
    	   }
    	   else 
    	   {
    		   out.println("NurseID already in the system! Sorry!");
    		   out.println("<html><body><center><a href = 'Nlogin.jsp'> Back to Login</a></center></body></html>");
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
