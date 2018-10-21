package com.bingham.mymessage.service;

import com.bingham.mymessage.model.Message;
import com.bingham.mymessage.model.User;

import java.util.List;

public interface MessageService {

    List<Message> getAllMessages();
    List<Message> getMessageByUser(User user);
    Message sendMessage(Message message);
    User createUser(String userName);
    List<User> getAllUsers();
}
