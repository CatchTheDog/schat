package com.majq.schat.component;

import com.majq.schat.constant.FrameConstant;

import javax.swing.*;
import java.awt.*;

/**
 * 聊天对象头像展示栏
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/5 9:48
 */
public class HeadPortraitComponent extends JComponent {

    private static final int DEFAULT_WIDTH = FrameConstant.DEFAULT_WIDTH * 25 / 100;
    private static final int DEFAULT_HEIGHT = FrameConstant.DEFAULT_HEIGHT;

    public HeadPortraitComponent() {
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "头像展示"));
        this.setOpaque(false);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
