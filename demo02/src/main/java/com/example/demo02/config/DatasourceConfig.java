package com.example.demo02.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
    //|Environment在springboot中代表了环境上下文，包含了spplication.properties配置属性、JVM系统属性、操作系统环境变量
    @Autowired
    private Environment environment;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        return dataSource;

    }
}
