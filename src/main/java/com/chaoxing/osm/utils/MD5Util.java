package com.chaoxing.osm.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName MD5Util
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2019-06-06 13:28
 **/
@Slf4j
public class MD5Util {

    static boolean debug = false;

    public static String MD5(String str)  {
        String res =null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(str.getBytes("utf-8"));
            res = toHex(bytes);
        }catch (NoSuchAlgorithmException noException){
            log.error("/com.chaoxing/util/MD5Util.java:"+noException.getMessage());
        }catch (UnsupportedEncodingException unException){
            log.error("/com.chaoxing/util/MD5Util.java:"+unException.getMessage());
        }finally {

        }
        return res;
    }

    private static String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }


    public static String md5(String input) throws Exception {
        return byte2hex(md5(input.getBytes()));
    }

    // md5()信息摘要, 不可逆
    public static byte[] md5(byte[] input) throws Exception {
        MessageDigest alg = MessageDigest.getInstance("MD5"); // or "SHA-1"
        if (debug) {
            System.out.println("摘要前的二进串:" + byte2hex(input));
            System.out.println("摘要前的字符串:" + new String(input));
        }
        alg.update(input);
        byte[] digest = alg.digest();
        if (debug){
            System.out.println("摘要后的二进串:" + byte2hex(digest));
        }
        return digest;
    }

    // 字节码转换成16进制字符串
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1){
                hs = hs + "0" + stmp;
            } else{
                hs = hs + stmp;
                // if (n < b.length - 1)
                // hs = hs + ":";
            }
        }
        // System.out.println("hs="+hs);
        return hs.toUpperCase();
    }

    public static void main(String[] args) throws Exception {
        //5EA422EF28B79988EE640D4CF9E3286E
        //密码38C3350484E7431798AB8657C6B0A280
        //###9f488f7e3d23ae320b1693c18c078373
        String pwd = "chaoxing";
        String pwd2 = MD5Util.MD5(pwd);
        String pwd3 = md5(pwd);

        System.out.println(pwd2);
    }
}
