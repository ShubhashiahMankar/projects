package beans;
import java.sql.*;

public class Changepass {
	private  String id,pass,status;
	private int m;

	public Changepass() {
		id="";
		pass="";
		status="";
		
	}


	public void setPass(String pass) {
		this.pass = pass;
		onChange();
	}


	private void onChange() {
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		DBConnector n=new DBConnector();
		con=n.getDcon();
		try
		{
			ps=con.prepareStatement("update users set pswd=? where userid=?;");
			ps.setString(1, pass);
			ps.setString(2, id);
			m=ps.executeUpdate();
			if(m>0)
			{
				status="success";
			}
			else
			{
				status="Failed";
			}
			con.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		
}

	public String getStatus() {
		return status;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
