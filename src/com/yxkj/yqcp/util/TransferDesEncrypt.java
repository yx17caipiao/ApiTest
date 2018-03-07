package com.yxkj.yqcp.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 对称加密算法
 * 
 * @version 1.0
 * @author chenlongfei
 * 
 */
public abstract class TransferDesEncrypt {
    private static final String DEF_KEY = "D7f3y1Ef@U46Q2u8^Fy2M";
    public static final char SPLIT = '|';
    private static final String REG_SPLIT = "\\|";
    private static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
    /**
     * 加密
     * 
     * @param str
     * @param key
     * @return
     */
    public static String encrypt(String str, String key) {
        StringBuilder sb = new StringBuilder();
        int ch;
        if (!"".equals(str)) {
            int j = 0;
            for (int i = 0; i < str.length(); i++) {
                if (j > (key.length() - 1)) {
                    j = j % key.length();
                }
                ch = (int) str.charAt(i) + (int) key.charAt(j);
                if (ch > 65535) {
                    ch = ch % 65535;
                }
                sb.append((char) ch);
                j++;
            }
        }
        return sb.toString();
    }

    /**
     * 解密
     * 
     * @param str
     * @param key
     * @return
     */
    public static String decrypt(String str, String key) {
        StringBuilder sb = new StringBuilder();
        int ch;
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (j > (key.length() - 1)) {
                j = j % key.length();
            }
            ch = ((int) str.charAt(i) + 65535 - (int) key.charAt(j));
            if (ch > 65535) {
                ch = ch % 65535;
            }
            sb.append((char) ch);
            j++;
        }
        return sb.toString();
    }

    /**
     * 加密
     * 
     * @param str
     * @return
     */
    public static String encryptDef(String str) {
    	//return str;
           return encrypt(str, DEF_KEY);
    }

    /**
     * 解密
     * 
     * @param str
     * @return
     */
    public static String decryptDef(String str) {
       return decrypt(str, DEF_KEY);
       // return str;
    }

    /**
     * 解密并分割转字符串数组
     * 
     * @param str
     * @return
     */
    public static String[] decryptDefAndSplit(String str) {
        return decrypt(str, DEF_KEY).split(REG_SPLIT, -1);
    }


    /**
     * DES算法，加密
     *
     * @param data 待加密字符串
     * @param key  加密私钥，长度不能够小于8位
     * @return 加密后的字节数组，一般结合Base64编码使用
     * @throws Exception
     */
    public static String encrypt(String key,String data,String ivStr) throws Exception {
        if(data == null)
            return null;
        Cipher e = Cipher.getInstance(ALGORITHM_DES);
        IvParameterSpec iv = new IvParameterSpec(ivStr.getBytes());
        e.init(1, new SecretKeySpec(key.getBytes(), "DES"), iv);
        byte[] encryptBytes = e.doFinal(data.getBytes());
        return new String(Base64.encodeBase64(encryptBytes));
    }

    /**
     * DES算法，解密
     *
     * @param data 待解密字符串
     * @param key  解密私钥，长度不能够小于8位
     * @return 解密后的字节数组
     * @throws Exception 异常
     */
    public static String decrypt(String key,String data,String ivStr) throws Exception {
        if(data == null)
            return null;
        Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
        IvParameterSpec iv = new IvParameterSpec(ivStr.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(),
                "DES"), iv);

        byte[] cleanBytes = cipher.doFinal(Base64.decodeBase64(data.getBytes()));
        return new String(cleanBytes, "utf-8");
    }

    /**
     * 二行制转字符串
     * @param b
     * @return
     */
    private static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }

    private static byte[] hex2byte(byte[] b) {
        if((b.length%2)!=0)
            throw new IllegalArgumentException();
        byte[] b2 = new byte[b.length/2];
        for (int n = 0; n < b.length; n+=2) {
            String item = new String(b,n,2);
            b2[n/2] = (byte)Integer.parseInt(item,16);
        }
        return b2;
    }
}
