package com.majq.schat.component;

import javax.swing.*;

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
        JMenu jMenu = new JMenu("文件");
        JMenuItem jMenuItem = new JMenuItem("测试");
        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);
        return jMenuBar;
    }
}
