package com.Schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBDAO;

public class scheduleDAO {
	private static scheduleDAO instance = null;
	//싱글톤 정적변수
	private static DBDAO db = DBDAO.getInstance();
	
	private Connection conn = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;
	
	
	//싱글톤 패턴
	public static scheduleDAO getInstance() {
		if(instance == null)
			instance = new scheduleDAO();
		
		return instance;
	}
	
	//private 로 기본 생성자 차단
	private scheduleDAO() { }
	
	public void setSchedule(scheduleDTO schedule) {
		String query = 
				"INSERT INTO `DB_sem`.`Schedule`" + 
				"(" + 
					"`scheduleMonth`," + 
					"`scheduleDay`," + 
					"`scheduleName`," + 
					"`scheduleContent`," + 
					"`createdAt`," + 
					"`updateAt`" + 
				")" + 
				"VALUES" + 
				"(" + 
					"?," + 
					"?," + 
					"?," + 
					"?," + 
					"?," + 
					"?" + 
				")";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1,  schedule.getScheduleMonth());
			pstmt.setString(2,  schedule.getScheduleDay());
			pstmt.setString(3,  schedule.getScheduleName());
			pstmt.setString(4,  schedule.getScheduleContent());
			pstmt.setString(5,  schedule.getCreateAt());
			pstmt.setString(6,  schedule.getUpdateAt());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
	}
	
	public List<scheduleDTO> selectSchedule(int month) {
		List<scheduleDTO> schedulelists = null;
		String query = 
				"SELECT `Schedule`.`scheduldId`," + 
					"`Schedule`.`scheduleMonth`," + 
					"`Schedule`.`scheduleDay`," + 
					"`Schedule`.`scheduleName`," + 
					"`Schedule`.`scheduleContent`," + 
					"`Schedule`.`createdAt`," + 
					"`Schedule`.`updateAt`" + 
				"FROM `DB_sem`.`Schedule` order by scheduleDay desc";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				schedulelists = new ArrayList<scheduleDTO> ();
				do {
					scheduleDTO schedule = new scheduleDTO();
					schedule.setScheduleMonth(rs.getString("scheduleMonth"));
					schedule.setScheduleDay(rs.getString("scheduleDay"));
					schedule.setScheduleName(rs.getString("scheduleName"));
					schedule.setScheduleContent(rs.getString("scheduleContent"));
					schedule.setCreateAt(rs.getString("createdAt"));
					schedule.setUpdateAt(rs.getString("updateAt"));
					schedulelists.add(schedule);
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
		return schedulelists;
	}
	
	public int deleteSchedule(int scheduleId) {
		int x = -1;
		String query = 
				"delete from Schedule where scheduleId = ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, scheduleId);
			pstmt.executeUpdate();
			x = 1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(conn != null) try{conn.close();}catch(SQLException ex){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException ex){}
			if(rs != null) try{rs.close();}catch(SQLException ex){}
		}
		return x;
	}
	
	
	
	
	
	
	
	
	
	
	
}
