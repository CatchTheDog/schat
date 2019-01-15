package com.majq.schat.component;

import com.majq.schat.constant.FrameConstant;

import javax.swing.*;
import java.awt.*;

/**
 * 功能菜单栏
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/5 9:47
 */
public class FunctionalBarComponent extends JComponent {

    private static final int DEFAULT_WIDTH = FrameConstant.DEFAULT_WIDTH * 75 / 100;
    private static final int DEFAULT_HEIGHT = FrameConstant.DEFAULT_HEIGHT * 5 / 100;

    public FunctionalBarComponent() {
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "工具栏"));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
