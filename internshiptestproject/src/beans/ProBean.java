package beans;
import java.sql.*;

public class ProBean {
	private String id,eid,seq,ans,mno;
	private int age;

	
	public String getEid() {
		return eid;
	}
	public String getSeq() {
		return seq;
	}
	public String getAns() {
		return ans;
	}
	public int getAge() {
		return age;
	}
	public String getMno() {
		return mno;
	}
	public ProBean() {
		id="";
		
	}
	public void setId(String id) {
		this.id = id;
		onchange();
	}
	private void onchange() {
	
		
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		try
		{
			DBConnector dbc=new DBConnector();
			con=dbc.getDcon();
			pst=con.prepareStatement("select * from users where userid=?;");
			pst.setString(1,id);
			rs=pst.executeQuery();
			while(rs.next())
			{
				age=rs.getInt("age");
				eid=rs.getString("emailid");
				seq=rs.getString("secq");
				mno=rs.getString("mobile");
				ans=rs.getString("ans");
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
			
		
	}
	


}
