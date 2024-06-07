package model;

import dao.RegisterTasksDAO;

public class PostTaskLogic {
	public void execute(Tasks task) {
		RegisterTasksDAO dao = new RegisterTasksDAO();
		dao.registerTasks(task);
	}
}
