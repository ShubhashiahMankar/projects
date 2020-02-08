package servlet;

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DBConnector;
import beans.NewRege;

/**
 * Servlet implementation class Register1
 */
@WebServlet("/Register1")
public class Register1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String uid,pw,unm1,gen,emid,sq,ans,mn,status,utyp,status1="Activate";
		int age1,m,n;
		try
		{
			Connection con;
			PreparedStatement pst;
			ResultSet rs;
			DBConnector con1=new DBConnector();
	    	con=con1.getDcon();
		
		uid=request.getParameter("uid");
		pw=request.getParameter("psw");
		unm1=request.getParameter("unm");
		utyp=request.getParameter("usertype");
		gen=request.getParameter("gender");
		emid=request.getParameter("eid");
		sq=request.getParameter("ques");
		mn=request.getParameter("mno");
		age1=Integer.parseInt(request.getParameter("age"));
		ans=request.getParameter("ans");
		NewRege j1=new NewRege();
		j1.setUid(uid);
		j1.setPw(pw);
		j1.setUnm1(unm1);
		j1.setUtyp(utyp);
		j1.setGen(gen);
		j1.setEmid(emid);
		j1.setSq(sq);
		j1.setMn(mn);
		j1.setAge1(age1);
		j1.setAns(ans);
		status=j1.getStatus();
		pst=con.prepareStatement("select max(srno) as srno from permissionslog");
		rs=pst.executeQuery();
		if(rs.next())
		{
			n=rs.getInt("srno");
		}
		else
		{
			n=0;
		}
		if(status=="success")
		{
			n+=1;
			pst=con.prepareStatement("insert into permissionslog values(?,?,'|');");
			pst.setInt(1, n);
		    pst.setString(2, uid);
			pst.executeUpdate();
			pst=con.prepareStatement("insert into adminpermit values(?,?);");
			pst.setString(1, status1);
			pst.setString(2, uid);
			pst.executeUpdate();
			response.sendRedirect("rsuccess.jsp");
		}
		else
			{
			response.sendRedirect("rfailed.jsp");
			
				}
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
		
	}

}
