package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tasks implements Serializable {
	private int taskId;
	private String userId;
	private int taskGroupId;
	private String taskContent;
	private LocalDate registerDate;
	private LocalDateTime tentativeStartDateTime;
	private LocalDateTime tentativeEndDateTime;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	
	public Tasks() {}
	public Tasks(int taskId, String userId, int taskGroup, String taskContent
			,LocalDateTime tentativeStartDateTime, LocalDateTime tentativeEndDateTime) {
		this.taskId = taskId;
		this.userId = userId;
		this.taskGroupId = taskGroup;
		this.taskContent = taskContent;
		this.registerDate = LocalDate.now();
		this.tentativeStartDateTime = tentativeStartDateTime; //変更いるかも
		this.tentativeEndDateTime = tentativeEndDateTime; //変更いるかも
		
	}
	public Tasks(int taskId, String userId, int taskGroup, String taskContent, LocalDate registerDate,
			LocalDateTime tentativeStartDateTime, LocalDateTime tentativeEndDateTime,
			LocalDateTime startDateTime, LocalDateTime endDateTime) {
		this.taskId = taskId;
		this.userId = userId;
		this.taskGroupId = taskGroup;
		this.taskContent = taskContent;
		this.registerDate = registerDate;
		this.tentativeStartDateTime = tentativeStartDateTime;
		this.tentativeEndDateTime = tentativeEndDateTime;
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
	public LocalDateTime getStartDateTime() { return startDateTime; }
	public LocalDateTime getEndDateTime() { return endDateTime; }
 

}
