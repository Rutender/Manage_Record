package empSys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class jdbc_Update extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		
String choice3=request.getParameter("update");
		
		
		String value1;
		int eId;
		String eP;
		//String city;
		//String eE;
		if(choice3!=null)
		{
		
		try {
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
					
					
				  Statement smt=con.createStatement();
				  
				  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				  
					 
					  
					 
					  
					 
					  
					  System.out.println("Enter Empid: ");
					  value1=br.readLine();
					  eId=Integer.parseInt(value1);
					  
					 
					  System.out.println("Enter Emp new phoneno: ");
					  value1=br.readLine();
					  eP=value1;
					  
					 // System.out.println("Enter Emp new city: ");
					  //value1=br.readLine();
					  //city=value1;
					  
					//  System.out.println("Enter Emp new eE: ");
					  //value1=br.readLine();
					  //eE=value1;
					  
					  
					 
					  
					 
					  
					  int count=smt.executeUpdate("update employee set eP="+eP+" where eId="+eId);
					  if(count>0)
						  System.out.println(count+"row updated");
					  else
						  System.out.println(" no record inserted");
					  
					  
		}


		catch(Exception e)
		{
			System.out.println(e);
		}
		}
		
	}
	

}
