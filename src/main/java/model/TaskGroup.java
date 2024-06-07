package model;

import java.io.Serializable;

public class TaskGroup implements Serializable {
	private int taskGroupId;
	private String taskGroupName;
	
	public TaskGroup() {}
	public TaskGroup(int taskGroupId, String taskGroupName) { 
		this.taskGroupId = taskGroupId;
		this.taskGroupName = taskGroupName;
	}
	
	public int getTaskGroupId() { return taskGroupId; }
	public String getTaskGroupName() { return taskGroupName; }
}
