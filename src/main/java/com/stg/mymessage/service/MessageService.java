package com.stg.mymessage.service;

import com.stg.mymessage.model.Message;
import com.stg.mymessage.model.User;

import java.util.List;

public interface MessageService {

    List<Message> getAllMessages();
    Message getMessageById(Integer messageId);
    Message sendMessage(Message message);
    void deleteMessage(Message message);
    void deleteAllMessages();
    User createUser(String userName);
    void deleteUser(User user);
}
