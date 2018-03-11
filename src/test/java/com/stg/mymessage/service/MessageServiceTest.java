package com.stg.mymessage.service;

import com.stg.mymessage.model.Message;
import com.stg.mymessage.repository.MessageRepository;
import com.stg.mymessage.repository.UserRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)


public class MessageServiceTest {


    @Mock
    MessageRepository messageRepository;

    @Mock
    UserRepository userRepository;

    @Autowired
    @InjectMocks
    MessageService messageService;

    private Message message;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(messageRepository);
        MockitoAnnotations.initMocks(userRepository);
    }

//    @Test
//    public void messageRepositorySave_MockRepository_returnMessage() {
//
//        message = new Message();
//        message.setMessage("This is a test.");
//        message.setSubject("Message for you sir.");
//        User sender = new User();
//        sender.setUserId(55);
//        sender.setUserName("Lancelot");
//        User receiver = new User();
//        receiver.setUserId(56);
//        receiver.setUserName("Galahad");
//        message.getUserList().add(sender);
//        message.getUserList().add(receiver);
//
//        when(userRepository.save(message.getUserList())).thenReturn(message.getUserList());
//        when(messageRepository.save(message)).thenReturn(message);
//
//        message = messageService.sendMessage(message);
//
//        Assert.assertNotNull(message);
//        Assert.assertTrue(message.getMessage().contains("test"));
//
//    }

//    @Test
//    public void messageRepositorySave_MockRepository_returnAllMessages() {
//
//        message = new Message();
//        message.setMessage("This is a test.");
//        message.setSubject("Message for you sir.");
//        User sender = new User();
//        sender.setUserId(55);
//        sender.setUserName("Lancelot");
//        User receiver = new User();
//        receiver.setUserId(56);
//        receiver.setUserName("Galahad");
//        message.getUserList().add(sender);
//        message.getUserList().add(receiver);
//
//        Message message2 = new Message();
//        message2.setMessage("This is a test.");
//        message2.setSubject("Message for you sir.");
//        User sender2 = new User();
//        sender2.setUserId(57);
//        sender2.setUserName("Gwain");
//        User receiver2 = new User();
//        receiver2.setUserId(58);
//        receiver2.setUserName("Merlin");
//        message.getUserList().add(sender2);
//        message.getUserList().add(receiver2);
//        List<Message> messageList = new ArrayList<>();
//        messageList.add(message);
//        messageList.add(message);
//
//
//        when(messageRepository.findAll()).thenReturn(messageList);
//
//        messageList = messageService.getAllMessages();
//
//        Assert.assertNotNull(messageList);
//        Assert.assertTrue(!messageList.isEmpty());
//        Assert.assertTrue(messageList.size() == 2);
//        Assert.assertTrue(messageList.get(0).getUserList().size() == 4);
//
//    }
//
//    @Test
//    public void messageControllerCreateUser_Pass_returnStatusCodeOK(){
//
//        user = messageController.createUser("TestUser");
//        Assert.assertNotNull(user);
//        assert(user.getStatusCode().equals(HttpStatus.OK));
//
//    }
//

}
