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
	
	User loginUser = null;
	
	public User findByLogin(Login login) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT USER_ID, PASS, USER_NAME, MAIL, DATEOFBIRTH FROM USERS WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());
			
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String userName = rs.getString("USER_NAME");
				String mail = rs.getString("MAIL");
				Date dateOfBirth_date = rs.getDate("DATEOFBIRTH");
				LocalDate dateOfBirth = dateOfBirth_date.toLocalDate();
				loginUser = new User(userId, pass, userName, mail, dateOfBirth);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return loginUser;
	}
	
	public boolean registerUser(User user) {
		try {
			Class.forName("org.h2.Drier");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO USERS (USER_ID, PASS, USER_NAME, MAIL, DATEOFBIRTH) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			
			
			pStmt.setString(1, user.getUserId());
			pStmt.setString(2, user.getPass());
			pStmt.setString(3, user.getUserName());
			pStmt.setString(4, user.getMail());
			Date dateOfBirth_date = java.sql.Date.valueOf(user.getDateOfBirth());
			pStmt.setDate(5, dateOfBirth_date);
			
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
