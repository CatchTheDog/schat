package com.majq.schat;

import com.majq.schat.component.HeadPortraitComponent;
import com.majq.schat.component.MainFrameMenuBar;
import com.majq.schat.component.MainRightComponent;
import com.majq.schat.constant.FrameConstant;

import javax.swing.*;
import java.awt.*;

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
            CFrame cFrame = new CFrame();
        });
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
        this.add(HeadPortraitComponent.getHeadPortraitComponent(), BorderLayout.WEST);
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
        //this.setIconImage();
        this.setVisible(true);
        this.pack();
    }

    public MainRightComponent getMainRightComponent() {
        return mainRightComponent;
    }
}
