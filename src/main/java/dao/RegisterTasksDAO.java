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
			
			String sql = "INSERT INTO TASKS(USER_ID, TASKGROUP_ID, TASK_CONTENT, REGISTER_DATE, TENTATIVE_START_DATE,TENTATIVE_END_TIME) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, task.getUserId());
			pStmt.setInt(2, task.getTaskGroupId());
			pStmt.setString(3, task.getTaskContent());
			Date registerDate = java.sql.Date.valueOf(task.getRegisterDate());
			pStmt.setDate(4, registerDate);
			Date tenativeStartDate = java.sql.Date.valueOf(task.getTentativeStartDate());
			pStmt.setDate(5, tenativeStartDate);
			long tenativeEndTime = task.getTentativeEndTime();
			pStmt.setLong(6, tenativeEndTime);
			
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
	
	public boolean updateStartDateTimeTasks(Tasks task) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE TASKS SET(START_DATETIME) = (?) WHERE TASK_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			Timestamp startDateTime = Timestamp.valueOf(task.getStartDateTime());
			pStmt.setTimestamp(1, startDateTime);
			pStmt.setInt(2, task.getTaskId());
			
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
	
	public boolean updateEndDateTimeTasks(Tasks task) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE TASKS SET(END_DATETIME) = (?) WHERE TASK_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			Timestamp endDateTime = Timestamp.valueOf(task.getEndDateTime());
			pStmt.setTimestamp(1, endDateTime);
			pStmt.setInt(2, task.getTaskId());
			
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
