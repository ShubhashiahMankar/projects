package beans;

import java.sql.*;

public class DBConnector {

	private Connection dcon;

	public DBConnector() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			dcon=DriverManager.getConnection("jdbc:mysql://localhost:3306/intern?user=root&password=928403946)");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

	public Connection getDcon() {
		return dcon;
	} 
	
	
}
