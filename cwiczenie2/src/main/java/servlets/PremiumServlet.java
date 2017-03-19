package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

/**
 * Servlet implementation class Premium
 */
@WebServlet("/premium")
public class PremiumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null){
			response.sendRedirect("login.jsp");
		}
		if (user.getRole() == User.roleType.admin || user.getRole() == User.roleType.premium ){
			response.sendRedirect("premium.jsp");
		}
		else {
			response.sendRedirect("profile.jsp");
		}
		if (session.getAttribute("user") == null){
			response.sendRedirect("registration.jsp");
			return;
		}
		else {
			response.sendRedirect("profile");
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
