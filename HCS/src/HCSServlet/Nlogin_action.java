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
@WebServlet("/Nlogin_action")
public class Nlogin_action extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Customer";
	static final String USER = "root";
	static final String PASS = "root";
	
	
	private static Connection connection;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
 	   PrintWriter out = response.getWriter();
 	   response.setContentType("text/html");
       String m, p;
       m = request.getParameter("email");
       p = request.getParameter("pass");
       try{
       Class.forName("com.mysql.jdbc.Driver").newInstance();
 	   connection = DriverManager.getConnection(DB_URL, USER, PASS);
 	   PreparedStatement ps = connection.prepareStatement("select COUNT(Email) as number from (SELECT Email, PIN FROM Nurse WHERE Email = '"+m+"' AND PIN = '"+p+"') as user;");
 	   ResultSet rs = ps.executeQuery();
 	  
 	   if(rs.first() && rs.getInt("number") == 0){ 
 	         out.print("alert('No Recourd Found')");
 	         response.sendRedirect("Nlogin.jsp");
 	   }else{ 
    	   out.print("Login");
           response.sendRedirect("Nurse.jsp");
       }
       
       }catch (SQLException se)
       {
    	   se.printStackTrace();
       }
       catch (Exception e){
    	   e.printStackTrace();
    }
}
}