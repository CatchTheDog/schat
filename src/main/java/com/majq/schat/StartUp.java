package com.majq.schat;

import com.majq.schat.component.MainFrame;
import com.majq.schat.netservice.NetServer;

import java.io.IOException;

/**
 * 系统启动类
 * 问题：Swing组件使用线程分发器进行渲染操作；而网络服务端需要将接收到的信息展示在Swing组件中；
 * 如下实现，会导致Server.startServer(mainFrame)，方法中，mainFrame 为 null.
 * 如何解决？
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2018/12/6 10:20
 */
public class StartUp {
    public static void main(String[] args) throws IOException {
        startUp();
    }

    /**
     * 应用启动入口
     */
    public static void startUp() {
        MainFrame.loadUI();
        NetServer.startServer();
    }
}
