package com.example.demo02.web;

import com.alibaba.fastjson.JSON;
import com.example.demo02.bean.Dic;
import com.example.demo02.dao.TestDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.List;

@Slf4j
@Controller
public class HelloWorldController {


    @Autowired
    JdbcTemplate jdbcTemplate;


    @RequestMapping(value = "/say.do")
    @ResponseBody
    public String say() {
        List<Dic> query = null;
        int i = 0;
        //        在idea中添加try/catch的快捷键
        //        ctrl+alt+t
        try {
            i = 3 / 1;
            query = jdbcTemplate.query("select * from ym_fam", new BeanPropertyRowMapper(Dic.class));
        } catch (Exception e) {
            log.info("除数不能为0", e);
        }
        return "hello SpringBoot 学习" + JSON.toJSONString(query);
    }

    @Autowired
    TestDao testDao;

    @RequestMapping(value = "/dic/{id}")
    public @ResponseBody
    Object queryDic1(@PathVariable String id) {
        log.info("查询开始");
//        List<Dic> dic = testDao.getDic(id);
//        log.info("jdbctemplate 查询 {}", dic);
        return "查询开始";
    }

    @RequestMapping(value = "/dics.do")
    public @ResponseBody
    Object queryDic() {
        log.info("查询开始");

        log.info("jdbctemplate 查询 {}");
        return "查询开始";
    }

    public static void main(String[] args) throws NoSuchMethodException {


        Method say = HelloWorldController.class.getDeclaredMethod("queryDic");

        System.out.println(say);


    }
}
