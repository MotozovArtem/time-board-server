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
@Entity(name = "ProjectStep")
@Table(name = Step.TABLE_NAME)
public class Step extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_step";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {

		/**
		 * todo motozov.
		 */
		public static final String S_CN_NAME = "name";

		/**
		 * todo motozov.
		 */
		public static final String S_CN_PROJECT_ID = "project_id";
	}

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.S_CN_NAME, unique = true, nullable = false)
	private String name;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = Project.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = ColumnName.S_CN_PROJECT_ID, nullable = false)
	private Project project;

	/**
	 * Constructor.
	 */
	public Step() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
