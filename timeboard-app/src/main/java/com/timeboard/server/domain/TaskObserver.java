package com.timeboard.server.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ProjectTaskObserver")
@Table(name = TaskObserver.TABLE_NAME)
public class TaskObserver extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_task_observer";

	@ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "task", nullable = false)
	private Task task;

	@ManyToOne(targetEntity = ProjectUser.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "observer", unique = true, nullable = false)
	private ProjectUser observer;

	public TaskObserver() {
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
