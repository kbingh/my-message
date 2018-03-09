package com.stg.mymessage.controller;

import com.stg.mymessage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {


    @RequestMapping("/")
    public String index() {
        return "index";
    }


}