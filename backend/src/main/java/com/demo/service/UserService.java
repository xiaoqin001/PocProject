package com.demo.service;

import java.util.List;

import java.util.Optional;


import com.demo.model.User;

public interface UserService {


	public List<User> getAllUsers();
	public User getUserById(long id);
	public User saveUser(User user);
	public void removeUser(User user);
	public User updateUserById(User user, long id);
}