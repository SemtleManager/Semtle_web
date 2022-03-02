package com.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBDAO;
import com.User.userDAO;

public class commentDAO {
	
	private static commentDAO instance = null;
	//싱글톤 정적변수
	private static DBDAO db = DBDAO.getInstance();
	
	private Connection conn = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;
	
	
	//싱글톤 패턴
	public static commentDAO getInstance() {
		if(instance == null)
			instance = new commentDAO();
		
		return instance;
	}
	
	//private 로 기본 생성자 차단
	private commentDAO() { }
	
	public void writeComment(int postId, String nickName, String userId, String content, String createAt) {
		String query = 
				"INSERT INTO `DB_sem`.`Comment`" + 
				"(" + 
					"`postId`," + 
					"`nickName`," +
					"`userId`," + 
					"`content`," + 
					"`createAt`" + 
				")" + 
				"VALUES" + 
				"(" + 
					"?," +
					"?," + 
					"?," + 
					"?," + 
					"?" + 
				")";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  postId);
			pstmt.setString(2, nickName);
			pstmt.setString(3, userId);
			pstmt.setString(4,  content);
			pstmt.setString(5,  createAt);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
	}
	
	public int getCommentCnt(int postId) {
		int x = 0;
		String query = 
				"select count(*) from `Comment` where postId = ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  postId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = rs.getInt(1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(conn != null) try{conn.close();}catch(SQLException ex){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException ex){}
			if(rs != null) try{rs.close();}catch(SQLException ex){}
		}
		
		return x;
	}
	
	public List<commentDTO> getComments(int postId) {
		List<commentDTO> commentlists = null;
		String query = 
				"SELECT `Comment`.`commentId`," + 
					"`Comment`.`postId`," + 
					"`Comment`.`nickName`," +
					"`Comment`.`userId`," + 
					"`Comment`.`content`," + 
					"`Comment`.`createAt`" + 
				"FROM `DB_sem`.`Comment` where postId = ? order by createAt desc";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  postId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				commentlists = new ArrayList<commentDTO>();
				do {
					commentDTO comment = new commentDTO();
					comment.setCommentId(rs.getInt("postId"));
					comment.setNickName(rs.getString("nickName"));
					comment.setUserId(rs.getString("userId"));
					comment.setContent(rs.getString("content"));
					comment.setCreateAt(rs.getString("createAt"));
					
					commentlists.add(comment);
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(conn != null) try{conn.close();}catch(SQLException ex){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException ex){}
			if(rs != null) try{rs.close();}catch(SQLException ex){}
			
		}
		
		return commentlists;
	}
	
	public int deleteComment(int commentId) {
		int x = -1;
		String query = 
				"delete from `Comment` where commentId = ?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, commentId);
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
