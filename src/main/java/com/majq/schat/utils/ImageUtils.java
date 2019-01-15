package com.majq.schat.utils;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 图片操作工具类
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/5 14:18
 */
public class ImageUtils {

    /**
     * 根据指定的路径加载图片
     *
     * @param path 图片存储路径
     * @return 加载后的图片
     */
    public static Image loadImage(String path) {
        if (null != path && path.trim().length() > 0) {
            URL url = ImageUtils.class.getResource(path);//获取classes文件夹下的指定路径
            return new ImageIcon(url).getImage();
        }
        return null;
    }
}
