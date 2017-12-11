package com.stg.mymessage.service;

import com.stg.mymessage.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> getAllMessages();
    List<Message> getIncomingMessagesByUserName(String toUserName);
    List<Message> getSentMessagesByUserName(String fromUserName);
    Message getMessageById(Integer messageId);
    Message sendMessage(Message message);
    void deleteMessage(Message message);
    void deleteAllMessages();
}
