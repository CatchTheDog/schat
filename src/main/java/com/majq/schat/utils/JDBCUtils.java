/*
package com.majq.schat.utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

*/
/**
 * @author Mr.X
 * @version 1.0.0
 * JDBC工具类
 * @param driverClassName 数据库驱动程序类名
 * @param url             数据库URL
 * @param username        用户名
 * @param password        密码
 * @return 数据库连接
 * @throws ClassNotFoundException 数据库驱动未找到
 * @throws SQLException           创建连接异常
 * <p>
 * 执行简单——非预编译sql
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @return ExecuteSQLResult sql执行结果描述对象
 * executeUpdate 执行INSERT,UPDATE,DELETE,CREATE TABLE,DROP TABLE 之类的定义语句等
 * execute 执行任意sql,通常用于执行用户提供的交互式查询
 * executeQuery 执行SELECT查询
 * <p>
 * 组装查询结果对象
 * @param statement sql执行对象
 * @return 查询结果对象
 * <p>
 * 执行预编译sql
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @param args       sql编译参数
 * @return sql 执行结果描述对象
 * <p>
 * 关闭数据库连接
 * @param connection 待关闭数据库连接
 * @throws SQLException 关闭数据库连接异常
 * <p>
 * sql执行结果描述对象
 * <p>
 * 受影响的行数
 * <p>
 * 查询结果集合
 * @param driverClassName 数据库驱动程序类名
 * @param url             数据库URL
 * @param username        用户名
 * @param password        密码
 * @return 数据库连接
 * @throws ClassNotFoundException 数据库驱动未找到
 * @throws SQLException           创建连接异常
 * <p>
 * 执行简单——非预编译sql
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @return ExecuteSQLResult sql执行结果描述对象
 * executeUpdate 执行INSERT,UPDATE,DELETE,CREATE TABLE,DROP TABLE 之类的定义语句等
 * execute 执行任意sql,通常用于执行用户提供的交互式查询
 * executeQuery 执行SELECT查询
 * <p>
 * 组装查询结果对象
 * @param statement sql执行对象
 * @return 查询结果对象
 * <p>
 * 执行预编译sql
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @param args       sql编译参数
 * @return sql 执行结果描述对象
 * <p>
 * 关闭数据库连接
 * @param connection 待关闭数据库连接
 * @throws SQLException 关闭数据库连接异常
 * <p>
 * sql执行结果描述对象
 * <p>
 * 受影响的行数
 * <p>
 * 查询结果集合
 * @param driverClassName 数据库驱动程序类名
 * @param url             数据库URL
 * @param username        用户名
 * @param password        密码
 * @return 数据库连接
 * @throws ClassNotFoundException 数据库驱动未找到
 * @throws SQLException           创建连接异常
 * <p>
 * 执行简单——非预编译sql
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @return ExecuteSQLResult sql执行结果描述对象
 * executeUpdate 执行INSERT,UPDATE,DELETE,CREATE TABLE,DROP TABLE 之类的定义语句等
 * execute 执行任意sql,通常用于执行用户提供的交互式查询
 * executeQuery 执行SELECT查询
 * <p>
 * 组装查询结果对象
 * @param statement sql执行对象
 * @return 查询结果对象
 * <p>
 * 执行预编译sql
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @param args       sql编译参数
 * @return sql 执行结果描述对象
 * <p>
 * 关闭数据库连接
 * @param connection 待关闭数据库连接
 * @throws SQLException 关闭数据库连接异常
 * <p>
 * sql执行结果描述对象
 * <p>
 * 受影响的行数
 * <p>
 * 查询结果集合
 * @param driverClassName 数据库驱动程序类名
 * @param url             数据库URL
 * @param username        用户名
 * @param password        密码
 * @return 数据库连接
 * @throws ClassNotFoundException 数据库驱动未找到
 * @throws SQLException           创建连接异常
 * <p>
 * 执行简单——非预编译sql
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @return ExecuteSQLResult sql执行结果描述对象
 * executeUpdate 执行INSERT,UPDATE,DELETE,CREATE TABLE,DROP TABLE 之类的定义语句等
 * execute 执行任意sql,通常用于执行用户提供的交互式查询
 * executeQuery 执行SELECT查询
 * <p>
 * 组装查询结果对象
 * @param statement sql执行对象
 * @return 查询结果对象
 * <p>
 * 执行预编译sql
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @param args       sql编译参数
 * @return sql 执行结果描述对象
 * <p>
 * 关闭数据库连接
 * @param connection 待关闭数据库连接
 * @throws SQLException 关闭数据库连接异常
 * <p>
 * sql执行结果描述对象
 * <p>
 * 受影响的行数
 * <p>
 * 查询结果集合
 * @param driverClassName 数据库驱动程序类名
 * @param url             数据库URL
 * @param username        用户名
 * @param password        密码
 * @return 数据库连接
 * @throws ClassNotFoundException 数据库驱动未找到
 * @throws SQLException           创建连接异常
 * <p>
 * 执行简单——非预编译sql
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @return ExecuteSQLResult sql执行结果描述对象
 * executeUpdate 执行INSERT,UPDATE,DELETE,CREATE TABLE,DROP TABLE 之类的定义语句等
 * execute 执行任意sql,通常用于执行用户提供的交互式查询
 * executeQuery 执行SELECT查询
 * <p>
 * 组装查询结果对象
 * @param statement sql执行对象
 * @return 查询结果对象
 * <p>
 * 执行预编译sql
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @param args       sql编译参数
 * @return sql 执行结果描述对象
 * <p>
 * 关闭数据库连接
 * @param connection 待关闭数据库连接
 * @throws SQLException 关闭数据库连接异常
 * <p>
 * sql执行结果描述对象
 * <p>
 * 受影响的行数
 * <p>
 * 查询结果集合
 * @param driverClassName 数据库驱动程序类名
 * @param url             数据库URL
 * @param username        用户名
 * @param password        密码
 * @return 数据库连接
 * @throws ClassNotFoundException 数据库驱动未找到
 * @throws SQLException           创建连接异常
 * <p>
 * 执行简单——非预编译sql
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @return ExecuteSQLResult sql执行结果描述对象
 * executeUpdate 执行INSERT,UPDATE,DELETE,CREATE TABLE,DROP TABLE 之类的定义语句等
 * execute 执行任意sql,通常用于执行用户提供的交互式查询
 * executeQuery 执行SELECT查询
 * <p>
 * 组装查询结果对象
 * @param statement sql执行对象
 * @return 查询结果对象
 * <p>
 * 执行预编译sql
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @param args       sql编译参数
 * @return sql 执行结果描述对象
 * <p>
 * 关闭数据库连接
 * @param connection 待关闭数据库连接
 * @throws SQLException 关闭数据库连接异常
 * <p>
 * sql执行结果描述对象
 * <p>
 * 受影响的行数
 * <p>
 * 查询结果集合
 * @since 2019/01/22 14:50
 * <p>
 * 根据传入驱动信息，连接URL，用户名，密码信息 创建数据库连接
 * <p>
 * 根据传入驱动信息，连接URL，用户名，密码信息 创建数据库连接
 * <p>
 * 根据传入驱动信息，连接URL，用户名，密码信息 创建数据库连接
 * <p>
 * 根据传入驱动信息，连接URL，用户名，密码信息 创建数据库连接
 * <p>
 * 根据传入驱动信息，连接URL，用户名，密码信息 创建数据库连接
 * <p>
 * 根据传入驱动信息，连接URL，用户名，密码信息 创建数据库连接
 *//*

public class JDBCUtils {
    */
/**
 * 根据传入驱动信息，连接URL，用户名，密码信息 创建数据库连接
 *
 * @param driverClassName 数据库驱动程序类名
 * @param url             数据库URL
 * @param username        用户名
 * @param password        密码
 * @return 数据库连接
 * @throws ClassNotFoundException 数据库驱动未找到
 * @throws SQLException           创建连接异常
 * <p>
 * 执行简单——非预编译sql
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @return ExecuteSQLResult sql执行结果描述对象
 * executeUpdate 执行INSERT,UPDATE,DELETE,CREATE TABLE,DROP TABLE 之类的定义语句等
 * execute 执行任意sql,通常用于执行用户提供的交互式查询
 * executeQuery 执行SELECT查询
 * <p>
 * 组装查询结果对象
 * @param statement sql执行对象
 * @return 查询结果对象
 * <p>
 * 执行预编译sql
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @param args       sql编译参数
 * @return sql 执行结果描述对象
 * <p>
 * 关闭数据库连接
 * @param connection 待关闭数据库连接
 * @throws SQLException 关闭数据库连接异常
 * <p>
 * sql执行结果描述对象
 * <p>
 * 受影响的行数
 * <p>
 * 查询结果集合
 *//*

    public static Connection getConnection(String driverClassName, String url, String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName(driverClassName);
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    */
/**
 * 执行简单——非预编译sql
 *
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @return ExecuteSQLResult sql执行结果描述对象
 * executeUpdate 执行INSERT,UPDATE,DELETE,CREATE TABLE,DROP TABLE 之类的定义语句等
 * execute 执行任意sql,通常用于执行用户提供的交互式查询
 * executeQuery 执行SELECT查询
 *//*

    public static ExecuteSQLResult excuteStatementSQL(Connection connection, String sql) throws SQLException {

        if (null != connection && StringUtils.isNotBlank(sql)) {
            Statement statement = connection.createStatement();
            boolean hasResultSet = statement.execute(sql);
            return assembleResult(hasResultSet, statement);
        } else
            throw new IllegalArgumentException("connection ,sql cann't be null !");
    }

    */
/**
 * 组装查询结果对象
 *
 * @param statement sql执行对象
 * @return 查询结果对象
 *//*

    private static <T> List<T> assembleResult(boolean hasResultSet, Statement statement,Class<T> targetClass) throws SQLException {
        ResultSet resultSet = null;
        try {
            List<ExecuteSQLResult> results = new ArrayList<>();
            boolean done = false;
            while (!done) {
                ExecuteSQLResult executeSQLResult = new ExecuteSQLResult();
                if (hasResultSet) {
                    resultSet = statement.getResultSet();
                    executeSQLResult.setResultSet(resultSet);
                    executeSQLResult.setAffectedRowsNum(-1);
                } else {
                    int updateCount = statement.getUpdateCount();
                    executeSQLResult.setAffectedRowsNum(updateCount);
                    executeSQLResult.setResultSet(null);
                    if (updateCount < 0) done = true; //这里是为什么？
                }
                results.add(executeSQLResult);
                hasResultSet = statement.getMoreResults(); //与execute()方法一致，如果下一结果集是ResultSet，则返回true.
            }
            //使用反射组装bean
        } finally {
            if (null != resultSet) resultSet.close();
            if (null != statement) statement.close();
        }
    }

    */
/**
 * 执行预编译sql
 *
 * @param connection 数据库连接
 * @param sql        待执行sql
 * @param args       sql编译参数
 * @return sql 执行结果描述对象
 *//*

    public static List<ExecuteSQLResult> executeSQLResult(Connection connection, String sql, Map<String, Object> args) throws SQLException {
        if (null != connection && StringUtils.isNotBlank(sql) && null != args && args.size() > 0) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int i = 1;
            for (Iterator<Map.Entry<String, Object>> iterator = args.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<String, Object> arg = iterator.next();
                switch (arg.getKey()) {
                    case "Array":
                        preparedStatement.setArray(i, (java.sql.Array) arg.getValue());
                        break;
                    case "AsciiStream":
                        preparedStatement.setAsciiStream(i, (java.io.InputStream) arg.getValue());
                        break;
                    case "BigDecimal":
                        preparedStatement.setBigDecimal(i, (java.math.BigDecimal) arg.getValue());
                        break;
                    case "BinaryStream":
                        preparedStatement.setBinaryStream(i, (java.io.InputStream) arg.getValue());
                        break;
                    case "Blob":
                        preparedStatement.setBlob(i, (java.sql.Blob) arg.getValue());
                        break;
                    case "Boolean":
                        preparedStatement.setBoolean(i, (java.lang.Boolean) arg.getValue());
                        break;
                    case "Byte":
                        preparedStatement.setByte(i, (java.lang.Byte) arg.getValue());
                        break;
                    case "Bytes":
                        Object value = arg.getValue();
                        int len = java.lang.reflect.Array.getLength(value);
                        byte[] bytes = new byte[len];
                        Object[] objs = ArrayUtils.transObjToArray(value, Byte.class);
                        for (int j = 0; j < len; j++) {
                            bytes[j] = (Byte) objs[j];
                        }
                        preparedStatement.setBytes(i, bytes);
                        break;
                    case "CharacterStream":
                        preparedStatement.setCharacterStream(i, (java.io.Reader) arg.getValue());
                        break;
                    case "Clob":
                        preparedStatement.setClob(i, (java.sql.Clob) arg.getValue());
                        break;
                    case "Date":
                        preparedStatement.setDate(i, (java.sql.Date) arg.getValue());
                        break;
                    case "Double":
                        preparedStatement.setDouble(i, (java.lang.Double) arg.getValue());
                        break;
                    case "Float":
                        preparedStatement.setFloat(i, (java.lang.Float) arg.getValue());
                        break;
                    case "Int":
                        preparedStatement.setInt(i, (java.lang.Integer) arg.getValue());
                        break;
                    case "Long":
                        preparedStatement.setLong(i, (java.lang.Long) arg.getValue());
                        break;
                    case "NCharacterStream":
                        preparedStatement.setNCharacterStream(i, (java.io.Reader) arg.getValue());
                        break;
                    case "NClob":
                        preparedStatement.setNClob(i, (java.sql.NClob) arg.getValue());
                        break;
                    case "NString":
                        preparedStatement.setNString(i, (String) arg.getValue());
                        break;
                    case "RowId":
                        preparedStatement.setRowId(i, (java.sql.RowId) arg.getValue());
                        break;
                    case "Short":
                        preparedStatement.setShort(i, (java.lang.Short) arg.getValue());
                        break;
                    case "SQLXML":
                        preparedStatement.setSQLXML(i, (java.sql.SQLXML) arg.getValue());
                        break;
                    case "String":
                        preparedStatement.setString(i, (String) arg.getValue());
                        break;
                    case "Time":
                        preparedStatement.setTime(i, (java.sql.Time) arg.getValue());
                        break;
                    case "TimeStamp":
                        preparedStatement.setTimestamp(i, (java.sql.Timestamp) arg.getValue());
                        break;
                    case "URL":
                        preparedStatement.setURL(i, (java.net.URL) arg.getValue());
                        break;
                }
                i++;
            }
            boolean hasResultSet = preparedStatement.execute();
            return assembleResult(hasResultSet, preparedStatement);
        } else
            throw new IllegalArgumentException("connection,sql,args can't be null!");
    }


    */
/**
 * 关闭数据库连接
 *
 * @param connection 待关闭数据库连接
 * @throws SQLException 关闭数据库连接异常
 *//*

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null)
            connection.close();
    }

    */
/**
 * sql执行结果描述对象
 *//*

    public static class ExecuteSQLResult {
        */
/**
 * 受影响的行数
 *//*

        private int affectedRowsNum;
        */
/**
 * 查询结果集合
 *//*

        private ResultSet resultSet;

        public int getAffectedRowsNum() {
            return affectedRowsNum;
        }

        public void setAffectedRowsNum(int affectedRowsNum) {
            this.affectedRowsNum = affectedRowsNum;
        }

        public ResultSet getResultSet() {
            return resultSet;
        }

        public void setResultSet(ResultSet resultSet) {
            this.resultSet = resultSet;
        }

        @Override
        public String toString() {
            return "ExecuteSQLResult{" +
                    "affectedRowsNum=" + affectedRowsNum +
                    ", resultSet=" + resultSet +
                    '}';
        }
    }

    public static void main(String [] args) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost/test1?serverTimezone=GMT%2B8","root","mr!@#$x");
        List<ExecuteSQLResult> results = excuteStatementSQL(connection,"select * from user");
        for(ExecuteSQLResult executeSQLResult : results){
            System.out.println(executeSQLResult.getAffectedRowsNum());
            ResultSet resultSet = executeSQLResult.getResultSet();
            if(null != resultSet){
                if(resultSet.next()){
                    System.out.println(resultSet.getInt(1));
                }
            }
        }
    }
}
*/
