package com.majq.schat.component;

import com.majq.schat.utils.GBC;
import com.majq.schat.utils.ImageUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 用户注册页面组件
 * @author Mr.x
 * @since 2018/12/21 14:38
 * @version 1.0.0
 */
public class RegisterComponent extends JComponent{

    private static java.util.List<String> provinceList = new ArrayList<>();
    private static java.util.Map<String, java.util.List<String>> cityList = new HashMap<>();

    static {
        provinceList.add("北京市");
        provinceList.add("天津市");
        provinceList.add("河北省");

        cityList.put("", new ArrayList<>());
    }

    public RegisterComponent() {
        this.setLayout(new GridBagLayout());
        JLabel userNameLabel = new JLabel("用户名称:");
        JTextField userNameField = new JTextField();

        JLabel sexLabel = new JLabel("性别:");
        ButtonGroup sexGroup = new ButtonGroup();
        JRadioButton male = new JRadioButton("男", true);
        JRadioButton female = new JRadioButton("女");
        sexGroup.add(male);
        sexGroup.add(female);
        JLabel portrait = new JLabel("头像");
        ImageIcon imageIcon = new ImageIcon(ImageUtils.loadImage("/image/default_portrait.jpeg"));
        JLabel defaultPortrait = new JLabel(imageIcon);
        JButton addPortrait = new JButton("选择头像");
        addPortrait.addActionListener(new ChoosePortraitListener());
        JTextArea description = new JTextArea(8, 40);
        description.setLineWrap(true);
        description.setSelectedTextColor(Color.BLUE);
        JButton submit = new JButton("提交");


        this.add(userNameLabel, new GBC(0, 1, 1, 1).setIpad(10, 5));
        this.add(userNameField, new GBC(1, 1, 2, 1).setAnchor(GBC.CENTER).setIpad(110, 5));
        this.add(sexLabel, new GBC(0, 2, 1, 1).setIpad(10, 5));
        this.add(male, new GBC(1, 2, 1, 1));
        this.add(female, new GBC(2, 2, 1, 1));
        this.add(portrait, new GBC(0, 3, 1, 3).setIpad(10, 5));
        this.add(defaultPortrait, new GBC(1, 3, 3, 3).setIpad(20, 20));
        this.add(addPortrait, new GBC(4, 3, 1, 3).setIpad(10, 5));
        this.add(description, new GBC(0, 6, 5, 5).setIpad(10, 10));
        this.add(submit, new GBC(1, 12, 1, 1).setIpad(10, 10));
    }

    /**
     * 选择头像监听器
     */
    private class ChoosePortraitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new File("."));
            jFileChooser.setMultiSelectionEnabled(false);
            jFileChooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    String fileName = f.getName();
                    java.util.List<String> avaliableExtensionName = new ArrayList<>();
                    avaliableExtensionName.add("jpg");
                    avaliableExtensionName.add("jpeg");
                    avaliableExtensionName.add("png");
                    String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
                    return f.length() < 2000000L && avaliableExtensionName.indexOf(fileExtensionName) > -1;
                }

                @Override
                public String getDescription() {
                    return "jpg,jpeg,png";
                }
            });
            jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = jFileChooser.showDialog(RegisterComponent.this, "选择头像");
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = jFileChooser.getSelectedFile().getPath();

            }
        }
    }

    /**
     * 提交注册信息到后台
     */
    private class SubmitRegistInfoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //将注册信息提交到后台
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 300);
    }
}