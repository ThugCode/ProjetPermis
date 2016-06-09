package hibernate.metier;
// Generated 9 juin 2016 10:42:20 by Hibernate Tools 4.0.0.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Game generated by hbm2java
 */
public class Game implements java.io.Serializable {

	private Integer id;
	private String name;
	private Set missions = new HashSet(0);
	private Set students = new HashSet(0);
	private Set actions = new HashSet(0);

	public Game() {
	}

	public Game(String name, Set missions, Set students, Set actions) {
		this.name = name;
		this.missions = missions;
		this.students = students;
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

	public Set getMissions() {
		return this.missions;
	}

	public void setMissions(Set missions) {
		this.missions = missions;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public Set getActions() {
		return this.actions;
	}

	public void setActions(Set actions) {
		this.actions = actions;
	}

}