package com.neeson.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by daile on 2017/8/21.
 */
@Slf4j
public class ApplicationJob implements Job {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        log.info("quartz:" + DATE_FORMAT.format(new Date()));

    }


}
