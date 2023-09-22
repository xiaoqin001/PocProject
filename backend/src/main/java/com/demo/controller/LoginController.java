package com.demo.controller;

import java.util.HashMap;




import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Response;
import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.config.JwtTokenUtil;
import com.demo.exception.UserException;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/login")
	public ResponseEntity<?> addUser(@RequestBody User user) throws UserException {

		
		User loginUser = userService.saveUser(user);
		
		System.out.println(loginUser);
		
		if (loginUser == null) {
			
			throw new UserException("Login failed!");
			
		}
		
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", loginUser.getId());
		claims.put("username", loginUser.getUsername());
		claims.put("password", loginUser.getPassword());
		String jwt = JwtTokenUtil.generateJWT(claims);
		
		return  ResponseEntity.ok(new Response(jwt));
//		return "index";
		
	}

}
