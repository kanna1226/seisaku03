package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Tasks;
import model.User;


public class FindTasksDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/data/workoptimizer";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Tasks> findTodayRegisterTasks(User loginUser) {
		List<Tasks> taskList = new ArrayList<>();
		
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM TASKS WHERE USER_ID = ? AND REGISTER_DATE = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginUser.getUserId());
			LocalDate today_LocalDate = LocalDate.now();
			Date today = java.sql.Date.valueOf(today_LocalDate);
			pStmt.setDate(2, today);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int taskId = rs.getInt("TASK_ID");
				String userId = rs.getString("USER_ID");
				int taskGroupId = rs.getInt("TASKGROUP_ID");
				String taskContent = rs.getString("TASK_CONTENT");
				Date registerDate_sql = rs.getDate("REGISTER_DATE");
				LocalDate registerDate = registerDate_sql.toLocalDate();
				Timestamp tentativeStartDateTime_sql = rs.getTimestamp("TANTATIVE_START_DATETIME");
				LocalDateTime tentativeStartDateTime = tentativeStartDateTime_sql.toLocalDateTime();
				Timestamp tentativeEndDateTime_sql = rs.getTimestamp("TANTATIVE_END_DATETIME");
				LocalDateTime tentativeEndDateTime = tentativeEndDateTime_sql.toLocalDateTime();
				Timestamp StartDateTime_sql = rs.getTimestamp("START_DATETIME");
				LocalDateTime startDateTime = null;
				if(StartDateTime_sql != null) {
					startDateTime = StartDateTime_sql.toLocalDateTime();
				}
				Timestamp endDateTime_sql = rs.getTimestamp("END_DATETIME");
				LocalDateTime endDateTime = null;
				if(endDateTime_sql != null) {
					endDateTime = endDateTime_sql.toLocalDateTime();
				}
				Tasks task = new Tasks(taskId, userId, taskGroupId, taskContent, registerDate, tentativeStartDateTime, tentativeEndDateTime, startDateTime, endDateTime);
				taskList.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return taskList;
	}
	
	
}
