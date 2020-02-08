package beans;
import java.sql.*;


public class ForgetPassBean {
	private String seq,ans,status,id,pass;

	public ForgetPassBean() {
	       seq="";
	       ans="";
	       status="";
	       id="";
	       pass="";
	}

	public String getPass() {
		return pass;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public void setAns(String ans) {
		this.ans = ans;
		onchange();
		
	}

	private void onchange() {
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try
		{
			DBConnector con1=new DBConnector();
			con=con1.getDcon();
			pst=con.prepareStatement("select * from users where userid=? and ans=?;");
			pst.setString(1,id );
			pst.setString(2, ans);
			rs=pst.executeQuery();
			if(rs.next())
			{
			 pass=rs.getString("pswd");
			 status="success";
			}
			else
			{
				status="Failed";
			}
			
					
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
	

}
