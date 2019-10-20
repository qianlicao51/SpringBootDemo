package com.example.demo02;

import com.example.demo02.task.TaskStart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo02Application {

    public static void main(String[] args) {
        //  ctrl+alt +v 返回变量名
        ApplicationContext context = SpringApplication.run(Demo02Application.class, args);
        context.getBean(TaskStart.class).initApp();

    }

}
