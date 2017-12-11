package com.stg.mymessage.service;

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
public class UserServiceTest {

    @Autowired
    UserService userService;

    User frodo;
    User bilbo;
    User gollum;

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {

        @Bean
        public UserServiceImpl userService() {
            return new UserServiceImpl();
        }
    }

    @Before
    public void setUp(){

        frodo = new User();
        frodo.setUserName("Frodo");

        userService.createUser(frodo);

        bilbo = new User();
        bilbo.setUserName("Bilbo");

        userService.createUser(bilbo);

        gollum = new User();
        gollum.setUserName("Gollum");

        userService.createUser(gollum);
    }

    @Test
    public void testGettingAllUsers_fail_showAllUsers(){

        List<User> userList = userService.getAllUsers();
        assert(!userList.contains(new User()));
    }

    @Test
    public void testGettingAllUsers_pass_showAllUsers(){

        List<User> userList = userService.getAllUsers();
        assert(userList.size() > 0);
        assert(userList.contains(frodo));
        assert(userList.contains(gollum));
    }

    @After
    public void tearDown(){
        userService.createUser(frodo);
        userService.createUser(bilbo);
        userService.createUser(gollum);
    }
}