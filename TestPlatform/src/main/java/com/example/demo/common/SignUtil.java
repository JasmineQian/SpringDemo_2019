package com.example.demo.common;

import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;

public class SignUtil {

    public static String signTopRequest(Map<String, Object> params, String secret) throws Exception{

        // 第一步：检查参数是否已经排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        // 第二步：把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder();

        for (String key : keys) {
            String value = replaceNullStr(params.get(key));
            if (!StringUtils.isEmpty(key)&&!StringUtils.isEmpty(value)) {
                if("sign".equals(key)){
                    continue;
                }
                query.append(key).append(CONST.CONNECT_EQUAL).append(value).append(CONST.CONNECT_AND);
            }
        }
        String strtemp = null;
        if(query.length()>0){
            strtemp = query.substring(0, query.lastIndexOf(CONST.CONNECT_AND));
        }
        // 第三步：使用MD5加密
        byte[] bytes;
        strtemp = strtemp + secret;
        bytes = encryptMD5(strtemp);
        // 第四步：把二进制转化为大写的十六进制
        return byte2hex(bytes);
    }

    private static String replaceNullStr(Object str) {
        if(str == null){
            return "";
        }
        return str.toString();
    }


    /**
     * 加密
     * @param data
     * @return
     */
    private static byte[] encryptMD5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data.getBytes("UTF-8"));
        return md.digest();
    }

    /**
     *  二进制转化为大写的十六进制
     * @param bytes
     * @return
     */
    public static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }


}
