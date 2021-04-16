package com.timeboard.server.domain.accounts;

import org.hibernate.annotations.Type;

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
@Table(name = "personal_task_attachment")
public class PersonalTaskAttachment {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@Type(type = "uuid-char")
	@GeneratedValue
	private UUID id;

	@Column(name = "attachment_name", nullable = false)
	private String attachmentName;

	@Column(name = "url", unique = true, nullable = false)
	private String url;

	@ManyToOne(targetEntity = PersonalTask.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "task", nullable = false, referencedColumnName = "id")
	private PersonalTask personalTask;

	@Version
	@Column(name = "ts", nullable = false)
	private Long ts;

	public PersonalTaskAttachment() {
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

	public PersonalTask getTask() {
		return personalTask;
	}

	public void setTask(PersonalTask personalTask) {
		this.personalTask = personalTask;
	}

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}
}
