package com.example.demo02.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class HelloWorldController {

    @RequestMapping(value = "/say.do")
    @ResponseBody
    public String say() {
        return "hello SpringBoot 学习";
    }
}
