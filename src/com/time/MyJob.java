package com.time;

import com.wy.dept;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {
    private Dothings Doing;
    dept dept = new dept();

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        Doing.doA();
        Doing.doB();
        dept.remote();
    }
}
