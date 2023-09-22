package com.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.UserException;
import com.demo.model.User;
import com.demo.service.UserService;


@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
//	public ResponseEntity<List<User>> getAllUsers() {
		System.out.println("getting request");
		
//		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);	
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) throws UserException {
		
		User user = userService.getUserById(id);
    	if (user == null || user.getId() <= 0){
            throw new UserException("User doesn´t exist");
    	}
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);	
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable("id") int id) throws UserException {
		User user = userService.getUserById(id);
		if(user==null || user.getId()<=0) {
			throw new UserException("User to delete doesn´t exist");
		}
		userService.removeUser(user);

		return "Deleted successfully";
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateTodo(@RequestBody User user, @PathVariable("id") int id) throws UserException {
		
//		User userToDelelte = userService.getUserById(id);
//		userService.removeUser(userToDelelte);
		
		return new ResponseEntity<User>(userService.updateUserById(user, id), HttpStatus.OK);
	}
	
//	@PostMapping("/user")
//	public ResponseEntity<User> addUser(@RequestBody User user) {
//		System.out.println(user);
//		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
//	}

}
