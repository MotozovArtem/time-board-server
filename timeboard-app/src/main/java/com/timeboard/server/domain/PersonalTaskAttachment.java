package com.timeboard.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * todo motozov.
 */
@Entity(name = "TaskAttachment")
@Table(name = PersonalTaskAttachment.TABLE_NAME)
public class PersonalTaskAttachment extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_personal_task_attachment";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {

		/**
		 * todo motozov.
		 */
		public static final String PTA_CN_ATTACHMENT_NAME = "attachment_name";

		/**
		 * todo motozov.
		 */
		public static final String PTA_CN_URL = "url";

		/**
		 * todo motozov.
		 */
		public static final String PTA_CN_PERSONAL_TASK_ID = "personal_task_id";
	}

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.PTA_CN_ATTACHMENT_NAME, nullable = false)
	private String attachmentName;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.PTA_CN_URL, unique = true, nullable = false)
	private String url;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = PersonalTask.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = ColumnName.PTA_CN_PERSONAL_TASK_ID, nullable = false, referencedColumnName = "id")
	private PersonalTask personalTask;

	/**
	 * Constructor.
	 */
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
