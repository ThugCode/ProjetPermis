package com.project.permis;

public class ServiceHibernateException extends AbstractException {

	public ServiceHibernateException(Exception ex, String message) {
		super(ex, message);
	}

	public ServiceHibernateException(Exception ex, String title, String message) {
		super(ex, title, message);
	}
}
