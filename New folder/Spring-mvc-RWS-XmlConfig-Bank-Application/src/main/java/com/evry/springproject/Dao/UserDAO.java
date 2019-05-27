package com.evry.springproject.Dao;

import java.util.List;

import com.evry.springproject.Domain.User;

public interface UserDAO {


	public void saveUser(User user);

	public List<User> getUsers();

	public User getCustomer(int userId);

	public void deleteUser(int userId);

	public void updateUser(User theUser);

	public List<User> getUser(String theEmail);
	

}
