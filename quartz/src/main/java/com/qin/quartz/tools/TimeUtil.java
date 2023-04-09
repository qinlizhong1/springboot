package com.qin.quartz.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String formatDate(Date date){
        return sdf.format(date);
    }
}
