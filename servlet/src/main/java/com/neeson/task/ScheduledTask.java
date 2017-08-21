package com.neeson.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by daile on 2017/8/19.
 */
@Component
@EnableAsync
@EnableScheduling
@Slf4j
public class ScheduledTask {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 50000)
    public void reportCurrentTime(){
        log.info("当前时间：" + DATE_FORMAT.format(new Date()));
    }
}
