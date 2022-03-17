package com.Book;

public class bookListDTO {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String bookImage;
	private int bookCount;
	private String createAt;
	private String updateAt;
	private String status;
	private String userId;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBookId() {
		return bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public String getBookImage() {
		return bookImage;
	}
	public String getCreateAt() {
		return createAt;
	}
	public String getUpdateAt() {
		return updateAt;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
