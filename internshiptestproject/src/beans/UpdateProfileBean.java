package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateProfileBean {
	private String id,eid,seq,ans,mno,status;
	private int age,m=0;
	public UpdateProfileBean() {
		id="";
		eid="";
		seq="";
		ans="";
		mno="";
		status="";
		
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public void setAns(String ans) {
		this.ans = ans;
		onchange();
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStatus() {
		return status;
	}
	private void onchange() {
		
		
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		try
		{
			DBConnector dbc=new DBConnector();
			con=dbc.getDcon();
			pst=con.prepareStatement("update users set age=?,emailid=?,secq=?,mobile=?,ans=? where userid=?");
			pst.setInt(1, age);
			pst.setString(2, eid);
			pst.setString(3, seq);
			pst.setString(4,mno);
			pst.setString(5,ans);
			pst.setString(6, id);
			m=pst.executeUpdate();
			if(m>0)
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
