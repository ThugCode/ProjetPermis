package com.project.permis.entities;
// Generated 26 juin 2016 14:31:07 by Hibernate Tools 4.0.0.Final

/**
 * Configuration generated by hbm2java
 */
public class Configuration implements java.io.Serializable {

	private Integer id;
	private String name;
	private String value;

	public Configuration() {
	}

	public Configuration(String name, String value) {
		this.name = name;
		this.value = value;
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
