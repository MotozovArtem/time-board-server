package com.timeboard.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * todo motozov.
 */
@Entity(name = "ProjectTaskAttachment")
@Table(name = TaskAttachment.TABLE_NAME)
public class TaskAttachment extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_task_attachment";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {

		/**
		 * todo motozov.
		 */
		public static final String TA_CN_TASK_ID = "task_id";

		/**
		 * todo motozov.
		 */
		public static final String TA_CN_ATTACHMENT_NAME = "attachment_name";

		/**
		 * todo motozov.
		 */
		public static final String TA_CN_URL = "url";
	}

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = ColumnName.TA_CN_TASK_ID, nullable = false)
	private Task task;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.TA_CN_ATTACHMENT_NAME, nullable = false)
	private String attachmentName;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.TA_CN_URL, unique = true, nullable = false)
	private String url;

	/**
	 * Constructor.
	 */
	public TaskAttachment() {
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
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
}
