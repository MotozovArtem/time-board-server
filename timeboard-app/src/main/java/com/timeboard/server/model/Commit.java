package com.timeboard.server.model;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * todo motozov.
 */
@Entity(name = "ProjectCommit")
@Table(name = Commit.TABLE_NAME)
public class Commit extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_commit";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {

		/**
		 * todo motozov.
		 */
		public static final String C_CN_DATE = "date";

		/**
		 * todo motozov.
		 */
		public static final String C_CN_HASH = "hash";

		/**
		 * todo motozov.
		 */
		public static final String C_CN_DIFF_URL = "diff_url";

		/**
		 * todo motozov.
		 */
		public static final String C_CN_MESSAGE = "message";

		/**
		 * todo motozov.
		 */
		public static final String C_CN_AUTHOR_ID = "author_id";
	}

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.C_CN_DATE, nullable = false)
	private ZonedDateTime date;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.C_CN_HASH, unique = true, nullable = false)
	private String hash;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.C_CN_DIFF_URL, nullable = false)
	private String diffUrl;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.C_CN_MESSAGE, nullable = false)
	private String message;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = ProjectUser.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = ColumnName.C_CN_AUTHOR_ID, nullable = false)
	private ProjectUser author;

	/**
	 * Constructor.
	 */
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
