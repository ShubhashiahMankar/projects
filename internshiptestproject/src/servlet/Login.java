package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DBConnector;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id,ps,ldtm,typ,unm,d;
		int m;
		id=request.getParameter("txt");
		ps=request.getParameter("psw");
		ldtm=request.getParameter("logdt");
		PrintWriter out=response.getWriter();
		
		
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try
		{
			DBConnector j1=new DBConnector();
			con=j1.getDcon();
			pst=con.prepareStatement("select * from users where userid=? and password=?;");
			pst.setString(1, id);
			pst.setString(2, ps);
			rs=pst.executeQuery();
			
		
	        	if(rs.next())
	         	{
			     HttpSession ses=request.getSession(true);
			     ses.setAttribute("userid", id);
			     ses.setAttribute("logindtm", ldtm);
			     d=ses.getAttribute("logindtm").toString();
			     
			     typ=rs.getString("usertype");	
			     unm=rs.getString("usernm");
			     /*m=rs.getInt("cono");
			     m+=1;
			     pst=con.prepareStatement("insert into counts(usernm,userid,count,DateTime) values(?,?,?,CURRENT_TIMESTAMP);");
			     pst.setString(1,unm );
			     pst.setString(2, id);
			     pst.setInt(3,m );
			     pst.executeUpdate();*/
			     ses.setAttribute("usertype", typ);
		  	     
			       if(typ.equals("user"))
				      response.sendRedirect("User.jsp");
			
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
