package com.majq.schat.test;

import com.majq.schat.utils.FontUtils;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/6
 */
public class FontUtilsTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.add(new Test());
            frame.setVisible(true);
        });
    }

    private static class Test extends JComponent {

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Font font = new Font("楷体", Font.BOLD, 16);
            g2.setFont(font);
            String message = "Hello world!";
            FontUtils.FontDescriptor descriptor = FontUtils.getFontDescription(message, g2, font);
            System.out.println(descriptor);
            g2.drawString(message, 30, 30);
        }
    }
}
