package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Tasks implements Serializable {
	private int taskId;
	private String userId;
	private int taskGroupId;
	private String taskContent;
	private LocalDate registerDate;
	private LocalDateTime tentativeStartDateTime;
	private LocalDateTime tentativeEndDateTime;
	private Date tentativeEndDate;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	
	public Tasks() {}
	public Tasks(String userId, int taskGroup, String taskContent, LocalDateTime tentativeStartDateTime, LocalDateTime tentativeEndDateTime, Date tentativeEndDate) {
		this.userId = userId;
		this.taskGroupId = taskGroup;
		this.taskContent = taskContent;
		this.registerDate = LocalDate.now();
		this.tentativeStartDateTime = tentativeStartDateTime;
		this.tentativeEndDateTime = tentativeEndDateTime;
		this.tentativeEndDate = tentativeEndDate;
		
	}
	public Tasks(int taskId, String userId, int taskGroup, String taskContent, LocalDate registerDate,
			LocalDateTime tentativeStartDateTime, LocalDateTime tentativeEndDateTime, Date tentativeEndDate,
			LocalDateTime startDateTime, LocalDateTime endDateTime) {
		this.taskId = taskId;
		this.userId = userId;
		this.taskGroupId = taskGroup;
		this.taskContent = taskContent;
		this.registerDate = registerDate;
		this.tentativeStartDateTime = tentativeStartDateTime;
		this.tentativeEndDateTime = tentativeEndDateTime;
		this.tentativeEndDate = tentativeEndDate;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
	}
	
	public int getTaskId() { return taskId; }
	public String getUserId() { return userId; }
	public int getTaskGroupId() { return taskGroupId; }
	public String getTaskContent() { return taskContent; }
	public LocalDate getRegisterDate() { return registerDate; }
	public LocalDateTime getTentativeStartDateTime() { return tentativeStartDateTime; }
	public LocalDateTime getTentativeEndDateTime() { return tentativeEndDateTime; }
	public Date getTentativeEndDate() { return tentativeEndDate; }
	public LocalDateTime getStartDateTime() { return startDateTime; }
	public LocalDateTime getEndDateTime() { return endDateTime; }
 

}
