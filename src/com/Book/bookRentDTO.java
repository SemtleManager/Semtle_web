package com.Book;

public class bookRentDTO {
	private int rentId;
	private int bookId;
	private String userId;
	private String borrowDate;
	private String expiredDate;
	private String status;
	
	public int getRentId() {
		return rentId;
	}
	public int getBookId() {
		return bookId;
	}
	public String getUserId() {
		return userId;
	}
	public String getBorrowDate() {
		return borrowDate;
	}
	public String getExpiredDate() {
		return expiredDate;
	}
	public String getStatus() {
		return status;
	}
	public void setRentId(int rentId) {
		this.rentId = rentId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}
	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
