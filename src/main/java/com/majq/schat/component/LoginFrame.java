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

        JButton register = new JButton("注册");
        loginJpn.add(register);

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
                //销毁当前界面
                LoginFrame.this.dispose();
                EventQueue.invokeLater(() -> {
                    //创建新界面
                    MainFrame.loadMainFrame();
                });
                new Thread(new NetServer()).start(); //这里需要单独启用线程执行网络服务启动，如果不使用异步，则会阻塞UI加载
            } else {
                JOptionPane.showMessageDialog(LoginFrame.this, "您输入的用户名或者密码错误，请重新输入！", "用户名或者密码错误", 0);
            }
        }
    }

    /**
     * 点击注册按钮，跳转到注册界面
     */
    private class RegisterLister implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //弹出注册页面，用户注册完毕之后，需要再次登录
        }
    }
}
