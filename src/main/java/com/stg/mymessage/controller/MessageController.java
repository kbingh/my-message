package com.stg.mymessage.controller;

import com.stg.mymessage.model.Message;
import com.stg.mymessage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public ResponseEntity<Collection<Message>> getMessages() {

        List<Message> messageList = messageService.getAllMessages();

        return new ResponseEntity<>(messageList, HttpStatus.OK);
    }

    @RequestMapping(value = "/incomingMessages", method = RequestMethod.GET)
    public ResponseEntity<Collection<Message>> getIncomingMessagesByUserName(@RequestParam("userName") String userName) {

        List<Message> messageList = messageService.getIncomingMessagesByUserName(userName);

        return new ResponseEntity<>(messageList, HttpStatus.OK);
    }

    @RequestMapping(value = "/sentMessages", method = RequestMethod.GET)
    public  ResponseEntity<Collection<Message>> getSentMessagesByUserName(@RequestParam("userName") String userName) {

        List<Message> messageList = messageService.getSentMessagesByUserName(userName);

        return new ResponseEntity<>(messageList, HttpStatus.OK);
    }

    @RequestMapping(value = "/sentMessage", method = RequestMethod.GET)
    public ResponseEntity<Message> getSentMessageById(@RequestParam("id") Integer id) {

        Message message = messageService.getMessageById(id);

        if (message != null) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="sendMessage", method = RequestMethod.POST)
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        Message newMessage = messageService.sendMessage(message);
        return new ResponseEntity<>(newMessage, HttpStatus.CREATED);
    }

    @RequestMapping(value="deleteMessage", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMessage(@PathVariable Message message) {

        messageService.deleteMessage(message);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}