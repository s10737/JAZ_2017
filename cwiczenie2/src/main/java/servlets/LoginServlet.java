package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.UserRepoImpl;
import models.User;
import repositories.UserRepo;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRepo users = new UserRepoImpl();

    public LoginServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null){
			response.sendRedirect("login.jsp");
			return;
		}
		else {
			response.sendRedirect("profile");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = users.getUser(request.getParameter("userName"));
		if (user == null){
			response.sendRedirect("login");
			return;
		}
		if (user.getPassword().equals(request.getParameter("password"))){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("userName", user.getUserName());
			response.sendRedirect("profile");
		}
		else {
			response.sendRedirect("login");
		}	
		
	}

}
