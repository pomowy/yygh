package com.time;

public class TestDemo {
    public static String JOB_NAME = "JOB_N";
    public static String TRIGGER_NAME = "TRIGGER_N";
    public static String JOB_GROUP_NAME = "JOB_GROUP_N";
    public static String TRIGGER_GROUP_NAME = "TRIGGER_GROUP_N";

    public static void main(String[] args) {

        try {
            System.out.println("start two timed tasks");
            // 周一到周五早上11：06：00秒执行DoingA和DoingB事件（这里每个两秒中打印一次是为了测试） 0/2 06 11 ? * MON-FRI
            QuartzManager.addjob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, MyJob.class, "0 * * * * ?");

        } catch (Exception e) {

        }
    }
}
