package com.Post;

public class postDTO {
	private int postId;
	private String boardId;
	private String p_title;
	private String userRole;
	private String nickName;
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
	public String getP_title() {
		return p_title;
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
	public void setP_title(String p_title) {
		this.p_title = p_title;
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
	
}
