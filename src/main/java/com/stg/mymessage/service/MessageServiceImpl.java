package com.stg.mymessage.service;

import com.stg.mymessage.model.Message;
import com.stg.mymessage.model.User;
import com.stg.mymessage.repository.MessageRepository;
import com.stg.mymessage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }




    @Override
    public Message getMessageById(Integer messageId) {
        return messageRepository.findOne(messageId);
    }

    @Override
    public Message sendMessage(Message message) {

        //userRepository.save(message.getUserList());
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
