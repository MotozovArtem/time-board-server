package com.timeboard.server.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * todo motozov.
 */
@Entity(name = "ProjectRole")
@Table(name = Role.TABLE_NAME)
public class Role extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_role";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {

		/**
		 * todo motozov.
		 */
		public static final String R_CN_NAME = "name";

		/**
		 * todo motozov.
		 */
		public static final String R_CN_ACCESS_LEVEL = "access_level";

		/**
		 * todo motozov.
		 */
		public static final String R_CN_PROJECT_ID = "project_id";
	}

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.R_CN_NAME, unique = true, nullable = false)
	private String name;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.R_CN_ACCESS_LEVEL, unique = true, nullable = false)
	private Integer accessLevel;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = Project.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = ColumnName.R_CN_PROJECT_ID, nullable = false)
	private Project project;

	/**
	 * todo motozov.
	 */
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<ProjectUser> users;

	/**
	 * Constructor.
	 */
	public Role() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(Integer accessLevel) {
		this.accessLevel = accessLevel;
	}

	public Set<ProjectUser> getUsers() {
		return users;
	}

	public void setUsers(Set<ProjectUser> users) {
		this.users = users;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
