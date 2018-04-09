package com.filesharesystem.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getDatetime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.getDatetime());
    }

}
