package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Tasks;

public class EditTasksDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/data/workoptimizer";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public boolean editTasks(Tasks task) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "UPDATE TASKS SET TASKGROUP_ID = ?, TASK_CONTENT = ?, TENTATIVE_START_DATE = ?, TENTATIVE_END_TIME = ? WHERE TASK_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, task.getTaskGroupId());
			pStmt.setString(2, task.getTaskContent());
			Date editTentativeStartDate = java.sql.Date.valueOf(task.getTentativeStartDate());
			pStmt.setDate(3, editTentativeStartDate);
			pStmt.setLong(4, task.getTentativeEndTime());
			pStmt.setInt(5, task.getTaskId());
			
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
