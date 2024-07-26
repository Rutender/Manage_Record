package empSys;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class jdbc_Connect extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		
try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			Statement smt=con.createStatement();
			smt.executeUpdate("create table Employee(eName varchar2(20),eId number primary key,eP varchar(10),eE varchar(30),eC varchar(10)) ");
			
			System.out.print("table created suceesfully");
			con.close();
			
		}
		catch(Exception e)
		{
			
			System.out.println(e);
		}
	}

	
}
