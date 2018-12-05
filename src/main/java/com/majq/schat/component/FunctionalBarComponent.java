package com.majq.schat.component;

import javax.swing.*;
import java.awt.*;

/**
 * 功能菜单栏
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/5 9:47
 */
public class FunctionalBarComponent {
    public static JPanel getFunctionalBar() {
        JPanel jpCenterTop = new JPanel();
        jpCenterTop.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return jpCenterTop;
    }
}
