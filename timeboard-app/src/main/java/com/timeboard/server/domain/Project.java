package com.timeboard.server.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * todo motozov.
 */
@Entity(name = "ProjectDashboard")
@Table(name = Project.TABLE_NAME)
public class Project extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_project_dashboard";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {

		/**
		 * todo motozov.
		 */
		public static final String P_CN_PROJECT_NAME = "project_name";

		/**
		 * todo motozov.
		 */
		public static final String P_CN_PROJECT_CODE = "project_code";

		/**
		 * todo motozov.
		 */
		public static final String P_CN_DESCRIPTION = "description";
	}

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.P_CN_PROJECT_NAME, unique = true, nullable = false)
	private String projectName;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.P_CN_PROJECT_CODE, unique = true, nullable = false)
	private String projectCode;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.P_CN_DESCRIPTION)
	private String description;

	/**
	 * todo motozov.
	 */
	@OneToMany(targetEntity = ProjectUser.class, fetch = FetchType.LAZY)
	@JoinColumn(name = ProjectUser.ColumnName.PU_CN_PROJECT_ID)
	private Set<ProjectUser> users;

	/**
	 * Constructor.
	 */
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

	public Set<ProjectUser> getUsers() {
		return users;
	}

	public void setUsers(Set<ProjectUser> users) {
		this.users = users;
	}
}
