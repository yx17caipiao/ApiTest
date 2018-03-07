package com.yxkj.yqcp.util; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */

//import com.jdd.fm.core.exception.FmCoreException;
//import com.jdd.fm.core.exception.ErrorCode;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;


/**
 *  加密工具
 *
 */
public class TransferAesEncrypt {

    private static final String AES_ALG         = "AES";

    /**
     * AES算法
     */
    private static final String AES_CBC_PCK_ALG = "AES/CBC/PKCS5Padding";

    //private static final byte[] AES_IV          = initIv(AES_CBC_PCK_ALG);

    /**
     *   加密
     *
     * @param content
     * @param encryptType
     * @param encryptKey
     * @param charset
     * @return
     * @throws Exception
     */
    public static String encryptContent(String content, String encryptType, String encryptKey, String charset) throws Exception {

        if (AES_ALG.equals(encryptType)) {

            return aesEncrypt(content, encryptKey, charset);

        }
        return null;

    }

    /**
     *  解密
     *
     * @param content
     * @param encryptType
     * @param encryptKey
     * @param charset
     * @return
     * @throws Exception
     */
    public static String decryptContent(String content, String encryptType, String encryptKey,
                                        String charset) throws Exception {

        if (AES_ALG.equals(encryptType)) {

            return aesDecrypt(content, encryptKey, charset);

        } else {
//            throw new FmCoreException(ErrorCode.AES_ENCRYPT_TYPE_NOT_SUPPORT_ERROR,ErrorCode.AES_ENCRYPT_TYPE_NOT_SUPPORT_ERROR.getMessage(encryptType));
        }
        return null;
    }

    /**
     * AES加密
     * 
     * @param content
     * @param aesKey
     * @param charset
     * @return
     * @throws Exception
     */
    public static String aesEncrypt(String content, String aesKey, String charset)throws Exception {


            Cipher cipher = Cipher.getInstance(AES_CBC_PCK_ALG);

            IvParameterSpec iv = new IvParameterSpec(initIv());
            cipher.init(Cipher.ENCRYPT_MODE,
                new SecretKeySpec(aesKey.getBytes(), AES_ALG), iv);

            byte[] encryptBytes = cipher.doFinal(content.getBytes(charset));
            return new String(Base64.encodeBase64(encryptBytes));


    }

    /**
     * AES解密
     * 
     * @param content
     * @param key
     * @param charset
     * @return
     * @throws Exception
     */
    public static String aesDecrypt(String content, String key, String charset)throws Exception {

            Cipher cipher = Cipher.getInstance(AES_CBC_PCK_ALG);
            IvParameterSpec iv = new IvParameterSpec(initIv());
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), AES_ALG), iv);
            byte[] cleanBytes = cipher.doFinal(Base64.decodeBase64(content.getBytes()));
            return new String(cleanBytes, charset);

    }

    /**
     * AES加密
     *
     * @param content
     * @param aesKey
     * @param charset
     * @return
     * @throws Exception
     */
    public static String aesEncrypt(String content, String aesKey, String charset,String ivStr)
            throws Exception {


            Cipher cipher = Cipher.getInstance(AES_CBC_PCK_ALG);

            IvParameterSpec iv = new IvParameterSpec(ivStr.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE,
                    new SecretKeySpec(aesKey.getBytes(), AES_ALG), iv);

            byte[] encryptBytes = cipher.doFinal(content.getBytes(charset));
            return new String(Base64.encodeBase64(encryptBytes));


    }

    /**
     * AES解密
     *
     * @param content
     * @param key
     * @param charset
     * @return
     * @throws Exception
     */
    public static String aesDecrypt(String content, String key, String charset,String ivStr) throws Exception {

            Cipher cipher = Cipher.getInstance(AES_CBC_PCK_ALG);
            IvParameterSpec iv = new IvParameterSpec(ivStr.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(),
                    AES_ALG), iv);

            byte[] cleanBytes = cipher.doFinal(Base64.decodeBase64(content.getBytes()));
            return new String(cleanBytes, charset);

    }

    /**
     * 初始向量的方法, 全部为0. 这里的写法适合于其它算法,针对AES算法的话,IV值一定是128位的(16字节).
     *
     * @return
     * @throws GeneralSecurityException
     */
    private static byte[] initIv() {
        String vi = "0000000000000000";
        try{
            String iv=PropertiesUtil.get("aes.iv");
//            if(org.apache.commons.lang.StringUtils.isNotBlank(iv)){
//                vi = iv;
//            }

            if(!iv.equals(null)&&!iv.equals("")){
                vi = iv;
            }
        }catch(Exception e){
        }

        return vi.getBytes();
    }

    private static byte[] initIv(String fullAlg) {

        try {
            Cipher cipher = Cipher.getInstance(fullAlg);
            int blockSize = cipher.getBlockSize();
            byte[] iv = new byte[blockSize];
            for (int i = 0; i < blockSize; ++i) {
                iv[i] = 0;
            }
            return iv;
        } catch (Exception e) {

            int blockSize = 16;
            byte[] iv = new byte[blockSize];
            for (int i = 0; i < blockSize; ++i) {
                iv[i] = 0;
            }
            return iv;
        }
    }

}
