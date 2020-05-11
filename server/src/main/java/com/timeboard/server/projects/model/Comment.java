package com.timeboard.server.projects.model;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ProjectComment")
@Table(name = "comment", schema = "public")
public class Comment {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue
	private UUID id;

	@Column(name = "creation_date", nullable = false)
	private ZonedDateTime creationDate;

	@Column(name = "last_modified_date", nullable = false)
	private ZonedDateTime lastModifiedDate;

	@ManyToOne(targetEntity = ProjectUser.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "author", nullable = false)
	private ProjectUser author;

	@Column(name = "comment_text", nullable = false)
	private String commentText;

	@ManyToOne(targetEntity = Task.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "task", nullable = false)
	private Task task;

	@Column(name = "version", nullable = false)
	private Long version;

	public Comment() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public ZonedDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public ProjectUser getAuthor() {
		return author;
	}

	public void setAuthor(ProjectUser author) {
		this.author = author;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
