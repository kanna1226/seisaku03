package model;

public class TaskGroup {
	private int taskGroupId;
	private String taskGroupName;
	
	public TaskGroup(int taskGroupId, String taskGroupName) { 
		this.taskGroupId = taskGroupId;
		this.taskGroupName = taskGroupName;
	}
	
	public int taskGroupId() { return taskGroupId; }
	public String taskGropuName() { return taskGroupName; }
}
