package com.neeson;

import com.neeson.quartz.ApplicationJob;
import com.neeson.quartz.AutowiringSpringBeanJobFactory;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

/**
 * Created by daile on 2017/8/21.
 */
@Configuration
@EnableScheduling
@EnableTransactionManagement
public class QuartzConfig {

    @Autowired
    @Qualifier(value = "cronJobTrigger")
    private Trigger cronJobTrigger;


    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext) {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory) throws IOException {

        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setOverwriteExistingJobs(true);
        factory.setJobFactory(jobFactory);
        //延迟加载
        factory.setStartupDelay(10);

        factory.setTriggers(cronJobTrigger);

        return factory;
    }

    @Bean
    public JobDetailFactoryBean sampleJobDetail() {
        return createJobDetail(ApplicationJob.class);
    }


    private static JobDetailFactoryBean createJobDetail(Class jobClass) {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(jobClass);
        factoryBean.setDurability(true);
        return factoryBean;
    }


    @Bean(name = "cronJobTrigger")
    public CronTriggerFactoryBean sampleJobTrigger(@Qualifier("sampleJobDetail") JobDetail jobDetail,
                                                   @Value("${samplejob.frequency}") long frequency) {
        return createTrigger(jobDetail, frequency);
    }


    private static CronTriggerFactoryBean createTrigger(JobDetail jobDetail, long pollFrequencyMs) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(0L);
        factoryBean.setCronExpression("0/5 * * * * ? ");
        return factoryBean;
    }

}
