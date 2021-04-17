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
@Entity(name = "ProjectComment")
@Table(name = Comment.TABLE_NAME)
public class Comment extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_comment";

	@ManyToOne(targetEntity = ProjectUser.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = ColumnName.C_CN_AUTHOR_ID, nullable = false)
	private ProjectUser author;

	@Column(name = ColumnName.C_CN_COMMENT_TEXT, nullable = false)
	private String commentText;

	@ManyToOne(targetEntity = Task.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = ColumnName.C_CN_TASK_ID, nullable = false)
	private Task task;

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

	public static class ColumnName {
		public static final String C_CN_ID = "id";

		public static final String C_CN_AUTHOR_ID = "author_id";

		public static final String C_CN_COMMENT_TEXT = "comment_text";

		public static final String C_CN_TASK_ID = "task_id";
	}
}
