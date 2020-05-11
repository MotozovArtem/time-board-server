package com.timeboard.server.projects.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name = "ProjectTaskCommit")
@Table(name = "task_commit", schema = "public")
public class TaskCommit {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue
	private UUID id;

	@ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "task", nullable = false)
	private Task task;

	@ManyToOne(targetEntity = Commit.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "commit", nullable = false)
	private Commit commit;

	@Version
	@Column(name = "version", nullable = false)
	private Long version;

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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
