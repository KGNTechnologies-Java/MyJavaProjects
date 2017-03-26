package kgn.servlet.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCredentials
 */
@WebServlet("/login")
public class LoginCredentials extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCredentials() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = (String) request.getParameter("userid");
		String pwd = (String) request.getParameter("pass");
		LoginDAO ld = new LoginDAO();
		boolean lc = ld.loginDetails(userId, pwd);
		if(lc){
			response.getWriter().println("Hello <b>"+ userId +"</b> Welcome to HttpServlet Class" );

		}else{
			//request.getRequestDispatcher("/jsp/index.jsp").include(request, response);  
			response.sendRedirect("/jsp/index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
