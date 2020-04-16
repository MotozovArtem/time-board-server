package com.timeboard.server.domain;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "TaskObserver")
@Table(name = "task_observer")
public class TaskObserver {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;

	@ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "task", nullable = false)
	private Task task;

	@ManyToOne(targetEntity = ProjectUser.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "observer", unique = true, nullable = false)
	private ProjectUser observer;

	public TaskObserver() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public ProjectUser getObserver() {
		return observer;
	}

	public void setObserver(ProjectUser observer) {
		this.observer = observer;
	}
}
