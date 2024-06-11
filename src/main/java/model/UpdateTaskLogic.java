package model;

import dao.RegisterTasksDAO;

public class UpdateTaskLogic {
	public void updateStartDateTimeExecute(Tasks task) {
		RegisterTasksDAO dao = new RegisterTasksDAO();
		dao.updateStartDateTimeTasks(task);
	}
	
	public void updateEndDateTimeExecute(Tasks task) {
		RegisterTasksDAO dao = new RegisterTasksDAO();
		dao.updateEndDateTimeTasks(task);
	}
}
