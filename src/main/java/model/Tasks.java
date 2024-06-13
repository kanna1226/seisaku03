package model;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tasks implements Serializable {
	private int taskId;
	private String userId;
	private int taskGroupId;
	private String taskContent;
	private LocalDate registerDate;
	private LocalDate tentativeStartDate;
	private long tentativeEndTime;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private Duration taskHandleDuration;
	
	public Tasks() {}
	public Tasks(String userId, int taskGroup, String taskContent, LocalDate tentativeStartDate, long tentativeEndTime) {
		this.userId = userId;
		this.taskGroupId = taskGroup;
		this.taskContent = taskContent;
		this.registerDate = LocalDate.now();
		this.tentativeStartDate = tentativeStartDate;
		this.tentativeEndTime = tentativeEndTime;
	}
	public Tasks(int taskId, String userId, int taskGroup, String taskContent, LocalDate registerDate,
			LocalDate tentativeStartDate, long tentativeEndTime, LocalDateTime startDateTime, LocalDateTime endDateTime) {
		this.taskId = taskId;
		this.userId = userId;
		this.taskGroupId = taskGroup;
		this.taskContent = taskContent;
		this.registerDate = registerDate;
		this.tentativeStartDate = tentativeStartDate;
		this.tentativeEndTime = tentativeEndTime;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
	}
	
	public int getTaskId() { return taskId; }
	public String getUserId() { return userId; }
	public int getTaskGroupId() { return taskGroupId; }
	public String getTaskContent() { return taskContent; }
	public LocalDate getRegisterDate() { return registerDate; }
	public LocalDate getTentativeStartDate() { return tentativeStartDate; }
	public long getTentativeEndTime() { return tentativeEndTime; }
	public LocalDateTime getStartDateTime() { return startDateTime; }
	public LocalDateTime getEndDateTime() { return endDateTime; }
	public Duration getTaskhandleDuration() { return taskHandleDuration; }
	
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	public void setTaskHandleDuration(Duration taskHandleDuration) {
		this.taskHandleDuration = taskHandleDuration;
	}
 

}
