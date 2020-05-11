package com.timeboard.server.projects.model;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "ProjectDashboard")
@Table(name = "project_dashboard", schema = "public")
public class ProjectDashboard {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue
	private UUID id;

	@Column(name = "project_name", unique = true, nullable = false)
	private String projectName;

	@Column(name = "project_code", unique = true, nullable = false)
	private String projectCode;

	@Column(name = "creation_date", nullable = false)
	private ZonedDateTime creation_date;

	@Column(name = "description")
	private String description;

	@OneToMany(targetEntity = ProjectUser.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "project")
	private List<ProjectUser> users;

	@Column(name = "version", nullable = false)
	private Long version;

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

	public List<ProjectUser> getUsers() {
		return users;
	}

	public void setUsers(List<ProjectUser> users) {
		this.users = users;
	}
}
