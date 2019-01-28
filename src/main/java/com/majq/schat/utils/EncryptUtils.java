package com.majq.schat.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具
 * MD5 16位 是取32位的第9到25位。
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2019/01/28 15:29
 */
public class EncryptUtils {
    /**
     * 使用指定算法(MD5,SHA1)获取内容的指纹(摘要)
     * 默认为32位大写摘要字符串
     *
     * @param bytes          待处理内容
     * @param algorithmsEnum 算法类型
     * @return 摘要
     */
    public static String encrypt(byte[] bytes, EncryptAlgorithms algorithmsEnum) throws NoSuchAlgorithmException {
        if (null == bytes || bytes.length == 0 || null == algorithmsEnum)
            throw new IllegalArgumentException("bytes,algorithmsEnum can't be null!");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithmsEnum.getName());
        messageDigest.update(bytes);
        byte[] hash = messageDigest.digest();
        StringBuffer buffer = new StringBuffer(0);
        for (int i = 0; i < hash.length; i++) {
            //byte 是八位2进制数，0xFF 11111111，与的结果是：对bytes[i],将高24位置0，低8位保持不变，保证二进制数据的一致性(补码一致)
            int v = hash[i] & 0xFF;
            if (v < 16) buffer.append("0");
            buffer.append(Integer.toHexString(v).toUpperCase());
        }
        return buffer.toString();
    }

    /**
     * 使用指定算法(MD5,SHA1)获取内容的指纹(摘要) 默认16位大写
     *
     * @param bytes          待处理内容
     * @param algorithmsEnum 算法类型
     * @return 摘要
     */
    public static String encrypt16(byte[] bytes, EncryptAlgorithms algorithmsEnum) throws NoSuchAlgorithmException {
        return encrypt(bytes, algorithmsEnum).substring(8, 24);
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String text = "你好啊，小老弟。";
        System.out.println(encrypt(text.getBytes(StandardCharsets.UTF_8), EncryptAlgorithms.SHA1));
    }

    public enum EncryptAlgorithms {
        MD5("MD5"), SHA1("SHA1");
        private String name;

        EncryptAlgorithms(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "EncryptAlgorithms{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
