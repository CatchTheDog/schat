package com.majq.schat.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/6 11:34
 */
public class DateUtils {
    /**
     * 根据指定格式格式化日期
     *
     * @param date      日期
     * @param formatStr 指定格式
     * @return 格式化后的日期
     */
    public static String format(Date date, String formatStr) {
        if (null != date && null != formatStr && formatStr.trim().length() > 0) {
            return new SimpleDateFormat(formatStr).format(date);
        } else throw new IllegalArgumentException("arguments error!");
    }
}
