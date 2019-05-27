package com.evry.springproject.Dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.type.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evry.springproject.Domain.Account;
import com.evry.springproject.Domain.User;

@Repository
public class UserDaoImpl implements UserDAO {

@PersistenceContext
private EntityManager entityManager;
	
	/*
	 * @Autowired public UserDaoImpl(EntityManager theEntityManager) { entityManager
	 * = theEntityManager; }
	 */
	
	
	public void saveUser(User user) {
		
	//	System.out.println("DaoImpl---->"+user);
		
		// save or update the employee
				entityManager.persist(user);
		}

	@SuppressWarnings("rawtypes")
	@Override
	public List<User> getUsers() {
		

		// create a query
		Query theQuery = 
				(Query) entityManager.createQuery("from User");
		
		// execute query and get result list
		List<User> employees = theQuery.getResultList();
		
		// return the results		
		return employees;

	}

	@Override
	public User getUser(int userId) {
		// get employee
				User theUser = 	entityManager.find(User.class, userId);
				
				// return employee
				return theUser;
	}

	@Override
	public void deleteUser(int userId) {
		// delete object with primary key
				Query theQuery = (Query) entityManager.createQuery(
									"delete from User where id=:userId");
				
				theQuery.setParameter("userId", userId);
				
				theQuery.executeUpdate();
	}

	@Override
	public void updateUser(User theUser) {
		// save or update the User
		User dbUser= entityManager.merge(theUser);
		
		// update with id from db ... so we can get generated id for save/insert
		dbUser.setId(dbUser.getId());
	}

	@Override
	public List<User> getUser(String theEmail) {
		
			return null;
		
	}

}
