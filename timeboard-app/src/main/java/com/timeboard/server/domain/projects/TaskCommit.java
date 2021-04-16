package com.timeboard.server.domain.projects;

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

import org.hibernate.annotations.Type;

@Entity(name = "ProjectTaskCommit")
@Table(name = "task_commit")
public class TaskCommit {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@Type(type = "uuid-char")
	@GeneratedValue
	private UUID id;

	@ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "task", nullable = false)
	private Task task;

	@ManyToOne(targetEntity = Commit.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "commit", nullable = false)
	private Commit commit;

	@Version
	@Column(name = "ts", nullable = false)
	private Long ts;

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

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}
}
