package com.project.permis.entities;
// Generated 16 juin 2016 13:42:42 by Hibernate Tools 4.0.0.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Rule generated by hbm2java
 */
public class Rule implements java.io.Serializable {

	private Integer id;
	private String name;
	private Integer minimumScore;
	private Set actions = new HashSet(0);

	public Rule() {
	}

	public Rule(String name, Integer minimumScore, Set actions) {
		this.name = name;
		this.minimumScore = minimumScore;
		this.actions = actions;
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

	public Integer getMinimumScore() {
		return this.minimumScore;
	}

	public void setMinimumScore(Integer minimumScore) {
		this.minimumScore = minimumScore;
	}

	public Set getActions() {
		return this.actions;
	}

	public void setActions(Set actions) {
		this.actions = actions;
	}

}
