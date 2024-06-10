package model;

import dao.RegisterTasksDAO;

public class UpdateTaskLogic {
	public void execute(Tasks task) {
		RegisterTasksDAO dao = new RegisterTasksDAO();
		dao.updateTasks(task);
	}
}
