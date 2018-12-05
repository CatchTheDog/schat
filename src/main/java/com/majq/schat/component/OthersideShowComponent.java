package com.majq.schat.component;

import javax.swing.*;
import java.awt.*;

/**
 * 聊天对象信息展示栏
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/5 9:48
 */
public class OthersideShowComponent {
    public static JPanel getOthersideShow() {
        JPanel jpCenterRight = new JPanel();
        jpCenterRight.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return jpCenterRight;
    }
}
