package model;

import java.util.List;

import dao.FindTasksDAO;

public class GetTaskListLogic {
	public List<Tasks> execute(User loginUser) {
		FindTasksDAO dao = new FindTasksDAO();
		List<Tasks> taskList = dao.findTodayRegisterTasks(loginUser);
		return taskList;
	}
}
