package com.example.demo04cache.config;

import com.example.demo04cache.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {

    /**
     * 配置redis序列化器
     *
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {

        RedisTemplate<Object, Employee> redisTemplate = new RedisTemplate<Object, Employee>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> redisSerializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        redisTemplate.setDefaultSerializer(redisSerializer);
        return redisTemplate;

    }

}
