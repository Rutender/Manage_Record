package empSys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class jdbc_Insert extends HttpServlet{
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		
		String choice1=request.getParameter("create");
		
		if(choice1!=null)
		{
try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			
		  PreparedStatement psmt=con.prepareStatement("insert into employee values(?,?,?,?,?)");
		  
		  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		  
		  while(true)
		  {
			  System.out.println("Enter Emp name: ");
			  String eName=br.readLine();
			  
			  System.out.println("Enter Emp id: ");
			  int eId=Integer.parseInt(br.readLine());
			  
			  System.out.println("Enter Emp phone_no: ");
			  String eP=br.readLine();
			  
			  System.out.println("Enter Emp email: ");
			  String eE=br.readLine();
			  
			 
			 // System.out.println("Enter Emp gender: ");
			  //String gender=br.readLine();
			  
			  System.out.println("Enter Emp city: ");
			  String eC=br.readLine();
			  
			  
			  psmt.setString(1,eName);
			  psmt.setInt(2, eId);
			  psmt.setString(3, eP);
			  psmt.setString(4, eE);
			//  psmt.setString(5,gender);
			  psmt.setString(5, eC);
			  
			  
			  int count=psmt.executeUpdate();
			  if(count>=0)
				  System.out.println(count+"record inserted");
			  else
				  System.out.println(" no record inserted");
			  
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
