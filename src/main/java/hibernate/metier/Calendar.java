package hibernate.metier;
// Generated 9 juin 2016 10:42:20 by Hibernate Tools 4.0.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Calendar generated by hbm2java
 */
public class Calendar implements java.io.Serializable {

	private Date date;
	private Set studentActions = new HashSet(0);

	public Calendar() {
	}

	public Calendar(Date date) {
		this.date = date;
	}

	public Calendar(Date date, Set studentActions) {
		this.date = date;
		this.studentActions = studentActions;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set getStudentActions() {
		return this.studentActions;
	}

	public void setStudentActions(Set studentActions) {
		this.studentActions = studentActions;
	}

}
