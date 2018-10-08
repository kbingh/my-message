package com.stg.mymessage.service;

import com.stg.mymessage.model.Message;
import com.stg.mymessage.model.User;
import com.stg.mymessage.repository.MessageRepository;
import com.stg.mymessage.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {


    @Mock
    MessageRepository messageRepository;

    @Autowired
    @InjectMocks
    MessageService messageService;

    private Message message;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(messageRepository);
    }

    @Test
    public void messageRepositorySave_MockRepository_returnMessage() {

        message = new Message();
        message.setMessage("This is a test.");
        message.setSubject("Message for you sir.");
        User sender = new User();
        sender.setUserId(55);
        sender.setUserName("Lancelot");

        List<User> receiverList = new ArrayList<>();
        User receiver = new User();
        receiver.setUserId(56);
        receiver.setUserName("Galahad");
        receiverList.add(receiver);
        message.setSender(sender);
        message.setReceiverList(receiverList);

        when(messageRepository.save(message)).thenReturn(message);

        message = messageService.sendMessage(message);

        Assert.assertNotNull(message);
        Assert.assertTrue(message.getMessage().contains("test"));

    }

    @Test
    public void messageRepositorySave_MockRepository_returnAllMessages() {

        message = new Message();
        message.setMessage("This is a test.");
        message.setSubject("Message for you sir.");
        User sender = new User();
        sender.setUserId(55);
        sender.setUserName("Lancelot");
        User receiver = new User();
        receiver.setUserId(56);
        receiver.setUserName("Galahad");
        List<User> receiverList = new ArrayList<>();
        receiverList.add(receiver);
        message.setSender(sender);
        message.setReceiverList(receiverList);

        Message message2 = new Message();
        message2.setMessage("This is a test.");
        message2.setSubject("Message for you sir.");
        User sender2 = new User();
        sender2.setUserId(57);
        sender2.setUserName("Gwain");
        User receiver2 = new User();
        receiver2.setUserId(58);
        receiver2.setUserName("Merlin");
        receiverList = new ArrayList<>();
        receiverList.add(receiver2);
        message.setSender(sender2);
        message.setReceiverList(receiverList);
        List<Message> messageList = new ArrayList<>();
        messageList.add(message);
        messageList.add(message);

        when(messageRepository.findAll()).thenReturn(messageList);

        messageList = messageService.getAllMessages();

        Assert.assertNotNull(messageList);
        Assert.assertTrue(!messageList.isEmpty());
        Assert.assertTrue(messageList.size() == 2);
    }
}
