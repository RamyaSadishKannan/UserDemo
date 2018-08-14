package com.example.User.UserDemo.model.dto;

import java.util.Date;

public class User {

	private long id;
	private String name;
	private Date date;

	public User() {

	}

	public User(long id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, date=%s]", id, name, date);
	}

}
