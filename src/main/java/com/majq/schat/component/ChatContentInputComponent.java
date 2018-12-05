package com.majq.schat.component;

import com.majq.schat.CFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 聊天内容输入框
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/5 9:45
 */
public class ChatContentInputComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 130;
    private CFrame mainFrame;
    //聊天内容输入框
    private JTextArea contentInput;
    //消息发送按钮
    private JButton sendMessage;
    //消息清除按钮
    private JButton clearMessage;

    public ChatContentInputComponent(CFrame jFrame) {
        this.mainFrame = jFrame;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setLayout(new BorderLayout());
        initChatContentInput();
    }

    /**
     * 初始化聊天内容输入框
     */
    private void initChatContentInput() {
        addTextArea();
        addButton();
    }

    /**
     * 添加文本输入框
     */
    private void addTextArea() {
        contentInput = new JTextArea(5, 40);
        contentInput.setFont(new Font("楷体", Font.PLAIN, 12));
        contentInput.setLineWrap(true);
        contentInput.setText("说点什么吧...");
        contentInput.addInputMethodListener(new ContentInputListener());
        contentInput.addFocusListener(new ContentInputFocusListener());
        this.add(contentInput, BorderLayout.NORTH);
    }

    /**
     * 添加发送和清空按钮
     */
    private void addButton() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 2));
        this.sendMessage = new JButton("发送");
        this.sendMessage.addActionListener(new SendMessageListener());
        this.clearMessage = new JButton("清空");
        this.clearMessage.addActionListener(new ClearMessageListener());
        jPanel.add(sendMessage);
        jPanel.add(clearMessage);
        this.add(jPanel, BorderLayout.SOUTH);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public CFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * 发送信息事件监听器
     */
    private class SendMessageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (null != contentInput.getText()) {
                //在历史消息区展示此消息
                CFrame cFrame = getMainFrame();
                ChatContentShowComponent chatContentShow = cFrame.getMainRightComponent().getMainRightCenter().getChatContentShow();
                chatContentShow.appendContent("我说：" + contentInput.getText());
                contentInput.setText("");
            }
        }
    }

    /**
     * 清除输入消息监听器
     */
    private class ClearMessageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (null != contentInput.getText()) {
                //清空当前输入的信息
                contentInput.setText("");
            }
        }
    }

    /**
     * 文本框开始输入监听器
     */
    private class ContentInputListener implements InputMethodListener {
        @Override
        public void inputMethodTextChanged(InputMethodEvent event) {
            System.out.println("触发事件inputMethodTextChanged了！");
        }

        @Override
        public void caretPositionChanged(InputMethodEvent event) {
            System.out.println("触发事件caretPositionChanged了！");
        }
    }

    /**
     * 输入框焦点获取监听器
     */
    private class ContentInputFocusListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            contentInput.setText("");
            contentInput.setFont(new Font("楷体", Font.BOLD, 16));
        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }
}
