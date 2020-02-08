package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UpdateProfileBean;

/**
 * Servlet implementation class Updateprofile
 */
@WebServlet("/Updateprofile")
public class Updateprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateprofile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String mno,eid,secq,ans,id,sta;
	int age;
	PrintWriter out=response.getWriter();
	HttpSession ses=request.getSession(true);
	id=ses.getAttribute("userid").toString();
	mno=request.getParameter("mno");
	eid=request.getParameter("eid");
	secq=request.getParameter("ques");
	ans=request.getParameter("ans");
	age=Integer.parseInt(request.getParameter("txt"));
	UpdateProfileBean j=new UpdateProfileBean();
	j.setId(id);
	j.setAge(age);
	j.setMno(mno);
	j.setEid(eid);
	j.setSeq(secq);
	j.setAns(ans);
	sta=j.getStatus();
	if(sta=="success")
	{
	response.sendRedirect("Supro.html");
	}
	else
	{
		response.sendRedirect("Fupro.html");
		
	}
	
	
	
	
	}

}
