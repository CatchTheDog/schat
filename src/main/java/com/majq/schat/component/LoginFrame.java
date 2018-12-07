package com.majq.schat.component;

import com.majq.schat.constant.FrameConstant;
import com.majq.schat.utils.GBC;
import com.majq.schat.utils.ImageUtils;

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
    private static final int DEFAULT_X = FrameConstant.SCREEN_SIZE.width * 30 / 100;
    private static final int DEFAULT_Y = FrameConstant.SCREEN_SIZE.height * 20 / 100;
    private static final int DEFAULT_WIDTH = FrameConstant.SCREEN_SIZE.width * 40 / 100;
    private static final int DEFAULT_HEIGHT = FrameConstant.SCREEN_SIZE.height * 60 / 100;

    public LoginFrame() {
        this.setBackground(Color.WHITE);

        ImageIcon imageIcon = new ImageIcon(ImageUtils.loadImage("/image/qq.jpg"));
        JLabel jLabel = new JLabel(imageIcon);
        JLabel nameLabel = new JLabel("用户名", JLabel.CENTER);
        nameLabel.setFont(new Font("楷体", Font.PLAIN, 14));
        JTextField nameField = new JTextField();
        JLabel pwLabel = new JLabel("密码", JLabel.CENTER);
        pwLabel.setFont(new Font("楷体", Font.PLAIN, 14));
        JPasswordField pwField = new JPasswordField();
        JPanel loginJpn = new JPanel();
        JButton loginButton = new JButton("登录");
        loginJpn.add(loginButton);

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);

        gridBagLayout.setConstraints(jLabel, new GBC(0, 0, 10, 9).setFill(GBC.BOTH));
        gridBagLayout.setConstraints(nameLabel, new GBC(3, 10, 1, 2).setFill(GBC.BOTH));
        gridBagLayout.setConstraints(nameField, new GBC(4, 10, 2, 2).setFill(GBC.BOTH));
        gridBagLayout.setConstraints(pwLabel, new GBC(3, 12, 1, 2).setFill(GBC.BOTH));
        gridBagLayout.setConstraints(pwField, new GBC(4, 12, 2, 2).setFill(GBC.BOTH));
        gridBagLayout.setConstraints(loginJpn, new GBC(3, 14, 3, 2).setAnchor(GBC.CENTER));

        this.add(jLabel);
        this.add(nameLabel);
        this.add(nameField);
        this.add(pwLabel);
        this.add(pwField);
        this.add(loginJpn);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            LoginFrame frame = new LoginFrame();
            frame.setTitle("登录");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocation(DEFAULT_X, DEFAULT_Y);
            frame.setPreferredSize(new Dimension(435, 360));
            frame.pack();
            frame.setVisible(true);
        });
    }
}
