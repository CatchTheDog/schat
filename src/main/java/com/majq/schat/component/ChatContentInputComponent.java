package com.majq.schat.component;

import com.majq.schat.CFrame;
import com.majq.schat.constant.FrameConstant;

import javax.swing.*;
import javax.swing.border.BevelBorder;
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
    private static final int DEFAULT_WIDTH = FrameConstant.DEFAULT_WIDTH * 60 / 100;
    private static final int DEFAULT_HEIGHT = FrameConstant.DEFAULT_HEIGHT * 15 / 100;
    private CFrame mainFrame;
    //聊天内容输入框
    private JTextArea contentInput;
    //消息发送按钮
    private JButton sendMessage;
    //消息清除按钮
    private JButton clearMessage;

    public ChatContentInputComponent(CFrame jFrame) {
        this.mainFrame = jFrame;
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "信息输入"));
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
        contentInput = new JTextArea(3, 40);
        contentInput.setBorder(BorderFactory.createEtchedBorder());
        contentInput.setFont(new Font("楷体", Font.PLAIN, 12));
        contentInput.setLineWrap(true);
        contentInput.setText("说点什么吧...");
        //contentInput.addInputMethodListener(new ContentInputListener());
        contentInput.addFocusListener(new ContentInputFocusListener());
        contentInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("触发keyTyped事件了。");
                if (contentInput.getText().length() > 90) {
                    e.setKeyChar('\0');
                    System.out.println("输入字符大于90字符了。");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.add(contentInput, BorderLayout.CENTER);
    }

    /**
     * 添加发送和清空按钮
     */
    private void addButton() {
        JPanel jPanel = new JPanel();
        jPanel.setOpaque(false);
        jPanel.setLayout(new FlowLayout());
        jPanel.setBorder(BorderFactory.createEtchedBorder());
        this.sendMessage = new JButton("发送");
        this.sendMessage.setPreferredSize(new Dimension(60, 30));
        this.sendMessage.addActionListener(new SendMessageListener());
        this.sendMessage.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
        this.sendMessage.setFont(new Font("楷体", Font.BOLD, 14));
        this.clearMessage = new JButton("清空");
        this.clearMessage.setPreferredSize(new Dimension(60, 30));
        this.clearMessage.addActionListener(new ClearMessageListener());
        this.clearMessage.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
        this.clearMessage.setFont(new Font("楷体", Font.BOLD, 14));
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
     * 重置输入框内容
     */
    public void resetInputContent() {
        contentInput.setFont(new Font("楷体", Font.PLAIN, 12));
        contentInput.setLineWrap(true);
        contentInput.setText("说点什么吧...");
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
                resetInputContent();
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
                resetInputContent();
            }
        }
    }

    /**
     * 文本框开始输入监听器
     */
//    private class ContentInputListener implements InputMethodListener {
//        @Override
//        public void inputMethodTextChanged(InputMethodEvent event) {
//            if (contentInput.getText().length() > 90) {
//                contentInput.append("...");
//            }
//        }
//
//        @Override
//        public void caretPositionChanged(InputMethodEvent event) {
//            System.out.println("触发事件caretPositionChanged了！");
//        }
//    }

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
            if (null == contentInput.getText() || contentInput.getText().trim().length() == 0) {
                resetInputContent();
            }
        }
    }
}
