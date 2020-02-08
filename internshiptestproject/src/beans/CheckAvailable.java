package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckAvailable {
	
	private String userid;
	private String status;
	public CheckAvailable() {
		userid="";
		status="";
	}
	public String getStatus() {
		return status;
	}
	public void setUserid(String userid) {
		this.userid = userid;
		findUser();
	}
	private void findUser() {
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		try
		{
			DBConnector dbc=new DBConnector();
			con=dbc.getDcon();
			pst=con.prepareStatement("select * from users where userid=?;");
			pst.setString(1,userid);
			rs=pst.executeQuery();
			
			if(rs.next())
				status="failed";
			else
				status="success";
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	

}
