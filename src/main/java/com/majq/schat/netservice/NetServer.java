package com.majq.schat.netservice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 启动网络服务
 */
public class NetServer implements Runnable {

    public static Map<String, NetServerThread> socketMap = new HashMap<>();
    private static int i = 0;

    @Override
    public void run() {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(8189);
            while (true) {
                Socket incoming = socket.accept();
                NetServerThread handler = new NetServerThread(incoming);
                socketMap.put("connector_" + i, handler);
                new Thread(handler).start(); //开启异步线程对请求进行处理
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
