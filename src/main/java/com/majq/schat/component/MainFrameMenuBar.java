package com.majq.schat.component;

import javax.swing.*;
import java.awt.*;

/**
 * 菜单栏
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/5 10:06
 */
public class MainFrameMenuBar {
    /**
     * 构造菜单栏
     *
     * @return
     */
    public static JMenuBar getMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.setBackground(Color.WHITE);
        JMenu jMenu = new JMenu("文件");
        jMenu.setFont(new Font("楷体", Font.BOLD, 14));
        jMenu.setOpaque(false);
        jMenu.setBackground(new Color(0, 0, 0));
        JMenuItem jMenuItem = new JMenuItem("测试");
        jMenuItem.setFont(new Font("楷体", Font.BOLD, 14));
        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);
        return jMenuBar;
    }
}
