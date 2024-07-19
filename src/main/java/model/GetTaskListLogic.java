package model;

import java.util.List;

import dao.FindTasksDAO;

public class GetTaskListLogic {
	public List<Tasks> getIncompleteTasksExecute(User loginUser) {
		FindTasksDAO dao = new FindTasksDAO();
		List<Tasks> taskList = dao.findIncompleteTasks(loginUser);
		return taskList;
	}
	
	public List<Tasks> getTodayHandleTasksExecute(User loginUser) {
		FindTasksDAO dao = new FindTasksDAO();
		List<Tasks> taskList = dao.findTodayHandleTasks(loginUser);
		return taskList;
	}
	
	public List<Tasks> getTodayEndTasksExecute(User loginUser) {
		FindTasksDAO dao = new FindTasksDAO();
		List<Tasks> taskList = dao.findTodayEndTasks(loginUser);
		return taskList;
	}
	
}
