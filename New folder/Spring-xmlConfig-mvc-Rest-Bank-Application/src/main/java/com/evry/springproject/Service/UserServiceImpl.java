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

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public void addUser(User user) {
		// TODO Auto-generated method stub

		/*
		 * boolean flag = false; Random rand = new Random(); Integer number =
		 * rand.nextInt(9000000) + 1000000;
		 * 
		 * User theUser = userDAO.saveUser(user); if (null != theUser && theUser.getId()
		 * != 0) { Account account = new Account(); // account.setId(temp);
		 * account.setAccBalance(new BigDecimal(0)); account.se
		 * 
		 * account.setCustomerACCId(theUser.getCustomeAccountId()); flag =
		 * accountDao.addAccount(account); } return flag ? theUser : null;
		 */

		// int userID=user.getId();

		/*
		 * Account account=session.get(Employee.class, Id);
		 * 
		 * account.setAccBalance(new BigDecimal(0));
		 * 
		 * account.setUserAccountNo(number);
		 */

		userDAO.saveUser(user);

	}

	@Override
	@Transactional
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return userDAO.getCustomer(userId);
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

		userDAO.deleteUser(userId);

	}

	@Override
	@Transactional
	public void updateUser(User theUser) {
		// TODO Auto-generated method stub
		userDAO.updateUser(theUser);
	}

	@Override
	@Transactional
	public List<User> getUserEmail(String theEmail) {
		// TODO Auto-generated method stub
		return userDAO.getUser(theEmail);
	}

}
