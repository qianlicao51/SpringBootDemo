package com.example.demo02.task;

import com.example.demo02.conf.SysConfig;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * SpringBoot定时任务
 * https://www.jianshu.com/p/554a9c3df83c
 */
@Slf4j
@Component
public class ScheduleTask {
    @Scheduled(fixedDelay = 100000L)
    public void init() {
        log.info(new Date().toString());
    }

    @Scheduled(cron = "0 0 7 * * ?")
    public void pfDate() {
        log.info(new DateTime().toString(SysConfig.dateStr));
    }
}
