package com.capg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users_detail")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uId;

	private String emailId;

	private String password;

	private String securityAnswer;

	private String role;

	public User() {
		super();
	}

	public User(Integer uId, String emailId, String password, String securityAnswer, String role) {
		super();
		this.uId = uId;
		this.emailId = emailId;
		this.password = password;
		this.securityAnswer = securityAnswer;
		this.role = role;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", emailId=" + emailId + ", password=" + password + ", securityAnswer="
				+ securityAnswer + "]";
	}

}
