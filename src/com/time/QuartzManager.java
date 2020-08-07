package com.time;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzManager {
    /**
     * 添加一个定时任务
     *
     * @parm jobName：任务名
     * @parm jobGroupName：任务组
     * @parm triggerName：触发器名
     * @parm triggerGroupName：触发器组
     * @parm jobClass：任务
     * @parm cron：时间设置
     */

    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    public static void addjob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass, String cron) {
        try {
            //创建一个scheduler
            Scheduler sched = schedulerFactory.getScheduler();
            //创建一个JobDetail，指明name，groupname，以及具体的Job类名，该Job负责定义需要执行任务
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
            //创建触发器对象
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            //触发器相关参数设计
            triggerBuilder.withIdentity(triggerName, triggerGroupName);
            triggerBuilder.startNow();
            //触发器时间设定
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            //创建Trigger 对象
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();
            //调度容器设置JobDetail和Trigger，将他们两个关联起来。
            sched.scheduleJob(jobDetail, trigger);

            //启动
            if (!sched.isShutdown()) {
                sched.start();
            }

        } catch (Exception e) {

        }

    }

}

