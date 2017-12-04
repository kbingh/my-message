package com.stg.mymessage.service;


import com.stg.mymessage.domain.User;
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

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserServiceTest {


    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public UserServiceImpl userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserServiceImpl userService;

    User frodo = null;

    @Before
    public void setUp(){
        frodo = new User();
        frodo.setUserName("Ringbearer");
        frodo.setFirstName("Frodo");
        frodo.setLastName("Baggins");
        userService.createUser(frodo);
    }

    @Test
    public void findAllUsers() throws Exception {

        List<User> userList = userService.findAllUsers();
        assertThat(userList.get(0).getFirstName())
                .isEqualTo(frodo.getFirstName());
    }

    @Test
    public void findUserByName() throws Exception {
        User newUser = userService.findUserByName("Frodo");

        assertThat(newUser.getFirstName())
                .isEqualTo(frodo.getFirstName());
    }

    @After
    public void tearDown(){

        userService.deleteUser(frodo);
    }

}