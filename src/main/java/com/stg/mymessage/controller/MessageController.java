package com.stg.mymessage.controller;

import com.stg.mymessage.model.Message;
import com.stg.mymessage.model.User;
import com.stg.mymessage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value="/messages", method = RequestMethod.GET)
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @RequestMapping(value="/messages/{userId}", method = RequestMethod.GET,  produces="application/json")
    public ResponseEntity<List<Message>> getMessageByUserId(@PathVariable("userId") Integer userId) {
        List<Message> messageList = messageService.getMessageByUserId(userId);
        if(messageList != null){
            return new ResponseEntity<>(messageList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(messageList, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/users", method = RequestMethod.GET,  produces="application/json")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(messageService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public ResponseEntity<Message> update(@RequestBody Message message) {
       message =  messageService.sendMessage(message);
        if(message != null){
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/addUser/{userName}", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@PathVariable("userName") String userName) {


        User user = messageService.createUser(userName);

        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
        }
    }


}
