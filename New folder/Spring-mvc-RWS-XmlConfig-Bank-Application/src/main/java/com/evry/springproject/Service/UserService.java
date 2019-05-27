package com.evry.springproject.Service;

import java.util.List;

import com.evry.springproject.Domain.User;

public interface UserService {


	public   void  addUser(User user);

	public List<User> getUsers();

	public User getUser(int userId);

	public void deleteUser(int userId);

	public void updateUser(User theUser);

	public List<User> getUserEmail(String theEmail);

	
	

}
