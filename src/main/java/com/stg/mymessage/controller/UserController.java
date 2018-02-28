package com.stg.mymessage.controller;

import com.stg.mymessage.model.Message;
import com.stg.mymessage.model.User;
import com.stg.mymessage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> getUsers() {

        List<User> messageList = userService.getAllUsers();

        return new ResponseEntity<>(messageList, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@RequestParam("id") Integer id) {
        User user = userService.getUserById(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value="/addUser", method=RequestMethod.POST)
    public ResponseEntity<User> create(@RequestParam("userName") String userName) {
        User user = userService.createUser(userName);
        return ResponseEntity.accepted().body(user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public void deleteUser(@PathVariable User user) {
        userService.deleteUser(user);

    }

    @RequestMapping(value = "/deleteAllUsers", method = RequestMethod.POST)
    public void deleteUser() {
        userService.deleteAllUsers();
    }
}
