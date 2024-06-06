package model;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
	private String userId;
	private String pass;
	private String mail;
	private String userName;
	private LocalDate dateOfBirth;
	
	public User() {}
	public User(String userId, String pass,String mail, String userName, LocalDate dateOfBirth) {
		this.userId = userId;
		this.pass = pass;
		this.mail = mail;
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getUserId() { return userId; }
	public String getPass() { return pass; }
	public String getUserName()  { return userName; }
	public String getMail() { return mail; }
	public LocalDate getDateOfBirth() { return dateOfBirth; }
}
