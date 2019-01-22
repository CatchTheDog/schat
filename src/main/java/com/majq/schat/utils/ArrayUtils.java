package com.majq.schat.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 数组工具
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2019/01/22 16:02
 */
public class ArrayUtils {
    /**
     * 将Object转换为数组 因无法创建泛型数组，所以只能返回Object[]
     *
     * @param obj         数组对象
     * @param targetClass 目标类型
     * @param <T>         泛型参数
     * @return 转换后结果
     */
    public static <T> Object[] transObjToArray(Object obj, Class<T> targetClass) {
        if (null != obj && null != targetClass) {
            int len = Array.getLength(obj);
            List<T> arrayList = new ArrayList<>(len);
            for (int i = 0; i < len; i++) arrayList.add((T) Array.get(obj, i));
            return arrayList.toArray();
        } else
            throw new IllegalArgumentException("obj,targetClass can't be null!");
    }

    public static void main(String[] args) {
        byte[] bytes = {1, 2, 3, 4};
        Object[] arrays = transObjToArray(bytes, Byte.class);
        for (Object object : arrays) {
            byte s = (Byte) object;
            System.out.println(s);
        }
    }
}
