package com.timeboard.server.domain;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.timeboard.server.domain.accounts.ProjectSchema;

@Entity(name = "ProjectUser")
@Table(name = "project_user")
public class ProjectUser {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;

	@ManyToOne(targetEntity = ProjectSchema.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "project_schema", nullable = false)
	private ProjectSchema projectSchema;

	@Column(name = "joining_date", nullable = false)
	private ZonedDateTime joiningDate;

	@Column(name = "leaving_date")
	private ZonedDateTime leavingDate;

	@ManyToOne(targetEntity = ProjectDashboard.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "project", nullable = false)
	private ProjectDashboard project;

	public ProjectUser() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ProjectSchema getProjectSchema() {
		return projectSchema;
	}

	public void setProjectSchema(ProjectSchema projectSchema) {
		this.projectSchema = projectSchema;
	}

	public ZonedDateTime getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(ZonedDateTime joiningDate) {
		this.joiningDate = joiningDate;
	}

	public ZonedDateTime getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(ZonedDateTime leavingDate) {
		this.leavingDate = leavingDate;
	}

	public ProjectDashboard getProject() {
		return project;
	}

	public void setProject(ProjectDashboard project) {
		this.project = project;
	}
}
