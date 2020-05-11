package com.timeboard.server.accounts.model;

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

@Entity(name = "TaskAttachment")
@Table(name = "task_attachment", schema = "public")
public class TaskAttachment {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue
	private UUID id;

	@Column(name = "attachment_name", nullable = false)
	private String attachmentName;

	@Column(name = "url", unique = true, nullable = false)
	private String url;

	@ManyToOne(targetEntity = Task.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "task", nullable = false, referencedColumnName = "id")
	private Task task;

	@Version
	@Column(name = "version", nullable = false)
	private Long version;

	public TaskAttachment() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
