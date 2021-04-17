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
@Entity(name = "ProjectCommentAttachment")
@Table(name = CommentAttachment.TABLE_NAME)
public class CommentAttachment extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_comment_attachment";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {

		/**
		 * todo motozov.
		 */
		public static final String CA_CN_COMMENT_ID = "comment_id";

		/**
		 * todo motozov.
		 */
		public static final String CA_CN_ATTACHMENT_NAME = "attachment_name";

		/**
		 * todo motozov.
		 */
		public static final String CA_CN_URL = "url";
	}

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = Comment.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = ColumnName.CA_CN_COMMENT_ID, nullable = false)
	private Comment comment;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.CA_CN_ATTACHMENT_NAME, nullable = false)
	private String attachmentName;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.CA_CN_URL, unique = true, nullable = false)
	private String url;

	/**
	 * Constructor.
	 */
	public CommentAttachment() {
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
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

