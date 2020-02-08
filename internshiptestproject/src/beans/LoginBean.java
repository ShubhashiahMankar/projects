package beans;
import java.sql.*;

public class LoginBean {
	private String uid,unm,date;
	public String getDate() {
		return date;
	}

	int m;

	public LoginBean() {
		super();
		uid="";
		unm="Userid Not Found";
		
	}

	public String getUnm() {
		return unm;
	}

	public int getM() {
		return m;
	}

	public void setUid(String uid) {
		this.uid = uid;
		onchange();
	}

	private void onchange() {
	    Connection con;
	    PreparedStatement pst;
	    ResultSet rs;
	    try
	    {
	    	
	    DBConnector d=new DBConnector();
	    con=d.getDcon();
	    pst=con.prepareStatement("select usernm,count(*) as count,max(DateTime) as DateTime from counts where userid=?");
	    pst.setString(1, uid);
	    rs=pst.executeQuery();
	    while(rs.next())
	    {
	    	unm=rs.getString("usernm");
	    	m=rs.getInt("count");
	    	date=rs.getString("DateTime");
	    	
	    }
	    
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	    
	}

	
	
	

}
