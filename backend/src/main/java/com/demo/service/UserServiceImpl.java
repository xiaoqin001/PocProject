package com.demo.service;



import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repository.UserRepository;
 
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;




	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
		
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		return userRepository.save(user);
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);
	}

	@Override
	public User updateUserById(User newUser, long id) {
		// TODO Auto-generated method stub
		User editUser = userRepository.findById(id).get();
		editUser.setEmail(newUser.getEmail());
		
		return userRepository.save(editUser);
		
	

	}






}