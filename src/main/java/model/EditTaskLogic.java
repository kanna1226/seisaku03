package model;

import dao.EditTasksDAO;

public class EditTaskLogic {
	public void execute(Tasks task) {
		EditTasksDAO dao = new EditTasksDAO();
		dao.editTasks(task);
	}
}
