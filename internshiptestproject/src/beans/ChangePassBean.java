package beans;
import java.sql.*;


public class ChangePassBean 
{
	private String np,cp1,status,typ;
	private int n=0;

	public ChangePassBean() {
		np="";
		cp1="";
		status="";
		typ="";
		
	}


	public void setTyp(String typ) {
		this.typ = typ;
	}

	
	public String getStatus() {
		return status;
	}

	public void setNp(String np) {
		this.np = np;
	}

	public void setCp1(String cp1) {
		this.cp1 = cp1;
		onchange();
	}
	
	private void onchange() {
		// TODO Auto-generated method stub
		Connection con;
		PreparedStatement pst;
	    ResultSet rs;
	    try
	    {
	    	DBConnector con1=new DBConnector();
	    	con=con1.getDcon();
	    	pst=con.prepareStatement("update users  set pswd=? where userid=? ;");
	    	pst.setString(1, cp1);
	    	pst.setString(2,typ );
	    	n=pst.executeUpdate();
	    	if(n>0)
	    	{
	    		status="success";
	    	}
	    	else
	    	{
	    		status="Fail";
	    		
	    	}
	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	    
		
	}

    
   
   
	
	
}
