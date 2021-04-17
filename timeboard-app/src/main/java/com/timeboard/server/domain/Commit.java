package com.timeboard.server.domain;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ProjectCommit")
@Table(name = Commit.TABLE_NAME)
public class Commit extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_commit";

	@Column(name = "date", nullable = false)
	private ZonedDateTime date;

	@Column(name = "hash", unique = true, nullable = false)
	private String hash;

	@Column(name = "diff_url", nullable = false)
	private String diffUrl;

	@Column(name = "message", nullable = false)
	private String message;

	@ManyToOne(targetEntity = ProjectUser.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "author", nullable = false)
	private ProjectUser author;

	public Commit() {
	}

	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getDiffUrl() {
		return diffUrl;
	}

	public void setDiffUrl(String diffUrl) {
		this.diffUrl = diffUrl;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ProjectUser getAuthor() {
		return author;
	}

	public void setAuthor(ProjectUser author) {
		this.author = author;
	}
}
