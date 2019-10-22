package com.example.demo02;

import com.alibaba.fastjson.JSON;
import com.example.demo02.bean.DbType;
import com.example.demo02.bean.Dic;
import com.example.demo02.service.DicService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

//@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
class Demo02ApplicationTests {

    @Autowired
    DataSourceProperties dataSourceProperties;
    @Autowired
    ApplicationContext applicationContext;


    @Test
    void contextLoads() {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        // 查看配置数据源信息
        log.info("dataSource:{}", dataSource);
        log.info("dataSource Name:{}", dataSource.getClass().getName());
        System.out.println(dataSourceProperties);
        //执行SQL,输出查到的数据
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<?> resultList = jdbcTemplate.queryForList("SELECT ID FROM ym_dic WHERE id=1");
        System.out.println("===>>>>>>>>>>>" + JSON.toJSONString(resultList));
        String sql = "SELECT t.`COLUMN_NAME` AS NAME ,t.`COLUMN_COMMENT` AS COMMENT FROM INFORMATION_SCHEMA.Columns t WHERE table_name='ym_fam'";
        List<DbType> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper(DbType.class));

        for (DbType dbType : query) {
            System.out.println(dbType);
        }

        //查询封装实体类
        List<Dic> query1 = jdbcTemplate.query("SELECT * FROM ym_dic where id =?", new String[]{"1"}, new BeanPropertyRowMapper(Dic.class));
        System.out.println(query1);
    }

    @Autowired
    DicService dicS;

    @Test
    public void addDic() {
        Dic dic = new Dic();
        dic.setDicname("测试");
        dic.setDiccode("12");
        dic.setDicitemcode("1212");
        dic.setDicitemname("测试A");

        dicS.addDic(dic);
    }
}
