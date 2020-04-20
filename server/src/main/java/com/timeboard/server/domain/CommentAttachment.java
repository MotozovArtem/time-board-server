package com.timeboard.server.domain;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ProjectCommentAttachment")
@Table(name = "comment_attachment")
public class CommentAttachment {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;

	@ManyToOne(targetEntity = Comment.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "comment", nullable = false)
	private Comment comment;

	@Column(name = "attachment_name", nullable = false)
	private String attachmentName;

	@Column(name = "url", unique = true, nullable = false)
	private String url;

	public CommentAttachment() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

