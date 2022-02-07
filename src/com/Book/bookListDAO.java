package com.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBDAO;

public class bookListDAO {
	
	private static bookListDAO instance = null;
	//싱글톤 정적변수
	private static DBDAO db = DBDAO.getInstance();
	
	private Connection conn = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;
	
	
	//싱글톤 패턴
	public static bookListDAO getInstance() {
		if(instance == null)
			instance = new bookListDAO();
		
		return instance;
	}
	
	//private 로 기본 생성자 차단
	private bookListDAO() { }
	
	public void registeredBook(bookListDTO article) {
		String query =
				"INSERT INTO `DB_sem`.`BookList`" + 
				"(" + 
					"`bookName`," + 
					"`bookAuthor`," + 
					"`bookImage`," + 
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
					"?" + 
				")";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, article.getBookName());
			pstmt.setString(2, article.getBookAuthor());
			pstmt.setString(3, article.getBookImage());
			pstmt.setString(4, article.getCreateAt());
			pstmt.setString(5, article.getUpdateAt());
			pstmt.setString(6, article.getStatus());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
	}
	
	public List<bookListDTO> getBookList() {
		List<bookListDTO> booklists = null;
		String query = 
				"SELECT " + 
					"`BookList`.`bookName`," + 
					"`BookList`.`bookAuthor`," + 
					"`BookList`.`bookImage`," + 
					"`BookList`.`status`" + 
				"FROM `DB_sem`.`BookList` order by bookName desc";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				booklists = new ArrayList<bookListDTO>();
				do {
					bookListDTO book = new bookListDTO();
					book.setBookName(rs.getString("bookName"));
					book.setBookAuthor(rs.getString("bookAuthor"));
					book.setBookImage(rs.getString("bookImage"));
					book.setStatus(rs.getString("status"));
					booklists.add(book);
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		return booklists;
	}
	
	public bookListDTO selectBook(String bookId) {
		bookListDTO book = null;
		String query = 
				"SELECT `BookList`.`bookId`," + 
					"`BookList`.`bookName`," + 
					"`BookList`.`bookAuthor`," + 
					"`BookList`.`bookImage`," +
					"`BookList`.`bookCount`," + 
					"`BookList`.`createAt`," + 
					"`BookList`.`updateAt`,"+ 
					"`BookList`.`status`" + 
				"FROM `DB_sem`.`BookList` order by bookName desc";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				book = new bookListDTO();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuthor(rs.getString("bookAuthor"));
				book.setBookImage(rs.getString("bookImage"));
				book.setBookCount(rs.getInt("bookCount"));
				book.setCreateAt(rs.getString("createAt"));
				book.setUpdateAt(rs.getString("updateAt"));
				book.setStatus(rs.getString("status"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		return book;
	}
	
	public int deleteBook(int bookId) {
		int x = -1;
		String query = 
				"delete from BookList where bookId = ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
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
