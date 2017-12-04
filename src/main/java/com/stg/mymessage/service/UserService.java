package com.stg.mymessage.service;

import com.stg.mymessage.domain.User;

import java.util.List;

public interface UserService {

	User getUserById(Long userId);
	List<User> findAllUsers();
	void createUser(User user);
	void deleteUser(User user);
	User findUserByName(String firstName);
}
