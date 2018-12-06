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
    //private static final int DEFAULT_WIDTH = FrameConstant.DEFAULT_WIDTH * 60 / 100;
    //private static final int DEFAULT_HEIGHT = FrameConstant.DEFAULT_HEIGHT * 80 / 100;
    private JTextArea jTextArea;

    public ChatContentShowComponent() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "聊天信息"));
        this.jTextArea = new JTextArea();
        this.jTextArea.setFont(new Font("楷体", Font.PLAIN, 14));
        this.jTextArea.setForeground(Color.BLACK);
        this.jTextArea.setSelectedTextColor(Color.BLUE);
        this.jTextArea.setLineWrap(true);
        this.jTextArea.setEditable(false);
        //this.jTextArea.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT)); //不设置首选项，让其自动填充，否则会出现大小溢出
        this.add(new JScrollPane(this.jTextArea), BorderLayout.CENTER);
    }

    /**
     * 追加显示历史信息
     *
     * @param message
     */
    public void appendContent(String message) {
        this.jTextArea.append("\n" + message);
        this.repaint();
    }

}
