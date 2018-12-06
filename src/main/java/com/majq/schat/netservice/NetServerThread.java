package com.majq.schat.netservice;

import com.majq.schat.component.ChatContentShowComponent;
import com.majq.schat.component.MainFrame;
import com.majq.schat.utils.DateUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * socket处理类
 * 在应用启动后，自动启动线程附着在应用上，用于接收聊天信息，并发送聊天信息
 *
 * @author Mr.X
 * @version 1.0.0
 *
 *
 * @since 2018/12/6 11:05
 */
public class NetServerThread implements Runnable {
    private Scanner in;
    private PrintWriter out;
    private Socket incoming;

    public NetServerThread(Socket socket) {
        this.incoming = socket;
        try {
            InputStream input = incoming.getInputStream();
            OutputStream output = incoming.getOutputStream();
            this.in = new Scanner(input);
            this.out = new PrintWriter(output, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            ChatContentShowComponent chatContentShowComponent = MainFrame.loadUI().getMainRightComponent().getMainRightCenter().getChatContentShow();
            while (this.in.hasNextLine()) {
                chatContentShowComponent.appendContent(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + " 神秘人：" + this.in.nextLine());
            }
        } finally {
            try {
                this.out.close();
                this.in.close();
                this.incoming.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送信息
     *
     * @param message 聊天信息
     */
    public void sendMessage(String message) {
        this.out.println(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss ") + "Mr.x: " + message);
    }
}
