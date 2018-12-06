package com.majq.schat.component;


import javax.swing.*;
import java.awt.*;

/**
 * 主窗口右侧主体(聊天历史内容展示+聊天内容输入)
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/5 10:08
 */
public class MainRightCenterComponent extends JComponent {
    private ChatContentShowComponent chatContentShow;
    private ChatContentInputComponent chatContentInput;

    public MainRightCenterComponent() {
        this.setLayout(new BorderLayout());
        //聊天历史内容展示栏
        this.chatContentShow = new ChatContentShowComponent();
        this.add(this.chatContentShow, BorderLayout.CENTER);
        //聊天内容输入栏
        this.chatContentInput = new ChatContentInputComponent();
        this.add(this.chatContentInput, BorderLayout.SOUTH);
    }

    public ChatContentShowComponent getChatContentShow() {
        return this.chatContentShow;
    }
}
