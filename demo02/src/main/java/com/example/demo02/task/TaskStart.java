package com.example.demo02.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Component
@Slf4j
public class TaskStart {
    //Bean容器初始化后，会调用@PostConstruct的注解方法
    @PostConstruct
    public void init() throws IOException {
        log.info("程序启动 初始化工作开始");
    }

    @PreDestroy
    public void cleanUp() {
        log.info("程序销毁之前调用");
    }


}
