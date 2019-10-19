package com.example.demo02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Demo02Application {

    public static void main(String[] args) {
        //  ctrl+alt +v 返回变量名
        ConfigurableApplicationContext run = SpringApplication.run(Demo02Application.class, args);

    }

}
