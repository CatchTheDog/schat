package com.majq.schat.selfcomponent;

import javax.swing.*;
import java.awt.*;

public class TextFrame extends JFrame {
    public TextFrame() {
        this.setTitle("test");
        JPanel jPanel = new JPanel();
        String[] excludeStrs = {"哈"};
        jPanel.add(new TextFeildComponent("请输入...", 10, excludeStrs, 10));
        this.add(jPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new TextFrame();
        });
    }
}
