package com.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Comment.commentDTO;
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
	
	public void writePost(String boardId, String p_title, String userRole, String nickName, String userId, String content, String fileUrl, int lookUp, String createAt, String updateAt, String status) {
		String query = 
				"INSERT INTO `DB_sem`.`Post`" + 
				"(" +
					"`boardId`," + 
					"`p_title`," +
					"`userRole`," +
					"`nickName`," + 
					"`userId`," + 
					"`content`," + 
					"`fileUrl`," +
					"`lookUp`," + 
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
					"?," + 
					"?," + 
					"?," + 
					"?" + 
				")";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, boardId);
			pstmt.setString(2, p_title);
			pstmt.setString(3,  userRole);
			pstmt.setString(4, nickName);
			pstmt.setString(5,  userId);
			pstmt.setString(6,  content);
			pstmt.setString(7, fileUrl);
			pstmt.setInt(8, lookUp);
			pstmt.setString(9,  createAt);
			pstmt.setString(10,  updateAt);
			pstmt.setString(11,  status);
			
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
				"select count(*) from Post where boardId = ? and status = '1'";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, boardId);
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
					"`Post`.`p_title`," +
					"`Post`.`userRole`," +
					"`Post`.`nickName`," + 
					"`Post`.`userId`," + 
					"`Post`.`content`," + 
					"`Post`.`fileUrl`," +
					"`Post`.`lookUp`," + 
					"`Post`.`createAt`," + 
					"`Post`.`updateAt`," + 
					"`Post`.`status`" + 
				"FROM `DB_sem`.`Post` where boardId = ? and status = '1' order by createAt desc limit ?,?";
		
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
					post.setP_title(rs.getString("p_title"));
					post.setUserRole(rs.getString("userRole"));
					post.setNickName(rs.getString("nickName"));
					post.setUserId(rs.getString("userId"));
					post.setContent(rs.getString("content"));
					post.setFileUrl(rs.getString("fileUrl"));
					post.setLookUp(rs.getInt("lookUp"));
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
	
public List<commentDTO> getComments() {
		
		List<commentDTO> commentlists = null;
		String query = 
				"SELECT `Comment`.`commentId`," + 
					"`Comment`.`postId`," + 
					"`Comment`.`nickName`," +
					"`Comment`.`userId`," + 
					"`Comment`.`content`," + 
					"`Comment`.`createAt`" + 
				"FROM `DB_sem`.`Comment`";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				commentlists = new ArrayList<commentDTO> ();
				do {
					commentDTO comment = new commentDTO();
					comment.setPostId(rs.getInt("postId"));
					comment.setNickName(rs.getString("nickName"));
					comment.setUserId(rs.getString("userId"));
					comment.setCommentId(rs.getInt("commentId"));
					comment.setContent(rs.getString("content"));
					comment.setCreateAt(rs.getString("CreateAt"));
					
					commentlists.add(comment);
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally{
			if(conn != null) try{conn.close();}catch(SQLException ex){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException ex){}
			if(rs != null) try{rs.close();}catch(SQLException ex){}
			
		}
		return commentlists;
	}
	
	public postDTO viewPost(int postId) {
		postDTO post = null;
		String query = 
				"select * from Post where postId = ?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, postId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				post = new postDTO();
				post.setPostId(rs.getInt("postId"));
				post.setBoardId(rs.getString("boardId"));
				post.setP_title(rs.getString("p_title"));
				post.setUserRole(rs.getString("userRole"));
				post.setNickName(rs.getString("nickName"));
				post.setUserId(rs.getString("userId"));
				post.setContent(rs.getString("content"));
				post.setFileUrl(rs.getString("fileUrl"));
				post.setCreateAt(rs.getString("createAt"));
				post.setUpdateAt(rs.getString("updateAt"));
				post.setStatus(rs.getString("status"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
		return post;
	}
	
	public postDTO readPost(int postId) {
		postDTO post = null;
		String update_query = 
				"update Post set lookUp = lookUp + 1 where postId = ?";
		String select_query = 
				"SELECT `Post`.`postId`," + 
					"`Post`.`boardId`," + 
					"`Post`.`p_title`," +
					"`Post`.`userRole`," +
					"`Post`.`nickName`," + 
					"`Post`.`userId`," + 
					"`Post`.`content`," + 
					"`Post`.`fileUrl`," +
					"`Post`.`lookUp`," + 
					"`Post`.`createAt`," + 
					"`Post`.`updateAt`," + 
					"`Post`.`status`" + 
				"FROM `DB_sem`.`Post` where postId = ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(update_query);
			pstmt.setInt(1,  postId);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(select_query);
			pstmt.setInt(1,  postId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				post = new postDTO();
				post.setPostId(rs.getInt("postId"));
				post.setBoardId(rs.getString("boardId"));
				post.setP_title(rs.getString("p_title"));
				post.setUserRole(rs.getString("userRole"));
				post.setNickName(rs.getString("nickName"));
				post.setUserId(rs.getString("userId"));
				post.setContent(rs.getString("content"));
				post.setFileUrl(rs.getString("fileUrl"));
				post.setLookUp(rs.getInt("lookUp"));
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
	
	public int updatePost(String p_title, String content, String fileUrl, String updateAt, int postId) {
		int x = -1;
		String query = 
				"UPDATE `DB_sem`.`Post`" + 
				"SET" + 
					"`p_title` = ?," + 
					"`content` = ?," + 
					"`fileUrl` = ?," + 
					"`updateAt` = ?" + 
				"WHERE `postId` = ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p_title);
			pstmt.setString(2, content);
			pstmt.setString(3, fileUrl);
			pstmt.setString(4, updateAt);
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
				"UPDATE `DB_sem`.`Post`" + 
				"SET" + 
				"`status` = '0'" + 
				"WHERE `postId` = ?;";
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
