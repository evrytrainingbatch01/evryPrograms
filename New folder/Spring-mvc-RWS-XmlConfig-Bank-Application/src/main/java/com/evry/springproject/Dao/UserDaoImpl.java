package com.evry.springproject.Dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

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

	@Autowired
	private SessionFactory sessionFactory;

	public void saveUser(User user) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(user);

		Random rand = new Random();
		Integer number = rand.nextInt(9000000) + 1000000;

		User TheUser = currentSession.get(User.class, user.getId());

		Account account = new Account();

		account.setAccBalance(new BigDecimal(0));

		account.setUserAccountNo(number);

		TheUser.setAccount(account);

		// save/upate the User ... finally
		currentSession.saveOrUpdate(TheUser);
	}

	@Override
	public List<User> getUsers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<User> theQuery = currentSession.createQuery("from User order by name", User.class);

		// execute query and get result list
		List<User> users = theQuery.getResultList();

		// return the results
		return users;

	}

	@Override
	public User getCustomer(int userId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		// User theUser = currentSession.get(User.class, userId);
		
		Criteria cr = currentSession.createCriteria(User.class);
		
		 cr.add(Restrictions.eq("id",userId));
		 
		 User theUser =(User) cr.uniqueResult();

		return theUser;
	}

	@Override
	public void deleteUser(int userId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from User where id=:customerId");
		theQuery.setParameter("customerId", userId);

		theQuery.executeUpdate();
	}

	@Override
	public void updateUser(User theUser) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theUser);
	}
	

	@Override 
	public List<User> getUser(String theEmail) { 
		// TODO Auto-generatedmethod stub 
		Session currentSession = sessionFactory.getCurrentSession();
		
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<User> criteriaquery = builder.createQuery(User.class);
		Root<User> personRoot = criteriaquery.from( User.class );
		
		
		criteriaquery.select( personRoot );
		criteriaquery.where(builder.like(personRoot.get("email"),"%" + theEmail + "%"));
		
		
		
		 Query<User> users =currentSession.createQuery(criteriaquery);
		 users.setMaxResults(500);
		 
		
		/*
		 * Criteria cr = currentSession.createCriteria(User.class);
		 * 
		 * cr.add(Restrictions.ilike("email",theEmail,MatchMode.ANYWHERE));
		 */
		
		
	// cr.add( Restrictions.On<User>(c => c.Field).IsInsensitiveLike(theEmail, MatchMode.ANYWHERE));
	  
	 /* Query theQuery = null;
	  
	  if (theEmail != null && theEmail.trim().length() > 0) {
	  
	  // search for Email ... case insensitive
		  theQuery=currentSession.createQuery("from User where lower(email) like :theEmail " , User.class);
		  theQuery.setParameter("theEmail", "%" + theEmail.toLowerCase() + "%");
	  
	  }
	  
	  else { 
		  // theSearchName is empty ... so just get all customers
		  theQuery=currentSession.createQuery("from User", User.class);
	  }
	  */
	  
	  // execute query and get result list
	 
	  
	  return users.getResultList(); 
		
	  }

}
