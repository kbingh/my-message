package com.bingham.mymessage.service;

import com.bingham.mymessage.model.Message;
import com.bingham.mymessage.model.User;
import com.bingham.mymessage.repository.MessageRepository;
import com.bingham.mymessage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Message>getMessageByUser(User user) {

        List<User> userList = new ArrayList<>();
        userList.add(user);

        return messageRepository.getMessageByReceiverList(userList);
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
