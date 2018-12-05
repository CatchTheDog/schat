package com.majq.schat.component;

import com.majq.schat.CFrame;

import javax.swing.*;
import java.awt.*;

/**
 * 主窗口右侧组件部分
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/5 10:06
 */
public class MainRightComponent extends JComponent {
    private MainRightCenterComponent mainRightCenter;

    public MainRightComponent(CFrame frame) {
        //jPanelCenter.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setLayout(new BorderLayout());
        //功能菜单栏
        this.add(FunctionalBarComponent.getFunctionalBar(), BorderLayout.NORTH);
        //右侧-右侧边栏
        this.add(OthersideShowComponent.getOthersideShow(), BorderLayout.EAST);
        this.mainRightCenter = new MainRightCenterComponent(frame);
        this.add(mainRightCenter, BorderLayout.CENTER);
    }

    public MainRightCenterComponent getMainRightCenter() {
        return this.mainRightCenter;
    }
}
