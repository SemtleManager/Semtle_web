package com.DB;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBDAO {

	
	private static DBDAO instance = null;
	
	public static DBDAO getInstance() {
		if(instance == null)
			instance = new DBDAO();
		
		return instance;
	}
	
	public static Connection getConnection() throws Exception{
		Connection conn = null;
		Context ctx;
		
		ctx = new InitialContext();
		Context envContext = (Context)ctx.lookup("java:/comp/env");
		DataSource ds1 = (DataSource)envContext.lookup("jdbc/DB_sem");
		
		conn = ds1.getConnection();
		
		System.out.println("알림 - DB연동이 정상적으로 되었습니다.");
		
		return conn;
	}
	
	
}
