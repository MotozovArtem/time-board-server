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
@Entity(name = "ProjectComment")
@Table(name = Comment.TABLE_NAME)
public class Comment extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_comment";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {

		/**
		 * todo motozov.
		 */
		public static final String C_CN_AUTHOR_ID = "author_id";

		/**
		 * todo motozov.
		 */
		public static final String C_CN_COMMENT_TEXT = "comment_text";

		/**
		 * todo motozov.
		 */
		public static final String C_CN_TASK_ID = "task_id";
	}

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = ProjectUser.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = ColumnName.C_CN_AUTHOR_ID, nullable = false)
	private ProjectUser author;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.C_CN_COMMENT_TEXT, nullable = false)
	private String commentText;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = Task.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = ColumnName.C_CN_TASK_ID, nullable = false)
	private Task task;

	/**
	 * Constructor.
	 */
	public Comment() {
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
}
