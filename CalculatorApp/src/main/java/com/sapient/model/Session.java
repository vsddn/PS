package com.sapient.date_time_calculator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name="Records")
@ApiModel(description="Stores the record in database")
public class Session {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long primary_key;
	
	@Column(name="session_id")
	long session_id;

	@Column(name="date1")
	String date1;
	
	@Column(name="query")
	String query;
	
	@Column(name="date2")
	String date2;
	
	
	public Session() {
		super();
	}
	public Session(long session_id, String date1,String date2, String query) {
		super();
		this.date1 = date1;
		this.date2 = date2;
		this.session_id = session_id;
		this.query = query;
	}
	
	public Session(long session_id, String query) {
		super();
		this.session_id = session_id;
		this.query = query;
	}
	public Session(long session_id,String date1, String query) {
		super();
		this.session_id = session_id;
		this.query = query;
		this.date1 = date1;
	}
	public long getSession_id() {
		return session_id;
	}
	public void setSession_id(long sessionId) {
		this.session_id = sessionId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	
}
