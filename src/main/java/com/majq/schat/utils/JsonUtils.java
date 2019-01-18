package com.majq.schat.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @author Mr.X
 * @version 1.0.0
 * 使用JacksonCore构建JSON工具
 * @since 2019/01/18 15:41
 */
public class JsonUtils {
    /**
     * 解析JSON字符串为对象
     *
     * @param jsonStr
     */
    public static <T> T parseObject(String jsonStr, Class<T> t) throws IOException {
        if (StringUtils.isBlank(jsonStr)) throw new IllegalArgumentException("jsonStr can't be null!");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonStr, t);
    }
}
