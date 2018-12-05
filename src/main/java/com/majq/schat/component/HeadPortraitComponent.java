package com.majq.schat.component;

import javax.swing.*;
import java.awt.*;

/**
 * 聊天对象头像展示栏
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/5 9:48
 */
public class HeadPortraitComponent {
    public static JPanel getHeadPortraitComponent() {
        JPanel jPanelLeft = new JPanel();
        jPanelLeft.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return jPanelLeft;
    }
}
