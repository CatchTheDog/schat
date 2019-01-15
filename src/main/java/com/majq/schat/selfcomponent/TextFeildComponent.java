package com.majq.schat.selfcomponent;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Mr.X
 * @version 1.0.0
 * 封装一个文本输入框组件，支持自定义占位字符，最大输入长度，屏蔽字符等
 * @since 2019/01/15 10:52
 */
public class TextFeildComponent extends JTextField {
    /**
     * 占位字符
     */
    private String placeHolder;

    /**
     * 实际输入字符
     */
    private String actualInputStr = "";

    /**
     * 过滤字符
     */
    private String[] excludeStr;

    /**
     * 输入框最大允许字符
     */
    private int maxLength;

    /**
     * 初始化
     *
     * @param placeHolder 占位符
     * @param maxLength   文本框输入内容最大长度
     * @param excludeStr  特殊字符，输入时会替换为*
     */
    public TextFeildComponent(String placeHolder, int maxLength, String[] excludeStr, int columns) {
        super(placeHolder);
        this.setColumns(columns == 0 ? 10 : columns);
        this.setFocusable(false);
        this.placeHolder = placeHolder;
        this.excludeStr = excludeStr;
        this.maxLength = maxLength;
        this.addMouseListener(this.new TextFeildMouseListener());
        this.addFocusListener(this.new TextFeildFocusListener());
    }

    /**
     * 获取实际输入字符串
     *
     * @return 实际输入字符串
     */
    public String getActualInputStr() {
        return actualInputStr;
    }

    /**
     * 实现焦点获取监听器
     */
    private class TextFeildFocusListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            if (getText().equals(placeHolder)) {
                setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (getText().equals("")) {
                setText(placeHolder);
            }
        }
    }

    /**
     * 实现鼠标事件监听器
     */
    private class TextFeildMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            setFocusable(true);
            requestFocus();
        }
    }

}
