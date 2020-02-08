package beans;

import java.sql.*;

public class FileDetailsstorer {
	private String userid,filename,filetyp,status;
	private long filesize;

	public FileDetailsstorer() {
		userid="";
		filename="";
		filetyp="";
		filesize=0;
		status="";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletyp() {
		return filetyp;
	}

	public void setFiletyp(String filetyp) {
		this.filetyp = filetyp;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
    private void execute()
    {
    DBConnector db=new DBConnector();
    Connection con;
    PreparedStatement pst;
    
    
    try 
    {
    	con=db.getDcon();
    	pst=con.prepareStatement("insert into upload value(?,?,?,?);");
    	int c=pst.executeUpdate();
    	if(c>0)
    		status="ture";
    	else
    		status="false";
    	
    	
    }
    catch(Exception e)
    {
    	System.out.println(e);
    }
    
    
    }
}
