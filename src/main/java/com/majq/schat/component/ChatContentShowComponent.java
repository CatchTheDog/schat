package com.majq.schat.component;

import javax.swing.*;
import java.awt.*;

/**
 * 聊天内容展示框
 * 用于展示历史聊天信息，追加展示即时提交的聊天信息
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/5 9:46
 */
public class ChatContentShowComponent extends JComponent {

    private int DEFAULT_X = 20;
    private int DEFAULT_Y = 20;

    public ChatContentShowComponent() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("楷体", Font.BOLD, 16));
        g2.setColor(Color.BLACK);
        g2.drawString("历史信息", DEFAULT_X, DEFAULT_Y);
    }

    /**
     * 追加显示历史信息
     *
     * @param message
     */
    public void appendContent(String message) {
        DEFAULT_Y += 20;
        Graphics2D g2 = (Graphics2D) this.getGraphics();
        g2.setFont(new Font("楷体", Font.BOLD, 16));
        g2.setColor(Color.BLACK);
        g2.drawString(message, DEFAULT_X, DEFAULT_Y);
    }
}
