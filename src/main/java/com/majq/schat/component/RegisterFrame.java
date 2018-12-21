package com.majq.schat.component;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.*;

import com.majq.schat.constant.FrameConstant;
import com.majq.schat.utils.ImageUtils;

/**
 * 用户注册UI界面
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/20 17:09
 */
public class RegisterFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public RegisterFrame(){
        initFrame();
    }
    /**
     * 初始化窗口
     */
    private void initFrame(){
        this.setTitle("注册账号");
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
        
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(FrameConstant.DEFAULT_WIDTH,FrameConstant.DEFAULT_HEIGHT);
    }

     public static void main(String[] args) {
        EventQueue.invokeLater(() -> new RegisterFrame());
    }

    
}
