package com.project.permis.entities;
// Generated 16 juin 2016 13:42:42 by Hibernate Tools 4.0.0.Final

import java.util.Date;

/**
 * LogLogins generated by hbm2java
 */
public class LogLogins implements java.io.Serializable {

	private Integer id;
	private Student student;
	private Date dateLogin;

	public LogLogins() {
	}

	public LogLogins(Student student, Date dateLogin) {
		this.student = student;
		this.dateLogin = dateLogin;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getDateLogin() {
		return this.dateLogin;
	}

	public void setDateLogin(Date dateLogin) {
		this.dateLogin = dateLogin;
	}

}