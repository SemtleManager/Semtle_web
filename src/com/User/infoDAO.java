package com.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Book.bookListDTO;
import com.Comment.commentDTO;
import com.DB.DBDAO;
import com.Post.postDTO;

public class infoDAO {

	private static infoDAO instance = null;

	private static DBDAO db = DBDAO.getInstance();

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 싱글톤 패턴
	public static infoDAO getInstance() {
		if (instance == null)
			instance = new infoDAO();

		return instance;
	}

	// private 로 기본 생성자 차단
	private infoDAO() {
	}

	// 서브 쿼리 안됌
	public infoDTO getCnt(String userId) {
		infoDTO info = null;
		String query = "select a.BookCnt, b.PostCnt, c.CommentCnt"
				+ "from (select count(*) BookCnt from BookList where userId = 'zxz4641') a,"
				+ "(select count(*) PostCnt from Post where userId = 'zxz4641') b,"
				+ "(select count(*) CommentCnt from `Comment` where userId = 'zxz4641') c";

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			/*
			 * pstmt.setString(1, userId); pstmt.setString(2, userId); pstmt.setString(3,
			 * userId);
			 */

			rs = pstmt.executeQuery();

			if (rs.next()) {
				info = new infoDTO();
				info.setBookCnt(rs.getInt("BookCnt"));
				info.setPostCnt(rs.getInt("PostCnt"));
				info.setCommentCnt(rs.getInt("CommentCnt"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return info;
	}

	public int getPostCnt(String userId) {
		int x = 0;
		String query = "select count(*) from Post where userId = ?";
		try {
			conn = db.getConnection();

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	public int getBookCnt(String userId) {
		int x = 0;
		String query = "select count(*) from BookList where userId = ?";
		try {
			conn = db.getConnection();

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	public int getCommentCnt(String userId) {
		int x = 0;
		String query = "select count(*) from `Comment` where userId = ?";
		try {
			conn = db.getConnection();

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	public int getInfoPostCount(String userId) {
		int x = 0;
		String query = "select count(*) from Post where userId = ? and status = '1'";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next())
				x = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
		}
		return x;

	}

public List<postDTO> getPosts(String boardId, String userId, int start, int end) {
		
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
				"FROM `DB_sem`.`Post` where boardId = ? and userId = ? and status = '1' order by createAt desc limit ?,?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, boardId);
			pstmt.setString(2, userId);
			pstmt.setInt(3,  start - 1);
			pstmt.setInt(4,  end);
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

	public List<bookListDTO> getInfoBookList(String userId) {
		List<bookListDTO> booklists = null;
		String query = "SELECT `BookList`.`bookId`," + "`BookList`.`bookName`," + "`BookList`.`bookAuthor`,"
				+ "`BookList`.`bookImage`," + "`BookList`.`bookCount`," + "`BookList`.`createAt`,"
				+ "`BookList`.`updateAt`," + "`BookList`.`status`," + "`BookList`.`userId`"
				+ "FROM `DB_sem`.`BookList` where userId = ? order by bookName asc";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				booklists = new ArrayList<bookListDTO>();
				do {
					bookListDTO book = new bookListDTO();
					book.setBookId(rs.getInt("bookId"));
					book.setBookName(rs.getString("bookName"));
					book.setBookAuthor(rs.getString("bookAuthor"));
					book.setBookImage(rs.getString("bookImage"));
					book.setBookCount(rs.getInt("bookCount"));
					book.setCreateAt(rs.getString("createAt"));
					book.setUpdateAt(rs.getString("updateAt"));
					book.setStatus(rs.getString("status"));
					book.setUserId(rs.getString("userId"));
					booklists.add(book);
				} while (rs.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
		}
		return booklists;
	}

	public List<commentDTO> getComments() {

		List<commentDTO> commentlists = null;
		String query = "SELECT `Comment`.`commentId`," + "`Comment`.`postId`," + "`Comment`.`nickName`,"
				+ "`Comment`.`userId`," + "`Comment`.`content`," + "`Comment`.`createAt`" + "FROM `DB_sem`.`Comment`";

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				commentlists = new ArrayList<commentDTO>();
				do {
					commentDTO comment = new commentDTO();
					comment.setPostId(rs.getInt("postId"));
					comment.setNickName(rs.getString("nickName"));
					comment.setUserId(rs.getString("userId"));
					comment.setCommentId(rs.getInt("commentId"));
					comment.setContent(rs.getString("content"));
					comment.setCreateAt(rs.getString("CreateAt"));

					commentlists.add(comment);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}

		}
		return commentlists;
	}

	public int getPostCount(String boardId, String userId) {
		int x = 0;
		String query = "select count(*) from Post where boardId = ? and userId = ? and status = '1'";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, boardId);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			if (rs.next())
				x = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
		}
		return x;

	}

}
