package com.time;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Dothings {

    public static void doA() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(new Date());
        System.out.println(date + "=========================" + "doing A");
    }


    public static void doB() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());
        System.out.println(date + "**************************" + "doing B");
    }
}
