package com.stg.mymessage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/newUser")
    public String newUser() {
        return "newUser";
    }

    @RequestMapping("/newMessage")
    public String newMessage() {
        return "newMessage";
    }





}