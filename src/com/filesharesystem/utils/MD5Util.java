package com.filesharesystem.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;

public class MD5Util {
    private static String uuid = null;

    public static String getUUID(String keyName){
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            md5.update((keyName + DateUtil.getDatetime()).getBytes());
            String uuid = new BigInteger(1,md5.digest()).toString();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
//            todo record to log
            System.out.println(keyName + "UUID生成错误");
        }
        return uuid;
    }
}
