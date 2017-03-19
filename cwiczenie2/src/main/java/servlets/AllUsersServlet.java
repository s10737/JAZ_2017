package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.UserRepoImpl;
import models.User;
import repositories.UserRepo;


@WebServlet("/users")
public class AllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRepo users = new UserRepoImpl();
       

    public AllUsersServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user.getRole() == User.roleType.admin) {
			request.setAttribute("users", users.getAllUsers());
			RequestDispatcher dispatcher = request.getRequestDispatcher("users.jsp");
			if (dispatcher != null){  
			      dispatcher.forward(request, response);
			}	
		}
		else {
			response.sendRedirect("profile.jsp");
		}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = users.getUser(request.getParameter("userName"));
		if (user != null){
			user.setRole(User.roleType.valueOf(request.getParameter("role")));
		} 
		
		doGet(request, response);
	}

}
