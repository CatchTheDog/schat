package com.majq.schat.component;

import com.majq.schat.constant.FrameConstant;
import com.majq.schat.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;

/**
 * 用户注册UI界面
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/20 17:09
 */
public class RegisterFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public RegisterFrame(){
        addComponent();
        initFrame();

    }
    /**
     * 初始化窗口
     */
    private void initFrame(){
        this.setTitle("注册");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(FrameConstant.DEFAULT_LOCATION_X,FrameConstant.DEFAULT_LOCATION_Y);
        this.setIconImage(ImageUtils.loadImage(FrameConstant.ICON_IMAGE_PATH));
        this.pack();
        this.setVisible(true);
    }

    /**
     * 为窗口添加组件
     */
    private void addComponent(){
        this.setLayout(new BorderLayout());
        this.add(new RegisterComponent(), BorderLayout.NORTH);
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(600, 600);
    }

     public static void main(String[] args) {
        EventQueue.invokeLater(() -> new RegisterFrame());
    }

    
}
