package com.stg.mymessage.controller;

import com.stg.mymessage.model.Message;
import com.stg.mymessage.model.User;
import com.stg.mymessage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @ModelAttribute("messages")
    public List<Message> messages() {
        return messageService.getAllMessages();
    }

    @RequestMapping(value="/sendMessage", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {


        Message newMessage = messageService.sendMessage(message);
        return new ResponseEntity<>(newMessage, HttpStatus.OK);
    }


}
