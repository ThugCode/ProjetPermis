package com.project.permis.entities;
// Generated 26 juin 2016 14:31:07 by Hibernate Tools 4.0.0.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Student generated by hbm2java
 */
public class Student implements java.io.Serializable {

	private Integer id;
	private String lastname;
	private String firstname;
	private String mail;
	private String password;
	private boolean isEnabled;
	private boolean isAdmin;
	private Set games = new HashSet(0);
	private Set logLoginses = new HashSet(0);
	private Set messages = new HashSet(0);
	private Set studentActions = new HashSet(0);

	public Student() {
	}

	public Student(String mail, String password, boolean isEnabled, boolean isAdmin) {
		this.mail = mail;
		this.password = password;
		this.isEnabled = isEnabled;
		this.isAdmin = isAdmin;
	}

	public Student(String lastname, String firstname, String mail, String password, boolean isEnabled, boolean isAdmin,
			Set games, Set logLoginses, Set messages, Set studentActions) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.mail = mail;
		this.password = password;
		this.isEnabled = isEnabled;
		this.isAdmin = isAdmin;
		this.games = games;
		this.logLoginses = logLoginses;
		this.messages = messages;
		this.studentActions = studentActions;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public boolean isIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Set getGames() {
		return this.games;
	}

	public void setGames(Set games) {
		this.games = games;
	}

	public Set getLogLoginses() {
		return this.logLoginses;
	}

	public void setLogLoginses(Set logLoginses) {
		this.logLoginses = logLoginses;
	}

	public Set getMessages() {
		return this.messages;
	}

	public void setMessages(Set messages) {
		this.messages = messages;
	}

	public Set getStudentActions() {
		return this.studentActions;
	}

	public void setStudentActions(Set studentActions) {
		this.studentActions = studentActions;
	}

}
