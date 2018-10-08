package com.stg.mymessage.service;

import com.stg.mymessage.model.Message;
import com.stg.mymessage.model.User;

import java.util.List;

public interface MessageService {

    List<Message> getAllMessages();
    List<Message> getMessageByUser(User user);
    Message sendMessage(Message message);
    User createUser(String userName);
    void deleteUser(List<User> userList);
    List<User> getAllUsers();
}
