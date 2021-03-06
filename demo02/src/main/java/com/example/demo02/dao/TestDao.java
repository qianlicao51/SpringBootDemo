package com.example.demo02.dao;

import com.example.demo02.bean.Dic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class TestDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Dic> getDic(String id) {
        log.info("jdbcTemplate 参数{}", id);
        List<Dic> dics = jdbcTemplate.query(" SELECT * FROM ym_dic where id =?", new String[]{id}, new BeanPropertyRowMapper(Dic.class));
        log.info("", dics);
        return dics;
    }

}
