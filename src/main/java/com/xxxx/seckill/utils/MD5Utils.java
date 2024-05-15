package com.xxxx.seckill.utils;


import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {
    public static void main(String[] args) {
        System.out.println(inputPassToFromPass("123456"));
        System.out.println(fromPassToDBPass("ce21b747de5af71ab5c2e20ff0a60eea",salt));
        System.out.println(inputPassToDBPass("123456",salt));
    }
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }
    private static final String salt = "1a2b3c4d";      //进行加密的盐
    public static String inputPassToFromPass(String inputPass){
        String str=salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }
    public static String fromPassToDBPass(String formPass, String salt){
        String str=salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(5)+salt.charAt(4);
        return md5(salt);
    }

    public static String inputPassToDBPass(String inputPass,String salt){
        String fromPass=inputPassToFromPass(inputPass);
        return fromPassToDBPass(fromPass,salt);
    }
}
