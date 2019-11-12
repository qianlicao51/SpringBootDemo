package com.example.demo02.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class HelloJspController {

    @RequestMapping("/jps/hello")
    public String jsp() {

        return "hello";
    }


}
