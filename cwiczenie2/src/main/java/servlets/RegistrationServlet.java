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

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRepo users = new UserRepoImpl();
       
    public RegistrationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null){
			response.sendRedirect("registration.jsp");
			return;
		}
		else {
			response.sendRedirect("profile");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User newUser = UserMapper.getUser(request);
		users.addUser(newUser);
		response.sendRedirect("login.jsp");
		
	}

}
