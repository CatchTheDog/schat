package com.majq.schat.component;

import com.majq.schat.constant.FrameConstant;

import javax.swing.*;
import java.awt.*;

/**
 * 登录窗口
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/6 17:02
 */
public class LoginFrame extends JFrame {
    private static final int DEFAULT_WIDTH = FrameConstant.DEFAULT_WIDTH * 10 / 100;
    private static final int DEFAULT_HEIGHT = FrameConstant.DEFAULT_HEIGHT * 30 / 100;

    public LoginFrame() {
        this.setLayout(new BorderLayout());
        JPanel inputJpn = new JPanel();
        JLabel nameLabel = new JLabel("UserName", JLabel.CENTER);
        JTextField nameField = new JTextField();
        JLabel pwLabel = new JLabel("PW", JLabel.CENTER);
        JPasswordField pwField = new JPasswordField();

        inputJpn.setLayout(new GridLayout(2, 2));
        inputJpn.add(nameLabel);
        inputJpn.add(nameField);
        inputJpn.add(pwLabel);
        inputJpn.add(pwField);
        this.add(inputJpn, BorderLayout.CENTER);
        JPanel loginJpn = new JPanel();
        JButton loginButton = new JButton("登录");
        loginJpn.add(loginButton);
        this.add(loginJpn, BorderLayout.SOUTH);
        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            LoginFrame frame = new LoginFrame();
            frame.setTitle("登录");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
