package com.majq.schat;

import com.majq.schat.constant.FrameConstant;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mr.X
 * @version 1.0.0
 * 主窗口
 * @since 2018/12/4 17:09
 */
public class CFrame extends JFrame {
    /**
     * 窗口初始化
     */
    public CFrame() {
        initCFrame();
        addMenuBar();
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
     * 添加菜单栏
     */
    public void addMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("文件");
        JMenuItem jMenuItem = new JMenuItem("测试");
        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);
        this.setJMenuBar(jMenuBar);
    }

    /**
     * 测试类
     *
     * @param args
     */
    public static void main(String[] args) {
        startUp();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(FrameConstant.DEFAULT_WIDTH, FrameConstant.DEFAULT_HEIGHT);
    }

    public void initCFrame() {
        this.setTitle(FrameConstant.TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(FrameConstant.DEFAULT_LOCATION_X, FrameConstant.DEFAULT_LOCATION_Y);
        this.setVisible(true);
        this.pack();
    }

}
