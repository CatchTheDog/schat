package com.majq.schat;

import com.majq.schat.component.HeadPortraitComponent;
import com.majq.schat.component.MainFrameMenuBar;
import com.majq.schat.component.MainRightComponent;
import com.majq.schat.constant.FrameConstant;
import com.majq.schat.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * 主窗口
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/4 17:09
 */
public class CFrame extends JFrame {
    private MainRightComponent mainRightComponent;

    /**
     * 窗口初始化
     */
    public CFrame() {
        initCFrame();
        addMenuBar();
        addComponent();
    }

    /**
     * 主窗口启动类，程序入口在此处
     */
    public static void startUp() {
        EventQueue.invokeLater(() -> {
            new CFrame();
            //setModel();
        });
    }

    /**
     * 切换观感
     */
    private static void setModel() {
        try {
            UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
            Arrays.stream(infos).forEach(x -> System.out.println(x.getClassName()));
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println("set frame model failed!");
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        startUp();
    }

    /**
     * 增加主窗口其他组件：聊天内容展示、聊天对象头像展示、聊天对象信息展示，聊天信息输入框、聊天信息发送按钮
     */
    private void addComponent() {
        this.setLayout(new BorderLayout());
        //聊天对象头像展示栏
        this.add(new HeadPortraitComponent(), BorderLayout.WEST);
        this.mainRightComponent = new MainRightComponent(this);
        this.add(mainRightComponent, BorderLayout.CENTER);
    }

    /**
     * 添加菜单栏
     */
    public void addMenuBar() {
        this.setJMenuBar(MainFrameMenuBar.getMenuBar());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(FrameConstant.DEFAULT_WIDTH, FrameConstant.DEFAULT_HEIGHT);
    }

    /**
     * 主窗口初始化
     */
    private void initCFrame() {
        this.setTitle(FrameConstant.TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(FrameConstant.DEFAULT_LOCATION_X, FrameConstant.DEFAULT_LOCATION_Y);
        this.setIconImage(ImageUtils.loadImage(FrameConstant.ICON_IMAGE_PATH));
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.pack();
        this.setVisible(true);
    }

    public MainRightComponent getMainRightComponent() {
        return mainRightComponent;
    }
}
