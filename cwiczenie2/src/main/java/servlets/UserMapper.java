package servlets;

import javax.servlet.http.HttpServletRequest;

import models.User;

public class UserMapper {

	public static User getUser( HttpServletRequest request){
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		return user;
	}
	
}
