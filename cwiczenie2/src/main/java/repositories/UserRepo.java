package repositories;

import java.util.ArrayList;

import models.User;

public interface UserRepo {

	User getUser( String userName); 
	void addUser( User user);
	ArrayList<User> getAllUsers();
	
}
