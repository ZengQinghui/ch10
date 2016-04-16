package com.briup.estore.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String name;
	private static String password;
	
	static{
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://127.0.0.1:3306/test";
		name = "root";
		password = "123";
	}
	
	public static Connection getConn() throws Exception {
		//注册驱动
		Class.forName(driver);
		//获取链接
		return DriverManager.getConnection(url, name, password);
	}
	
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn) throws SQLException{
		if(rs!= null){
			rs.close();
		}
		
		if(pstmt!=null){
			pstmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
