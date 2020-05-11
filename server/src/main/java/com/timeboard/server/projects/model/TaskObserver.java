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

import org.hibernate.annotations.Type;

@Entity(name = "ProjectTaskObserver")
@Table(name = "task_observer", schema = "public")
public class TaskObserver {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@Type(type = "uuid-char")
	@GeneratedValue
	private UUID id;

	@ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "task", nullable = false)
	private Task task;

	@ManyToOne(targetEntity = ProjectUser.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "observer", unique = true, nullable = false)
	private ProjectUser observer;

	@Version
	@Column(name = "version", nullable = false)
	private Long version;

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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
