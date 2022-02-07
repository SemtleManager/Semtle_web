package com.Comment;

public class commentDTO {
	
	private int commentId;
	private String postId;
	private String userId;
	private String content;
	private String createAt;
	private String updateAt;
	
	public int getCommentId() {
		return commentId;
	}
	public String getPostId() {
		return postId;
	}
	public String getUserId() {
		return userId;
	}
	public String getContent() {
		return content;
	}
	public String getCreateAt() {
		return createAt;
	}
	public String getUpdateAt() {
		return updateAt;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}
	
	
	
}
