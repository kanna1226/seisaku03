package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.Tasks;

public class RegisterTasksDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/data/workoptimizer";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public boolean registerTasks(Tasks task) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "INSERT INTO TASKS(USER_ID, TASKGROUP_ID, TASK_CONTENT, REGISTER_DATE, TANTATIVE_START_DATETIME,TANTATIVE_END_DATETIME) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, task.getUserId());
			pStmt.setInt(2, task.getTaskGroupId());
			pStmt.setString(3, task.getTaskContent());
			Date registerDate = java.sql.Date.valueOf(task.getRegisterDate());
			pStmt.setDate(4, registerDate);
			Timestamp tenativeStartDateTime = Timestamp.valueOf(task.getTentativeStartDateTime());
			pStmt.setTimestamp(5, tenativeStartDateTime);
			Timestamp tenativeEndDateTime = Timestamp.valueOf(task.getTentativeEndDateTime());
			pStmt.setTimestamp(6, tenativeEndDateTime);
			
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
	
	public boolean updateTasks(Tasks task) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE TASKS SET(START_DATETIME, END_DATETIME) = (?, ?) WHERE TASK_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			Timestamp startDateTime = Timestamp.valueOf(task.getStartDateTime());
			pStmt.setTimestamp(1, startDateTime);
			Timestamp endDateTime = Timestamp.valueOf(task.getEndDateTime());
			pStmt.setTimestamp(2, endDateTime);
			pStmt.setInt(3, task.getTaskId());
			
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

//"INSERT INTO TASKS(TASK_ID, USER_ID, TASKGROUP_ID, TASK_CONTENT, REGISTER_DATE, TENATIVE_START_DATETIME,TENATIVE_END_DATETIME, START_DATETIME, END_DATETIME) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"
