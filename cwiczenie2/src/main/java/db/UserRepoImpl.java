package db;

import java.util.ArrayList;

import models.User;
import repositories.UserRepo;


public class UserRepoImpl implements UserRepo {

	private static ArrayList<User> users = new ArrayList<>();
	
	public UserRepoImpl() {
		User admin = new User();
		admin.setUserName("admin");
		admin.setRole(User.roleType.admin);
		admin.setPassword("admin");
		if (users.isEmpty()){
			users.add(admin);
		}
		
	}
	
	@Override
	public User getUser(String userName) {
		if (userName == null) {
			throw new IllegalArgumentException();
		}
		for(User user : users){
			if (userName.equals(user.getUserName()))
				return user;
		}
		return null;
		}

	@Override
	public void addUser(User user) {
		// mozna dodac petle weryfikujaca nazwe user
		users.add(user);		
	}

	@Override
	public ArrayList<User> getAllUsers() {
		return users;
	}

	
	
}
