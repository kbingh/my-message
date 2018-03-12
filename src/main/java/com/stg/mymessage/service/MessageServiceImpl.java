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
    public List<Message> getMessageByUserId(Integer messageId) {

        User user = userRepository.findOne(messageId);

        return messageRepository.getMessageByReceiverList(user);
    }

    @Override
    public Message sendMessage(Message message) {

        return messageRepository.save(message);
    }

    @Override
    public User createUser(String userName) {
        User user = new User();
        user.setUserName(userName);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
