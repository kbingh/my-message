package com.stg.mymessage.service;

import com.stg.mymessage.controller.MessageController;
import com.stg.mymessage.model.Message;
import com.stg.mymessage.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {

    @Autowired
    MessageService messageService;

    @Autowired
    MessageController messageController;

    private Message message;
    ResponseEntity<User> user;



    @Before
    public void setUp(){


    }

//    @Test
//    public void getAllMessages_Pass_returnMessageList(){
//
//        List<Message> messageList = messageService.getAllMessages();
//        Assert.assertNotNull(messageList);
//        assert(messageList.size() > 0);
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
//    @After
//    public void breakDown(){
//
//        messageService.deleteMessage(message);
//        messageService.deleteUser(user.getBody());
//    }
}
