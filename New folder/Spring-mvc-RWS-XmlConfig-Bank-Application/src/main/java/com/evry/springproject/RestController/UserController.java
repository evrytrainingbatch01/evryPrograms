package com.evry.springproject.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evry.springproject.Domain.User;
import com.evry.springproject.ExceptionHandling.UserNotFoundException;
import com.evry.springproject.Service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {

		// this is adding customer method.here app is taking the object and passing it
		// to service.

		// user.setId(0);
		userService.addUser(user);

		return user;
	}

	@GetMapping("/users")
	public List<User> getUsers() {

		return userService.getUsers();

	}
	
	
	  @GetMapping("/searchUsersById/{userId}") 
	  public User getUser(@PathVariable Integer  userId) {
	  
	  User theUser = userService.getUser(userId);
	  
	  if (theUser == null) { throw new UserNotFoundException("User id not found - "
	  + userId); }
	  
	  return theUser; }
	 
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User theUser) {
		
		userService.updateUser(theUser);
		
		return theUser;
		
	}
	
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable Integer userId) {
		
		User tempUser = userService.getUser(userId);
		
		// throw exception if null
		
		if (tempUser == null) {
			throw new UserNotFoundException("User id not found - " + userId);
		}
				
		userService.deleteUser(userId);
		
		return "Deleted User id - " + userId;
	}
	
	
	
	  @GetMapping("/searchUsersByEmail/{email}") 
	  public List<User> getUserEmail(@PathVariable String email) {
	  
	  List<User> theUser = userService.getUserEmail(email);
	  
	  
	  return theUser; 
	  }
	 
	

}
