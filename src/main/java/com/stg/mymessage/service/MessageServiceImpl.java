package com.stg.mymessage.service;

import com.stg.mymessage.model.Message;
import com.stg.mymessage.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getSentMessagesByUserName(String fromUserName) {
        return messageRepository.findByFromUserName(fromUserName);
    }

    @Override
    public List<Message> getIncomingMessagesByUserName(String toUserName) {
        return messageRepository.findByToUserName(toUserName);
    }

    @Override
    public Message getMessageById(Integer messageId) {
        return messageRepository.findOne(messageId);
    }

    @Override
    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteMessage(Message message) {
        messageRepository.delete(message);
    }

    @Override
    public void deleteAllMessages() {
        messageRepository.deleteAll();
    }
}
