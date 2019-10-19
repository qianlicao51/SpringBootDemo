package com.example.demo02.web.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserReditRestController {
    /**
     * text/html; charset=UTF-8 解决IE下载提示
     *
     * @param uid
     * @return
     */
    @RequestMapping(value = "/usercredit/{uid}", produces = "text/html; charset=UTF-8")
    public Integer getCreditLevel(@PathVariable String uid) {
        log.info("usercredit id is {}", uid);
        return 3;
    }

}
