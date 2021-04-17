package com.timeboard.server.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * todo motozov.
 */
@Entity(name = "ProjectTaskCommit")
@Table(name = TaskCommit.TABLE_NAME)
public class TaskCommit extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_task_commit";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {

		/**
		 * todo motozov.
		 */
		public static final String TC_CN_TASK_ID = "task_id";

		/**
		 * todo motozov.
		 */
		public static final String TC_CN_COMMIT_ID = "commit_id";
	}

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = ColumnName.TC_CN_TASK_ID, nullable = false)
	private Task task;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = Commit.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = ColumnName.TC_CN_COMMIT_ID, nullable = false)
	private Commit commit;

	/**
	 * Constructor.
	 */
	public TaskCommit() {
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Commit getCommit() {
		return commit;
	}

	public void setCommit(Commit commit) {
		this.commit = commit;
	}
}
