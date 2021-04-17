package com.timeboard.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ProjectStep")
@Table(name = Step.TABLE_NAME)
public class Step extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_step";

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@ManyToOne(targetEntity = Project.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;

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
