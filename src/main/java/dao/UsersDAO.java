package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Login;
import model.User;

public class UsersDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/data/workoptimizer";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public User findByLogin(Login login) {
		User user = null;
		
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "SELECT USER_ID, PASS, MAIL, USER_NAME, DATEOFBIRTH FROM USERS WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());
			
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String userName = rs.getString("USER_NAME");
				Date dateOfBirth_sql = rs.getDate("DATEOFBIRTH");
				LocalDate dateOfBirth = dateOfBirth_sql.toLocalDate();
				user = new User(userId, pass, mail, userName, dateOfBirth);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
	public boolean registerUser(User user) {
		
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "INSERT INTO USERS(USER_ID, PASS, MAIL, USER_NAME, DATEOFBIRTH) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserId());
			pStmt.setString(2, user.getPass());
			pStmt.setString(3, user.getMail());
			pStmt.setString(4, user.getUserName());
			Date dateOfBirth_sql = java.sql.Date.valueOf(user.getDateOfBirth());
			pStmt.setDate(5, dateOfBirth_sql);
			
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
	
	public User findRegisterdUser(User user) {
		User registerdUser = null;
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserId());
			
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String userName = rs.getString("USER_NAME");
				Date dateOfBirth_sql = rs.getDate("DATEOFBIRTH");
				LocalDate dateOfBirth = dateOfBirth_sql.toLocalDate();
				user = new User(userId, pass, mail, userName, dateOfBirth);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return registerdUser;
	}

}
