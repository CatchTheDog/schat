package com.majq.schat.component;

import com.majq.schat.utils.GBC;

import javax.swing.*;
import java.awt.*;
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

        JLabel locationLabel = new JLabel("所在地:");
        JComboBox<String> province = new JComboBox();
        for (String str : provinceList) {
            province.addItem(str);
        }

        JComboBox<String> cities = new JComboBox<>();


        this.add(userNameLabel, new GBC(0, 1, 1, 1).setIpad(10, 5));
        this.add(userNameField, new GBC(1, 1, 2, 1).setAnchor(GBC.CENTER).setIpad(110, 5));
        this.add(sexLabel, new GBC(0, 2, 1, 1).setIpad(10, 5));
        this.add(male, new GBC(1, 2, 1, 1));
        this.add(female, new GBC(2, 2, 1, 1));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 300);
    }
}