package com.majq.schat.component;

import com.majq.schat.constant.FrameConstant;

import javax.swing.*;
import java.awt.*;

/**
 * 聊天对象信息展示栏
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/5 9:48
 */
public class OthersideShowComponent extends JComponent {

    private static final int DEFAULT_WIDTH = FrameConstant.DEFAULT_WIDTH * 20 / 100;
    private static final int DEFAULT_HEIGHT = FrameConstant.DEFAULT_HEIGHT;

    public OthersideShowComponent() {
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "信息展示"));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
