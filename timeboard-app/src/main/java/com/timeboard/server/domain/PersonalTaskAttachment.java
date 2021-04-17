package com.timeboard.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "TaskAttachment")
@Table(name = PersonalTaskAttachment.TABLE_NAME)
public class PersonalTaskAttachment extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_personal_task_attachment";

	@Column(name = "attachment_name", nullable = false)
	private String attachmentName;

	@Column(name = "url", unique = true, nullable = false)
	private String url;

	@ManyToOne(targetEntity = PersonalTask.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "task", nullable = false, referencedColumnName = "id")
	private PersonalTask personalTask;

	public PersonalTaskAttachment() {
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
}
