package empSys;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class jdbc_Select extends HttpServlet {
	
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		
//String choice2=request.getParameter("read");
		
	//	if(choice2!=null)
		//{
try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from employee ");
			
			
			while(rs.next())
			{
				String eName=rs.getString(1);
				int eId=Integer.parseInt(rs.getString(2));
				String eP=rs.getString(3);
				String eE=rs.getString(4);
				//String gender =rs.getString(5);
				String eC=rs.getString(5);
				
				
				
				System.out.println("Empl name: "+eName);
				System.out.println("Empl id: "+eId);
				System.out.println("Empl phone_no: "+eP);
				System.out.println("Empl email: "+eE);
				//System.out.println("Empl gender: "+gender);
				System.out.println("Empl city: "+eC);
				
				System.out.println("\n");
				
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		//}
		
	}
}
