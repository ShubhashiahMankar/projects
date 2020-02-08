 package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ChangePassBean;
import beans.DBConnector;

import java.sql.*;

/**
 * Servlet implementation class Check
 */
@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("sgsgdfgfd");
		String id,ps,ldtm,typ,unm,d,status = "";
		int m;
		id=request.getParameter("txt");
		ps=request.getParameter("psw");
		ldtm=request.getParameter("logdt");
		PrintWriter out=response.getWriter();
		
		
		Connection con;
		PreparedStatement pst,pst1;
		ResultSet rs,rs1;
		
		try
		{
			DBConnector j1=new DBConnector();
			con=j1.getDcon();
			pst=con.prepareStatement("select * from users where userid=? and pswd=?;");
			pst.setString(1, id);
			pst.setString(2, ps);
			rs=pst.executeQuery();
			pst1=con.prepareStatement("select * from adminpermit where userid=?;");
			pst1.setString(1, id);
			rs1=pst1.executeQuery();
		        	if(rs.next())
	         	{
		        		if(rs1.next())
		        		
		        			status=rs1.getString("status");
		        		
			          HttpSession ses=request.getSession(true);
			          ses.setAttribute("userid", id);
			          ses.setAttribute("logindtm", ldtm);
			         d=ses.getAttribute("logindtm").toString();
	                 typ=rs.getString("usertype");	
			         unm= rs.getString("usernm");
			         m=rs.getInt("cono");
			         m+=1;
			        pst=con.prepareStatement("insert into counts(usernm,userid,count,DateTime) values(?,?,?,CURRENT_TIMESTAMP);");
			        pst.setString(1,unm );
			        pst.setString(2, id);
			        pst.setInt(3,m );
			        pst.executeUpdate();
			        ses.setAttribute("usertype", typ);
		  	     
			       if(typ.equals("User") && status.equals("Activate"))
			       {
				      response.sendRedirect("User.jsp");
			       }
			       if(typ.equals("User") &&  status.equals("Deactivate"))
			       {
			    	   response.sendRedirect("Deactivate.jsp");
			       }
			      if(typ.equals("Admin"))
				      response.sendRedirect("CompanyAdmin.jsp");
	         	} 			
	         	
		    	else
		  	    response.sendRedirect("Failure.jsp");
		  		        
		        	
		    con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
	}

}
