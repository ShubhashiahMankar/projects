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

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	   String cp,np,cp1,status,typ;
	   HttpSession ses=request.getSession(true);
	   typ=ses.getAttribute("userid").toString();
	   
       PrintWriter out=response.getWriter();
       cp=request.getParameter("curps");
       np=request.getParameter("newps");
		cp1=request.getParameter("conps");
		ChangePassBean m=new ChangePassBean();
		m.setTyp(typ);
		m.setNp(np);
		m.setCp1(cp1);
		
		status=m.getStatus();
		if(status=="success")
		{
			response.sendRedirect("Change.jsp");
		}
		else
		{
			response.sendRedirect("failed.jsp");
		}
		
		
       
       
	}

}
