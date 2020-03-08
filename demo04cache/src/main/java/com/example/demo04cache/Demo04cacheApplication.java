package com.example.demo04cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * cache 环境搭建
 * 整合mybatis操作数据库
 * 1 配置数据源信息
 * 2 使用注解版mybatis
 *  a 指定需要扫描的mapper所在接口
 *  而 使用缓存
 *      1 开启基于注解的缓冲
 *      2 标注缓冲注解即可
 */
@MapperScan("com.example.demo04cache.mapper")
@SpringBootApplication
@EnableCaching//缓存
public class Demo04cacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo04cacheApplication.class, args);
    }

}
