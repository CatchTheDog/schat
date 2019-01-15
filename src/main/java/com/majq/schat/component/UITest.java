package com.majq.schat.component;

import com.majq.schat.utils.GBC;

import javax.swing.*;
import java.awt.*;

/**
 * 测试GridBagLayout
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/20 15:00
 */
public class UITest extends JFrame {

    public UITest() {
        this.setLayout(new GridBagLayout());
        JPanel toolSelectPanel = new JPanel();
        toolSelectPanel.setBackground(Color.GREEN);
        this.add(toolSelectPanel, new GBC(0, 0, 2, 1).setFill(GBC.BOTH).setIpad(200, 50).setWeight(100, 0));

        JPanel toolConcretePanel = new JPanel();
        toolConcretePanel.setBackground(Color.YELLOW);
        this.add(toolConcretePanel, new GBC(0, 1, 1, 1).setFill(GBC.BOTH).setIpad(70, 90).setWeight(0, 100));

        JPanel drawPanel = new JPanel();
        drawPanel.setBackground(Color.WHITE);
        this.add(drawPanel, new GBC(1, 1, 1, 1).setFill(GBC.BOTH));
        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(Color.LIGHT_GRAY);
        this.add(colorPanel, new GBC(0, 2, 2, 1).setFill(GBC.BOTH).setIpad(200, 50).setWeight(100, 0));

        JPanel statePanel = new JPanel();
        statePanel.setBackground(Color.CYAN);
        this.add(statePanel, new GBC(0, 3, 2, 1).setFill(GBC.BOTH).setIpad(200, 20).setWeight(100, 0));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            UITest uiTest = new UITest();
            uiTest.setTitle("UITest");
            uiTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            uiTest.setSize(new Dimension(300, 400));
            uiTest.setVisible(true);
        });
    }
}
