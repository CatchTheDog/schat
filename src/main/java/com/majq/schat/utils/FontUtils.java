package com.majq.schat.utils;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 字体处理工具
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/6
 */
public class FontUtils {
    /**
     * 获取本机可用字体
     *
     * @return 本机可用字体列表
     */
    public static String[] getAvalibleFonts() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    }

    /**
     * 根据路径加载指定字体
     *
     * @param fontType 字体类型
     * @param path     字体所在路径
     * @return 加载完成的字体
     */
    public static Font loadFont(Integer fontType, String path) throws IOException, FontFormatException {
        if (null != path && path.trim().length() > 0) {
            URL url = new URL(path);
            InputStream in = url.openStream();
            return Font.createFont(null == fontType ? Font.TRUETYPE_FONT : fontType, in);
        } else {
            throw new IllegalArgumentException("path can't be null!");
        }
    }

    /**
     * 获取指定大小的字体
     *
     * @param fontType 字体类型
     * @param path     字体所在路径
     * @return 指定大小字体
     */
    public static Font getSpecificSizeFont(Integer fontType, String path, Integer size) throws IOException, FontFormatException {
        return loadFont(fontType, path).deriveFont(size);
    }

    /**
     * 根据字符串、画笔属性、字体获取字符串描述信息
     *
     * @param messasge 字符串
     * @param g2       画笔属性
     * @param font     字体
     * @return 字符串描述属性
     */
    public static FontDescriptor getFontDescription(String messasge, Graphics2D g2, Font font) {
        return new FontUtils.FontDescriptor(messasge, g2, font);
    }

    /**
     * 字体描述符
     */
    public static class FontDescriptor {
        private String messsage;//字符串
        private double width;//字符串宽度
        private double height;//字符串高度
        private double ascent;//上坡度
        private float descent;//下坡度
        private float leading;//行间距
        private Graphics2D g2;//画笔属性
        private Font font;//字体

        private FontDescriptor(String messsage, Graphics2D g2, Font font) {
            this.messsage = messsage;
            this.g2 = g2;
            this.font = font;

            this.g2.setFont(this.font);
            FontRenderContext context = g2.getFontRenderContext();
            Rectangle2D bounds = this.font.getStringBounds(this.messsage, context);

            this.width = bounds.getWidth();
            this.height = bounds.getHeight();
            this.ascent = -bounds.getY();

            LineMetrics metrics = this.font.getLineMetrics(this.messsage, context);
            this.descent = metrics.getDescent();
            this.leading = metrics.getLeading();
        }

        public String getMesssage() {
            return messsage;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }

        public double getAscent() {
            return ascent;
        }

        public float getDescent() {
            return descent;
        }

        public float getLeading() {
            return leading;
        }

        public Font getFont() {
            return font;
        }

        @Override
        public String toString() {
            return "FontDescriptor{" +
                    "messsage='" + messsage + '\'' +
                    ", width=" + width +
                    ", height=" + height +
                    ", ascent=" + ascent +
                    ", descent=" + descent +
                    ", leading=" + leading +
                    ", font=" + font +
                    '}';
        }
    }
}
