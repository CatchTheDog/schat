package com.majq.schat.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * @author Mr.X
 * @version 1.0.0
 * 构造URL并发送请求，获取URL指定的内容
 * @since 2019/01/17/09:39
 */
public class URLUtils {
    /**
     * 请求指定URL，获取响应结果
     *
     * @param url 待请求URL
     * @return 响应结果——默认为字符串
     */
    public static String requestURL(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        StringBuilder responseStr = new StringBuilder(0);
        try (Reader reader = new InputStreamReader(new BufferedInputStream(connection.getInputStream()))) {
            int len;
            char[] chars = new char[1024];
            while ((len = reader.read(chars, 0, 1024)) != -1) {
                responseStr.append(chars, 0, len);
            }
        }
        return responseStr.toString();
    }


    /**
     * 根据参数组装URL
     * 以 https://apis.map.qq.com/ws/district/v1/getchildren?key=PP3BZ-TQ3KU-AFYVX-B7D6Z-MDA32-CAB2V&sig=123444 为例
     *
     * @param requestHost https://apis.map.qq.com
     * @param requestPath /ws/district/v1/getchildren
     * @param params      URL query查询参数
     * @return 组装所得URL
     */
    public static String appendParam(String requestHost, String requestPath, TreeMap<String, String> params) {
        StringBuilder requestStr = new StringBuilder(requestHost).append(requestPath);
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (i == 0) {
                requestStr.append("?");
            } else {
                requestStr.append("&");
            }
            requestStr.append(entry.getKey()).append("=").append(entry.getValue());
            i++;
        }
        return requestStr.toString();
    }

    /**
     * 实现MD5加密
     *
     * @param text 待加密字符串
     * @return 加密后的字符串
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String md5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(text.getBytes(StandardCharsets.UTF_8));
        byte[] sectretBytes = md5.digest();
        String md5Str = new BigInteger(1, sectretBytes).toString(16);
        for (int i = 0; i < 32 - md5Str.length(); i++) {
            md5Str = "0" + md5Str;
        }
        return md5Str;
    }

    /**
     * 生成请求URL
     * 具体接口请求方式请参见： https://lbs.qq.com/webservice_v1/guide-region.html
     *
     * @param params 外部参数列表
     * @return 请求接口URL
     * @throws IOException
     */
    public static URL generateRequestURL(String requestHost, String requestPath, String sk, TreeMap<String, String> params) throws IOException, NoSuchAlgorithmException {
        String sigStr = appendParam("", requestPath, params).concat(sk);
        String sig = md5(sigStr);
        params.put("sig", sig);
        return new URL(appendParam(requestHost, requestPath, params));
    }

    /**
     * 获取系统配置项
     *
     * @param confDir      配置文件所在目录 相对根目录路径 默认为/conf
     * @param confFileName 配置文件名称 默认为config.properties
     * @return 加载完成后的配置文件对象Properties
     */
    public static Properties readConf(String confDir, String confFileName) throws IOException {
        Properties properties = new Properties();
        String confPath = (StringUtils.isBlank(confDir) ? "/conf" : confDir) + File.separator + (StringUtils.isBlank(confFileName) ? "config.properties" : confFileName);
        try (InputStream stream = URLUtils.class.getResource(confPath).openStream()) {
            properties.load(stream);
        }
        return properties;
    }
}
