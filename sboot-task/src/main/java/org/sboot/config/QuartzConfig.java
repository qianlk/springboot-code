package org.sboot.config;

import org.quartz.*;
import org.sboot.quartz.MyQuartz;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qlk
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printJobDetail() {
        // 绑定具体的工作内容 MyQuartz
        return JobBuilder.newJob(MyQuartz.class)
                // 持久化该工作内容,不使用是保存
                .storeDurably().build();
    }

    @Bean
    public Trigger printJobTrigger() {
        // 绑定对应的工作明细
        ScheduleBuilder<CronTrigger> scheduleBuilder = CronScheduleBuilder
                // 规定定时任务间隔
                .cronSchedule("0/5 * * * * ?");

        return TriggerBuilder.newTrigger()
                // 指定工作内容 #printJobDetail
                .forJob(printJobDetail())
                // 指定时间间隔
                .withSchedule(scheduleBuilder).build();
    }
}
