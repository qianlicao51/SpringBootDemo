package com.example.demo04cache;

import com.example.demo04cache.bean.Employee;
import com.example.demo04cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo04cacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;  //操作k-v都是字符串的

    @Autowired
    RedisTemplate redisTemplate;  //k-v都是对象的

    @Resource
    RedisTemplate<Object, Employee> empRedisTemplate;

    /**
     * string 测试 string list Set Hash Zset
     */
    @Test
    public void testRedis() {

        ValueOperations<String, String> strTmp = stringRedisTemplate.opsForValue();
        // redis中保存数据
        //  strTmp.append("msg", "hello");
        //  System.out.println(strTmp.get("msg"));
        ListOperations<String, String> opsForList = stringRedisTemplate.opsForList();
        //        opsForList.leftPush("mylist", "1");
        //  opsForList.leftPush("mylist", "2");

    }

    @Test
    public void contextLoads() {

        Employee employee = employeeMapper.getEmployee(1);
        System.out.println(employee);
        empRedisTemplate.opsForValue().set("emp", employee);


    }

}
