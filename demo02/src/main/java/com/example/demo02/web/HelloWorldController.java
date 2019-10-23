package com.example.demo02.web;

import com.alibaba.fastjson.JSON;
import com.example.demo02.bean.Dic;
import com.example.demo02.dao.TestDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

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
        List<Dic> dic = testDao.getDic(id);
//        log.info("jdbctemplate 查询 {}", dic);
        return dic.get(0);
    }


    @RequestMapping(value = "/dics.do")
    public @ResponseBody
    Object queryDic() {
        log.info("查询开始{}", base);
        log.info("jdbctemplate 查询 {}");
        return "查询开始";
    }

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    public void foo() {
        RestTemplate client = restTemplateBuilder.build();
    }


    @Value(value = "${api.order}")
    String base;

    @GetMapping("/get/dic/{id}")
    @ResponseBody
    public Dic getDic(@PathVariable String id) {
        log.info("id:{}  | base {}", id, base);
        String uri = base + "/dic/{id}";
        RestTemplate client = restTemplateBuilder.build();
        Dic dicGet = client.getForObject(uri, Dic.class, id);


        /////////|获取返回的HTTP头相关信息，可以调用client.get |//////////////
        ResponseEntity<Dic> responseEntity = client.getForEntity(uri, Dic.class, id);
        Dic body = responseEntity.getBody();
        HttpHeaders headers = responseEntity.getHeaders();


        return dicGet;
    }
}
