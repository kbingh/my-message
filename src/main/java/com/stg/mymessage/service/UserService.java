package com.stg.mymessage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.mymessage.domain.User;
import com.stg.mymessage.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User getUserById(Long userId) {
		return userRepository.findOne(userId);
	}
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	public void createUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
}
