package kgn.servlet.com;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login")
public class LoginServlet implements Servlet {

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String userId = (String) request.getParameter("userid");
		String pwd = (String) request.getParameter("pass");
		LoginDAO ld = new LoginDAO();
		boolean lc = ld.loginDetails(userId, pwd);
		if(lc){
			response.getWriter().println("Hello <b>"+ userId +"</b> Welcome to Servlet Class" );

		}else{
			request.getRequestDispatcher("/jsp/index.jsp").include(request, response);  
			//response.getWriter().println("<p color='red;'>User Id or Password is wrong, </br>please provide correct credentilas</p> " );

		}
	//	response.getWriter().println("Hello <b>"+ userId +"</b> Welcome to Servlet Class" );
	}

}
