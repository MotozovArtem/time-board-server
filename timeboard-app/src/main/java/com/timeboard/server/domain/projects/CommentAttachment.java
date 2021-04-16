package com.timeboard.server.domain.projects;

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

import org.hibernate.annotations.Type;

@Entity(name = "ProjectCommentAttachment")
@Table(name = "comment_attachment")
public class CommentAttachment {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@Type(type = "uuid-char")
	@GeneratedValue
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

	@Version
	@Column(name = "ts", nullable = false)
	private Long ts;

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

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}
}

