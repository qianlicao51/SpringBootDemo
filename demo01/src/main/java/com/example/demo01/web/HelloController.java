package com.example.demo01.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
@Scope
public class HelloController {

    @RequestMapping("/login")
    public String login() {
        log.info("登录界面");
        return "redirect:/login.html";
    }
}
