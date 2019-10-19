package com.example.demo02.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyBean implements CommandLineRunner {
    /**
     * 如果启动后需要运行一些特定的代码SpringApplication，则可以实现ApplicationRunner或CommandLineRunner接口。
     * 这两个接口以相同的方式工作，并提供一个单一的run方法，该方法在SpringApplication.run(…​)完成之前就被调用 。
     *
     * 所述CommandLineRunner接口提供访问的应用程序的参数作为一个简单的字符串数组，
     * 而ApplicationRunner使用了ApplicationArguments前面所讨论的接口。以下示例显示了一个CommandLineRunnerwith run方法：
     *
     *
     *
     * 如果几个CommandLineRunner或ApplicationRunner豆类中定义必须在一个特定的顺序被调用，
     * 您还可以实现 org.springframework.core.Ordered接口或使用 org.springframework.core.annotation.Order注解
     */
    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineRunner 程序运行");
    }
}
