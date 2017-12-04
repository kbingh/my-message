package com.stg.mymessage.service;

import com.stg.mymessage.domain.User;
import com.stg.mymessage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserRepository userRepository;

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

    public User findUserByName(String firstName){
        return userRepository.findUserByFirstName(firstName);
    }
}
