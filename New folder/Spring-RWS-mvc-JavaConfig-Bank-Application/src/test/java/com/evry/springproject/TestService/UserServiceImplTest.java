package com.evry.springproject.TestService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.evry.springproject.Dao.UserDAO;
import com.evry.springproject.Domain.User;
import com.evry.springproject.Service.UserService;
import com.evry.springproject.Service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	UserService userService;

	@Mock
	UserDAO userDao;

	User user = new User();

	@Before
	public void init() {
		userService = new UserServiceImpl(userDao);
		user.setId(2);
		user.setEmail("arp@gmail.com");
		user.setMobile(9343323451L);
		user.setName("arp");
	}

	@Test
	public void getUserTest() {
		
		when(userDao.getUser(user.getId())).thenReturn(user);
		
		User user1 = userService.getUser(user.getId());
		assertEquals(this.user, user1);
	}

	@Test
	public void addUserTest() {

		User user1 = userService.addUser(user);
		
		assertThat("arp").isEqualTo(user1.getName());
		assertThat(9343323451L).isEqualTo(user1.getMobile());
		assertThat("arp@gmail.com").isEqualTo(user1.getEmail());
		assertThat(2).isEqualTo(user1.getId());

	}
	
	@Test
	public void deleteUserTest() {
		
		userService.deleteUser(user.getId());
		
		 assertThat(user, is(notNullValue()));
	
	}

	@Test
	public void updateUserTest() {
		
		user.setId(2);
		user.setEmail("arp1@gmail.com");
		user.setMobile(1343323451L);
		user.setName("arp1");
		
		User user1 = userService.updateUser(user);
		
		assertThat(user1.getName()).isEqualTo("arp1");
	}

}
