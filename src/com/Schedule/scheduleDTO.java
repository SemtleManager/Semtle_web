package com.Schedule;

public class scheduleDTO {
	
	private int scheduleId;
	private String scheduleMonth;
	private String scheduleDay;
	private String scheduleName;
	private String scheduleContent;
	private String createAt;
	private String updateAt;
	
	public int getScheduleId() {
		return scheduleId;
	}
	public String getScheduleMonth() {
		return scheduleMonth;
	}
	public String getScheduleDay() {
		return scheduleDay;
	}
	public String getScheduleName() {
		return scheduleName;
	}
	public String getScheduleContent() {
		return scheduleContent;
	}
	public String getCreateAt() {
		return createAt;
	}
	public String getUpdateAt() {
		return updateAt;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public void setScheduleMonth(String scheduleMonth) {
		this.scheduleMonth = scheduleMonth;
	}
	public void setScheduleDay(String scheduleDay) {
		this.scheduleDay = scheduleDay;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}
	
	
	
	
}
