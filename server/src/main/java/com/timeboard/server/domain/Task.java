package com.timeboard.server.domain;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Task")
@Table(name = "task")
public class Task {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;

	@Column(name = "number", unique = true, nullable = false)
	private Integer number;

	@Column(name = "full_code", unique = true, nullable = false)
	private String fullCode;

	@Column(name = "creation_date", unique = true, nullable = false)
	private ZonedDateTime creationDate;

	@Column(name = "done_date", unique = true, nullable = false)
	private ZonedDateTime doneDate;

	@Column(name = "last_modified_date", unique = true, nullable = false)
	private ZonedDateTime lastModifiedDate;

	@Column(name = "description", unique = true, nullable = false)
	private String description;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "project", unique = true, nullable = false)
	private ProjectDashboard project;

	@Column(name = "step", unique = true, nullable = false)
	private Step step;

	@Column(name = "group_task", unique = true, nullable = false)
	private GroupTask groupTask;

	@Column(name = "executor", unique = true, nullable = false)
	private ProjectUser executor;

	@Column(name = "reporter", unique = true, nullable = false)
	private ProjectUser reporter;

	public Task() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getFullCode() {
		return fullCode;
	}

	public void setFullCode(String fullCode) {
		this.fullCode = fullCode;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public ZonedDateTime getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(ZonedDateTime doneDate) {
		this.doneDate = doneDate;
	}

	public ZonedDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProjectDashboard getProject() {
		return project;
	}

	public void setProject(ProjectDashboard project) {
		this.project = project;
	}

	public Step getStep() {
		return step;
	}

	public void setStep(Step step) {
		this.step = step;
	}

	public GroupTask getGroupTask() {
		return groupTask;
	}

	public void setGroupTask(GroupTask groupTask) {
		this.groupTask = groupTask;
	}

	public ProjectUser getExecutor() {
		return executor;
	}

	public void setExecutor(ProjectUser executor) {
		this.executor = executor;
	}

	public ProjectUser getReporter() {
		return reporter;
	}

	public void setReporter(ProjectUser reporter) {
		this.reporter = reporter;
	}
}
