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

public class jdbc_Delete extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String choice4=request.getParameter("delete");
		if (choice4!=null)
		{
		
try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			
		  Statement smt=con.createStatement();
		  
		  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		  
		  while(true)
		  {
			 
			  
			  System.out.println("Enter Deletion Emp id: ");
			  int eId=Integer.parseInt(br.readLine());
			  
			 
			  
			  
			  int count=smt.executeUpdate("delete from employee where eId="+eId);
			  if(count==1)
				  System.out.println(count+"rows deleted");
			  else
				  System.out.println(" no record deleted");
			  
			  System.out.println("Do u want to or more records [Yes/No]");
			  
			  String ch=br.readLine();
			  if(ch.equalsIgnoreCase("no"))
			  break;
			  
		  }
}


catch(Exception e)
{
	System.out.println(e);
}
		}
	}

}
