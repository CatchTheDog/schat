package com.majq.schat.utils;

import java.lang.reflect.Array;

/**
 * 数组工具
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2019/01/22 16:02
 */
public class ArrayUtils {
    /**
     * 将Object转换为数组,在获取到转换结果后强制转型即可使用
     *
     * @param obj 数组对象
     * @return 转换后结果
     */
    public static Object transObjToArray(Object obj) {
        if (null != obj) {
            Class arrayClass = obj.getClass();
            if (!arrayClass.isArray()) return null;
            Class componentType = arrayClass.getComponentType();
            int len = Array.getLength(obj);
            Object newArray = Array.newInstance(componentType, len);
            for (int i = 0; i < len; i++) {
                Array.set(newArray, i, Array.get(obj, i));
            }
            return newArray;

        } else
            throw new IllegalArgumentException("obj,targetClass can't be null!");
    }

    /**
     * 通用数组复制方法，获得新数组后，使用强制转型即可使用
     *
     * @param array     原数组
     * @param newLength 新数组长度
     * @return 复制完成后数组
     */
    public static Object arrayCopy(Object array, int newLength) {
        Class arrayClass = array.getClass();
        if (!arrayClass.isArray()) return null;
        Class componentType = arrayClass.getComponentType();
        int len = Array.getLength(array);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(array, 0, newArray, 0, Math.min(len, newLength));
        return newArray;
    }

    public static void main(String[] args) {
        byte[] bytes = {1, 2, 3, 4};
        byte[] arrays = (byte[]) transObjToArray(bytes);
        for (byte x : arrays) System.out.println(x);
    }
}
