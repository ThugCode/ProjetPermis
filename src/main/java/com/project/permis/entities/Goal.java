package com.project.permis.entities;
// Generated 15 juin 2016 14:18:02 by Hibernate Tools 4.0.0.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Goal generated by hbm2java
 */
public class Goal implements java.io.Serializable {

	private Integer id;
	private String name;
	private Set actions = new HashSet(0);
	private Set missions = new HashSet(0);

	public Goal() {
	}

	public Goal(String name, Set actions, Set missions) {
		this.name = name;
		this.actions = actions;
		this.missions = missions;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getActions() {
		return this.actions;
	}

	public void setActions(Set actions) {
		this.actions = actions;
	}

	public Set getMissions() {
		return this.missions;
	}

	public void setMissions(Set missions) {
		this.missions = missions;
	}

}
