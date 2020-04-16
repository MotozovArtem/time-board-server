package com.timeboard.server.domain;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "TaskCommit")
@Table(name = "task_commit")
public class TaskCommit {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;

	@ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "task", nullable = false)
	private Task task;

	@ManyToOne(targetEntity = Commit.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "commit", nullable = false)
	private Commit commit;

	public TaskCommit() {
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

	public Commit getCommit() {
		return commit;
	}

	public void setCommit(Commit commit) {
		this.commit = commit;
	}
}
