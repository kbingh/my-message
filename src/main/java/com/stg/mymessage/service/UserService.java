package com.stg.mymessage.service;

import com.stg.mymessage.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Integer userId);
    User getUserByUserName(String userName);
    User createUser(User user);
    void deleteUser(User user);
    void deleteAllUsers();
}
