package com.timeboard.server.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "ProjectDashboard")
@Table(name = Project.TABLE_NAME)
public class Project extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_project_dashboard";

	@Column(name = "project_name", unique = true, nullable = false)
	private String projectName;

	@Column(name = "project_code", unique = true, nullable = false)
	private String projectCode;

	@Column(name = "description")
	private String description;

	@OneToMany(targetEntity = ProjectUser.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "project")
	private List<ProjectUser> users;

	public Project() {
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
