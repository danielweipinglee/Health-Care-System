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
@WebServlet("/updatePatient_action")
public class updatePatient_action extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Customer";
	static final String USER = "root";
	static final String PASS = "root";
    private static Connection connection;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
       
	   String aid, hid, wid,bp,reason;
       aid = request.getParameter("aptID");
       hid = request.getParameter("height");
       wid = request.getParameter("weight");
       bp = request.getParameter("bp");
       reason = request.getParameter("reason");
 
       
       try{
    	   Class.forName("com.mysql.jdbc.Driver").newInstance();
    	   connection = DriverManager.getConnection(DB_URL, USER, PASS);
    	   PreparedStatement ps2 = connection.prepareStatement("update Appointment set Height = '"+hid+"', Weight = '"+wid+"' , BloodPressure = '"+bp+"',Reason = '"+reason+"' where id = '"+aid+"';");
    	   int rs = ps2.executeUpdate();
    	   
    	   if(rs==0)
    	   { 
  	         out.print("opps! Appoint does not exist!");
  	         out.println("<html><body><center><a href ='Nurse.jsp'> Back to home page</a></center></body></html>");
    	   }
    	   else 
    	   {
    		   out.print("Record Updated");
    	         out.println("<html><body><center><a href ='Nurse.jsp'> Back to home page</a></center></body></html>");
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

