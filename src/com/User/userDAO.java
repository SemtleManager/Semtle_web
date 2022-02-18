package com.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBDAO;

public class userDAO {

	private static userDAO instance = null;
	//싱글톤 정적변수
	private static DBDAO db = DBDAO.getInstance();
	
	private Connection conn = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;
	
	
	//싱글톤 패턴
	public static userDAO getInstance() {
		if(instance == null)
			instance = new userDAO();
		
		return instance;
	}
	
	//private 로 기본 생성자 차단
	private userDAO() { }
	
	//회원가입 메소드
	public void signUp(int grade, String nickName, int userCode, String userName, String userId, String userPassword, String userEmail, String userPhone, String userRole, String createAt, String updateAt, String status) {
		String query = 
				"INSERT INTO `DB_sem`.`User`" + 
				"(" + 
					"`grade`," +
					"`nickName`," + 
					"`userCode`," +
					"`userName`," + 
					"`userId`," + 
					"`userPassword`," + 
					"`userEmail`," + 
					"`userPhone`," + 
					"`userRole`," + 
					"`createdAt`," + 
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
					"?," + 
					"?" + 
				")"; 
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1,  grade);
			pstmt.setString(2, nickName);
			pstmt.setInt(3,  userCode);
			pstmt.setString(4,  userName);
			pstmt.setString(5,  userId);
			pstmt.setString(6,  userPassword);
			pstmt.setString(7,  userEmail);
			pstmt.setString(8,  userPhone);
			pstmt.setString(9,  userRole);
			pstmt.setString(10,  createAt);
			pstmt.setString(11,  updateAt);
			pstmt.setString(12,  status);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
	}
	
	//사용자 로그인 
	public int login(String id, String passwd) {
		int check = -1;
		String query = 
				"select * from User where userId = ? and userPassword = ?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) 
				check = 1;
			else
				check = 0;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		return check;
	}
	
	//정보 조회
	public userDTO selectInfo(String userId, String userPassword) {
		userDTO user = null;
		String query = 
				"select * from User where userId = ? and userPassword = ?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPassword);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new userDTO();
				user.setGrade(rs.getInt("grade"));
				user.setNickName(rs.getString("nickName"));
				user.setUserCode(rs.getInt("userCode"));
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserPhone(rs.getString("userPhone"));
				user.setUserRole(rs.getString("userRole"));
				user.setStatus(rs.getString("status"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
		return user;
	}
	
	//정보 변경
	public int updateInfo(int grade, String nickName, int userCode, String userName, String userEmail, String userPhone, String status, String updateAt, String userId) {
		int x = -1;
		String query = 
				"UPDATE `DB_sem`.`User`" + 
					"SET" + 
					"`grade` = ?," +
					"`nickName` = ?," + 
					"`userCode` = ?," +
					"`userName` = ?," + 
					"`userEmail` = ?," + 
					"`userPhone` = ?," + 
					"`status` = ?," +
					"`updateAt` = ?" +
				"WHERE `userId` = ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1,  grade);
			pstmt.setString(2, nickName);
			pstmt.setInt(3,  userCode);
			pstmt.setString(4,  userName);
			pstmt.setString(5,  userEmail);
			pstmt.setString(6,  userPhone);
			pstmt.setString(7,  status);
			pstmt.setString(8,  updateAt);
			pstmt.setString(9,  userId);
			
			pstmt.executeUpdate();
			x = 1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
		return x;
	}
	
	//ID 중복체크
	public int confirmId(String id) {
		int x = -1;
		String query = 
				"select userId from User where userId = ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = 1;   //중복
			else
				x = -1;  //사용 가능
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		return x;
	}
	
	//비밀번호 변경
	public int changePassword(String id, String passwd) {
		int x = -1;
		String query =
				"update User set userPassword = ? where userId = ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, passwd);
			pstmt.setString(2, id);
			
			pstmt.executeUpdate();
			x = 1;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
		return x;
	}
	
	//아이디 찾기
	public String findUserId(String userName, int grade, int userCode) {
		String id = "";
		String query = 
				"select userId from User where userName = ? and grade = ? and userCode = ?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setInt(2, grade);
			pstmt.setInt(3,  userCode);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) 
				id = rs.getString("userId");
			else
				id = null;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
		return id;
	}
	
	//<관리자> 회원수 조회
	public int getUserCnt() {
		int cnt = 0;
		
		String query = 
				"select count(*) from User";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				cnt = rs.getInt(1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
		return cnt;
	}
	
	//<관리자>사용자 목록 출력
	public List<userDTO> getUserList(int start, int end) {
		List<userDTO> userlists = null;
		String query = 
				"SELECT `User`.`grade`," +
					"`User`.`nickName`," + 
					"`User`.`userName`," + 
					"`User`.`userId`," + 
					"`User`.`userPassword`," + 
					"`User`.`userEmail`," + 
					"`User`.`userPhone`," + 
					"`User`.`userRole`," + 
					"`User`.`createdAt`," + 
					"`User`.`updateAt`," + 
					"`User`.`status`" + 
				"FROM `DB_sem`.`User` order by createdAt desc limit ?,?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1,  start - 1);
			pstmt.setInt(2,  end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userlists = new ArrayList<userDTO> (end);
				do {
					userDTO article = new userDTO();
					article.setGrade(rs.getInt("grade"));
					article.setNickName(rs.getString("nickName"));
					article.setUserName(rs.getString("userName"));
					article.setUserCode(rs.getInt("userCode"));
					article.setUserId(rs.getString("userId"));
					article.setUserPassword(rs.getString("userPassword"));
					article.setUserEmail(rs.getString("userEmail"));
					article.setUserPhone(rs.getString("userPhone"));
					article.setUserRole(rs.getString("userRole"));
					article.setCreateAt(rs.getString("createdAt"));
					article.setUpdateAt(rs.getString("updateAt"));
					article.setStatus(rs.getString("status"));
					
					userlists.add(article);
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException ex ) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
		return userlists;
	}
	
}
