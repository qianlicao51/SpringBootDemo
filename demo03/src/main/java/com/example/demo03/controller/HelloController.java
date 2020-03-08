package com.example.demo03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/jhel")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
