package com.majq.schat.component;

import com.majq.schat.constant.FrameConstant;
import com.majq.schat.netservice.NetServer;
import com.majq.schat.utils.GBC;
import com.majq.schat.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 登录窗口
 * 需要为添加到网格中的组件设置ipad，否则组件为默认大小，无法伸展
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/6 17:02
 */
public class LoginFrame extends JFrame {
    private static final int DEFAULT_X = FrameConstant.SCREEN_SIZE.width * 30 / 100;
    private static final int DEFAULT_Y = FrameConstant.SCREEN_SIZE.height * 20 / 100;
    private static final int DEFAULT_WIDTH = FrameConstant.SCREEN_SIZE.width * 40 / 100;
    private static final int DEFAULT_HEIGHT = FrameConstant.SCREEN_SIZE.height * 60 / 100;

    private JTextField userNameField;
    private JPasswordField pwField;

    public LoginFrame() {
        this.setBackground(Color.WHITE);

        ImageIcon imageIcon = new ImageIcon(ImageUtils.loadImage("/image/qq.jpg"));
        JLabel jLabel = new JLabel(imageIcon);
        JLabel nameLabel = new JLabel("用户名", JLabel.CENTER);
        nameLabel.setFont(new Font("楷体", Font.PLAIN, 14));
        userNameField = new JTextField();
        JLabel pwLabel = new JLabel("密码", JLabel.CENTER);
        pwLabel.setFont(new Font("楷体", Font.PLAIN, 14));
        pwField = new JPasswordField();
        JPanel loginJpn = new JPanel();
        JButton loginButton = new JButton("登录");
        loginJpn.add(loginButton);
        loginButton.addActionListener(new SubmitListener());

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);

        //gridBagLayout.setConstraints(jLabel, new GBC(0, 0, 10, 9).setFill(GBC.BOTH));
        gridBagLayout.setConstraints(nameLabel, new GBC(3, 10, 1, 2).setFill(GBC.HORIZONTAL).setIpad(20, 0).setInsets(0, 2, 2, 0));
        gridBagLayout.setConstraints(userNameField, new GBC(4, 10, 2, 2).setFill(GBC.HORIZONTAL).setIpad(100, 0).setInsets(0, 2, 2, 0));
        gridBagLayout.setConstraints(pwLabel, new GBC(3, 12, 1, 2).setFill(GBC.HORIZONTAL).setIpad(20, 0).setInsets(0, 2, 2, 0));
        gridBagLayout.setConstraints(pwField, new GBC(4, 12, 2, 2).setFill(GBC.HORIZONTAL).setIpad(100, 0).setInsets(0, 2, 2, 0));
        gridBagLayout.setConstraints(loginJpn, new GBC(3, 14, 3, 2).setFill(GBC.BOTH).setAnchor(GBC.CENTER));

        //this.add(jLabel);
        this.add(nameLabel);
        this.add(userNameField);
        this.add(pwLabel);
        this.add(pwField);
        this.add(loginJpn);

        this.setTitle("登录");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(DEFAULT_X, DEFAULT_Y);
        this.setPreferredSize(new Dimension(435, 360));
        this.pack();
        this.setVisible(true);
    }

    /**
     * 点击的登录按钮，对身份进行校验
     */
    private class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userName = userNameField.getText();
            char[] password = pwField.getPassword();
            if (userName.equals("Mr.x") && new String(password).equals("123456")) {
                //创建新界面
                MainFrame.loadMainFrame();
                NetServer.startServer();
                //销毁当前界面
                LoginFrame.this.dispose();
            }
        }
    }
}
