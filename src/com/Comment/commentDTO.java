package com.Comment;

public class commentDTO {
	
	private int commentId;
	private int postId;
	private String nickName;
	private String userId;
	private String content;
	private String createAt;
	
	public int getCommentId() {
		return commentId;
	}
	public int getPostId() {
		return postId;
	}

	public String getContent() {
		return content;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
