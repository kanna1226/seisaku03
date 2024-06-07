package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TaskGroup;

public class TaskGroupDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/data/workoptimizer";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	
	public List<TaskGroup> findTaskGroup() {
		List<TaskGroup> taskGroupList = new ArrayList<>();
		
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM TASKGROUP";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int taskGroupId = rs.getInt("TASKGROUP_ID");
				String taskGroupName = rs.getString("TASKGROUP_NAME");
				TaskGroup taskGroup = new TaskGroup(taskGroupId, taskGroupName);
				taskGroupList.add(taskGroup);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return taskGroupList;
	}
	
	public boolean create(TaskGroup taskGroup) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "INSERT INTO TASKGROUP VALUES(?, ?) ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, taskGroup.getTaskGroupId());;
			pStmt.setString(2, taskGroup.getTaskGroupName());
			
			int result = pStmt.executeUpdate();
			
			if(result != 1) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
