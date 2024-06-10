package model;

import java.util.List;

import dao.FindTasksDAO;

public class GetTaskListLogic {
	public List<Tasks> getTodayRegisterTasksExecute(User loginUser) {
		FindTasksDAO dao = new FindTasksDAO();
		List<Tasks> taskList = dao.findTodayRegisterTasks(loginUser);
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
