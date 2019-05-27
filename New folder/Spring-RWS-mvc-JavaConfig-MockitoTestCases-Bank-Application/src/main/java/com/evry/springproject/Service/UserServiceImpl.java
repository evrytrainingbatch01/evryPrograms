package com.evry.springproject.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evry.springproject.Dao.UserDAO;
import com.evry.springproject.Domain.Account;
import com.evry.springproject.Domain.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public User addUser(User user) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		Integer accountNumber = rand.nextInt(9000000) + 1000000;
		Account account = new Account();
		account.setAccBalance(new BigDecimal(0));
		account.setUserAccountNo(accountNumber);
		user.setAccount(account);
		userDAO.saveUser(user);

		return user;
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public User getUser(int userId) {
		return userDAO.getUser(userId);
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {

		userDAO.deleteUser(userId);

	}

	@Override
	@Transactional
	public User updateUser(User theUser) {
		userDAO.updateUser(theUser);
		
		return theUser;
		
	}

	@Override
	@Transactional
	public List<User> getUserEmail(String theEmail) {
		return userDAO.getUser(theEmail);
	}

}
