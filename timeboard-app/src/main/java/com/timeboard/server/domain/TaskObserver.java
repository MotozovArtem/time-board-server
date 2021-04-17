package com.timeboard.server.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * todo motozov.
 */
@Entity(name = "ProjectTaskObserver")
@Table(name = TaskObserver.TABLE_NAME)
public class TaskObserver extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_task_observer";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {

		/**
		 * todo motozov.
		 */
		public static final String TO_CN_TASK_ID = "task_id";

		/**
		 * todo motozov.
		 */
		public static final String TO_CN_OBSERVER_ID = "observer_id";
	}

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = ColumnName.TO_CN_TASK_ID, nullable = false)
	private Task task;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = ProjectUser.class, fetch = FetchType.LAZY)
	@JoinColumn(name = ColumnName.TO_CN_OBSERVER_ID, unique = true, nullable = false)
	private ProjectUser observer;

	/**
	 * Constructor.
	 */
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
