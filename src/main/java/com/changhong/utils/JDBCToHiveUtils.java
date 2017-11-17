package com.changhong.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/11/16.
 */
public class JDBCToHiveUtils {
    private static String driverName ="org.apache.hive.jdbc.HiveDriver";   // 此Class 位于 hive-jdbc的jar包下
    private static String Url="jdbc:hive2://**.**.**.**:10000/default";    //填写hive的IP，之前在配置文件中配置的IP
    private static Connection conn;
    public static Connection getConnnection() {
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(Url,"","");        //只是连接hive, 用户名可不传
        } catch(ClassNotFoundException e)  {
            e.printStackTrace();
            System.exit(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static PreparedStatement prepare(Connection conn, String sql) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
}
