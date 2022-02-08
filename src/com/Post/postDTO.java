package com.Post;

public class postDTO {
	private int postId;
	private String boardId;
	private String title;
	private String userId;
	private String content;
	private String fileUrl;
	private int lookUp;
	private String createAt;
	private String updateAt;
	private String status;
	
	
	public int getPostId() {
		return postId;
	}
	public String getBoardId() {
		return boardId;
	}
	public String getTitle() {
		return title;
	}
	public String getUserId() {
		return userId;
	}
	public String getContent() {
		return content;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public String getCreateAt() {
		return createAt;
	}
	public String getUpdateAt() {
		return updateAt;
	}
	public int getLookUp() {
		return lookUp;
	}
	public void setLookUp(int lookUp) {
		this.lookUp = lookUp;
	}
	public String getStatus() {
		return status;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
