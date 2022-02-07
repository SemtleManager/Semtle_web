package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://54.159.140.253:3306/DB_sem?useSSL=false&useUnicode=true&amp;characterEncoding=utf-8",
				"semtle",
				"Semtle0420!"
			);
		
	}
}