package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class NewRege {
	
	private String uid,pw,unm1,gen,emid,sq,ans,status,mn,utyp;
	int age1,m=0;
	public NewRege() {
		
		uid="";
		pw="";
		unm1="";
		gen="";
		emid="";
		sq="";
		ans="";
		status="";
		mn="";
		utyp="";
		age1=0;
		
	}
	public void setUtyp(String utyp) {
		this.utyp = utyp;
	}
	public String getStatus() {
		return status;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setUnm1(String unm1) {
		this.unm1 = unm1;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public void setEmid(String emid) {
		this.emid = emid;
	}
	public void setSq(String sq) {
		this.sq = sq;
	}
	public void setAns(String ans) {
		this.ans = ans;
		changeAnswer();
	}
	private void changeAnswer()
	{
		try
		{
		Connection con;
		PreparedStatement pst;
		
		
		DBConnector db2=new DBConnector();
		con=db2.getDcon();
		pst=con.prepareStatement("insert into users values(?,?,?,?,?,?,?,?,?,?,0);");
		pst.setString(1, uid);
		pst.setString(2, pw);
		pst.setString(3, unm1);
		pst.setString(4, utyp);
		pst.setInt(5, age1);
		pst.setString(6, gen);
		pst.setString(7, mn);
		pst.setString(8, emid);
		pst.setString(9, sq);
		pst.setString(10, ans);
	    m=pst.executeUpdate();
		if(m==1)
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
	public void setMn(String mn)
	{
		this.mn = mn;
	}
	public void setAge1(int age1)
	{
		this.age1 = age1;
	}
	
		
	
	
	

}
