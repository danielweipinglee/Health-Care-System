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
@WebServlet("/editRecord_action")
public class editRecord_action extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Customer";
	static final String USER = "root";
	static final String PASS = "root";
    private static Connection connection;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
       
	   String apid, c1, c2,s1;
       apid = request.getParameter("appointmentid");
       c1 = request.getParameter("comment");
       c2 = request.getParameter("comment2");
       s1 = request.getParameter("status");

 
       
       try{
    	   Class.forName("com.mysql.jdbc.Driver").newInstance();
    	   connection = DriverManager.getConnection(DB_URL, USER, PASS);
    	   PreparedStatement ps2 = connection.prepareStatement("update Appointment set TreatmentRecord= '"+c1+"', Prescription = '"+c2+"', status='"+s1+"' where id = '"+apid+"';");
    	   int s = ps2.executeUpdate();
    	   
    	   if(s>0)
    	   { 
    		   out.print("Record Updated");
  	           out.println("<html><body><center><a href ='Doctor.jsp'> Back to home page</a></center></body></html>");
    	   }
    	   else 
    	   {
    		   out.print("Appointment not found");
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

