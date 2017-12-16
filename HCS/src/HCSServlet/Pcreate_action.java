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
@WebServlet("/Pcreate_action")
public class Pcreate_action extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Customer";
	static final String USER = "root";
	static final String PASS = "root";
    private static Connection connection;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
	   String id, fname, lname, phone, email;
       id = request.getParameter("id");
       fname = request.getParameter("firstname");
       lname = request.getParameter("lastname");
       phone = request.getParameter("phone");
       email = request.getParameter("email");
       
       try{
    	   Class.forName("com.mysql.jdbc.Driver").newInstance();
    	   connection = DriverManager.getConnection(DB_URL, USER, PASS);
    	   
    	   PreparedStatement ps2 = connection.prepareStatement("select count(*) as number from (select * from patient where id = '"+id+"') as pok");
    	   ResultSet rs = ps2.executeQuery();
    	   
    	   if (rs.next() && rs.getInt("number")== 0)
    	   {
    		   PreparedStatement s = connection.prepareStatement("Insert into Patient value ('"+id+"','"+fname+"','"+lname+"','"+phone+"','"+email+"','')");
    		   int rs11 = s.executeUpdate();
    		   if (rs11>0){
    		   out.print("Patient Profile Created");
    	       out.println("<html><body><center><a href = 'Staff.jsp'> Back to home page</a></center></body></html>");
      	   }
    		   
    	   }
    	   else {
    		   out.println("PatientID already in the system!");
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
