package com.majq.schat.utils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 数据库连接池:支持连接管理，事务管理，多线程请求排队等
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2019/01/22 17:25
 */
public class JDBCConnectionPool {
    /**
     * 最小连接数
     */
    private int minConnNum;
    /**
     * 最大连接数
     */
    private int maxConnNum;
    /**
     * 最大空闲连接数
     */
    private int maxIdleConnNum;
    /**
     * 连接池内连接集合
     */
    private List<Connection> connections = new ArrayList<>();

    /**
     * 请求队列
     */
    private ArrayBlockingQueue blockingQueue;
}
