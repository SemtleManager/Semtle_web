package com.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBDAO;

public class postDAO {
	
	private static postDAO instance = null;
	//싱글톤 정적변수
	private static DBDAO db = DBDAO.getInstance();
	
	private Connection conn = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;
	
	
	//싱글톤 패턴
	public static postDAO getInstance() {
		if(instance == null)
			instance = new postDAO();
		
		return instance;
	}
	
	//private 로 기본 생성자 차단
	private postDAO() { }
	
	public void writePost(postDTO article) {
		String query = 
				"INSERT INTO `DB_sem`.`Post`" + 
				"(" +
					"`boardId`," + 
					"`title`," + 
					"`userId`," + 
					"`content`," + 
					"`fileUrl`," + 
					"`createAt`," + 
					"`updateAt`," + 
					"`status`" +
				")" + 
				"VALUES" + 
				"(" +
					"?," + 
					"?," + 
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
			
			pstmt.setString(1, article.getBoardId());
			pstmt.setString(2, article.getTitle());
			pstmt.setString(3,  article.getUserId());
			pstmt.setString(4,  article.getContent());
			pstmt.setString(5, article.getFileUrl());
			pstmt.setString(6,  article.getCreateAt());
			pstmt.setString(7,  article.getUpdateAt());
			pstmt.setString(8,  article.getStatus());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
	}
	
	public int getPostCount(String boardId) {
		int x = 0;
		String query = 
				"select count(*) from Post";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			if(rs.next()) 
				x = rs.getInt(1);
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally{
			if(conn != null) try{conn.close();}catch(SQLException ex){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException ex){}
			if(rs != null) try{rs.close();}catch(SQLException ex){}
		}
		return x;
		
	}
	
	public List<postDTO> getPosts(String boardId, int start, int end) {
		
		List<postDTO> postlists = null;
		String query = 
				"SELECT " + 
					"`Post`.`postId`," + 
					"`Post`.`boardId`," + 
					"`Post`.`title`," + 
					"`Post`.`userId`," + 
					"`Post`.`content`," + 
					"`Post`.`fileUrl`," + 
					"`Post`.`createAt`," + 
					"`Post`.`updateAt`," + 
					"`Post`.`status`" + 
				"FROM `DB_sem`.`Post` where boardId = ? order by reg_date desc limit ?,?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, boardId);
			pstmt.setInt(2,  start - 1);
			pstmt.setInt(3,  end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				postlists = new ArrayList<postDTO> (end);
				do {
					postDTO post = new postDTO();
					post.setPostId(rs.getInt("postId"));
					post.setBoardId(rs.getString("boardId"));
					post.setTitle(rs.getString("title"));
					post.setUserId(rs.getString("userId"));
					post.setContent(rs.getString("content"));
					post.setFileUrl(rs.getString("fileUrl"));
					post.setCreateAt(rs.getString("createAt"));
					post.setUpdateAt(rs.getString("updateAt"));
					post.setStatus(rs.getString("status"));
					
					postlists.add(post);
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally{
			if(conn != null) try{conn.close();}catch(SQLException ex){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException ex){}
			if(rs != null) try{rs.close();}catch(SQLException ex){}
			
		}
		return postlists;
	}
	
	public postDTO readPost(int boardId) {
		postDTO post = null;
		String update_query = 
				"update post set lookUp = lookUp + 1 where boardId = ?";
		String select_query = 
				"SELECT `Post`.`postId`," + 
					"`Post`.`boardId`," + 
					"`Post`.`title`," + 
					"`Post`.`userId`," + 
					"`Post`.`content`," + 
					"`Post`.`fileUrl`," + 
					"`Post`.`createAt`," + 
					"`Post`.`updateAt`," + 
					"`Post`.`status`" + 
				"FROM `DB_sem`.`Post` where boardId = ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(update_query);
			pstmt.setInt(1,  boardId);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(select_query);
			pstmt.setInt(1,  boardId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				post = new postDTO();
				post.setPostId(rs.getInt("postId"));
				post.setBoardId(rs.getString("boardId"));
				post.setTitle(rs.getString("title"));
				post.setUserId(rs.getString("userId"));
				post.setContent(rs.getString("content"));
				post.setFileUrl(rs.getString("fileUrl"));
				post.setCreateAt(rs.getString("createAt"));
				post.setUpdateAt(rs.getString("updateAt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) try{conn.close();}catch(SQLException ex){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException ex){}
			if(rs != null) try{rs.close();}catch(SQLException ex){}
		}
		return post;
	}
	
	public int updatePost(postDTO post, int postId) {
		int x = -1;
		String query = 
				"UPDATE `DB_sem`.`Post`" + 
				"SET" + 
					"`title` = ?," + 
					"`content` = ?," + 
					"`fileUrl` = ?," + 
					"`updateAt` = ?," + 
				"WHERE `postId` = ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setString(3, post.getFileUrl());
			pstmt.setString(4, post.getUpdateAt());
			pstmt.setInt(5, postId);
			
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
	
	public int deletePost(int postId) {
		int x = -1;
		String query = 
				"delete from Post where postId = ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  postId);
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
	
	public int postCommentCnt(int postId) {
		int x = 0;
		String query = 
				"select count(*) from Comment where postId = ?";
		try {
			conn = db.getConnection();
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  postId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = rs.getInt(1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) try{conn.close();}catch(SQLException ex){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException ex){}
			if(rs != null) try{rs.close();}catch(SQLException ex){}
		}
		return x;
	}
	
	
	
	
	
	
	
}
