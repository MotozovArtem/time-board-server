package com.timeboard.server.domain;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ProjectDashboard")
@Table(name = "project_dashboard")
public class ProjectDashboard {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;

	@Column(name = "project_name", unique = true, nullable = false)
	private String projectName;

	@Column(name = "project_code", unique = true, nullable = false)
	private String projectCode;

	@Column(name = "creation_date", nullable = false)
	private ZonedDateTime creation_date;

	@Column(name = "description")
	private String description;

	public ProjectDashboard() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public ZonedDateTime getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(ZonedDateTime creation_date) {
		this.creation_date = creation_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
