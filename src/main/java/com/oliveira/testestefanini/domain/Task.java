package com.oliveira.testestefanini.domain;

import java.util.Date;

public class Task {

	private int id;
	private String title;
	private String description;
	private String status;
	private Date dateTask;

	// Construtores
	public Task(String title, String description, String status) {
		this.title = title;
		this.description = description;
		this.status = status;
		this.dateTask = new Date(); // Atribui a data atual
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateTask() {
		return dateTask;
	}

	public void setDateTask(Date dateTask) {
		this.dateTask = dateTask;
	}
}