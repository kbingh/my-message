package com.stg.mymessage.service;

import com.stg.mymessage.model.Message;
import com.stg.mymessage.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MessageServiceTest {

    @Autowired
    MessageService messageService;

    private Message message;

    @TestConfiguration
    static class MessageServiceImplTestContextConfiguration {

        @Bean
        public MessageServiceImpl messageService() {
            return new MessageServiceImpl();
        }
    }

    @Before
    public void setUp(){


    }

    @Test
    public void testMessages_pass_getAllMessages(){

        List<Message> messageList = messageService.getAllMessages();
        assert(messageList.size() > 0);
        assert(messageList.contains(message));
    }

    @After
    public void breakDown(){

        messageService.deleteMessage(message);
    }
}
