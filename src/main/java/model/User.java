package model;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
	private String userId;
	private String pass;
	private String userName;
	private String mail;
	private LocalDate dateOfBirth;
	
	public User() {}
	public User(String userId, String pass, String userName, String mail, LocalDate dateOfBirth) {
		this.userId = userId;
		this.pass = pass;
		this.userName = userName;
		this.mail = mail;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getUserId() { return userId; }
	public String getPass() { return pass; }
	public String getUserName()  { return userName; }
	public String getMail() { return mail; }
	public LocalDate getDateOfBirth() { return dateOfBirth; }
}
