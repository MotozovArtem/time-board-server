package com.timeboard.server.model;

import java.time.ZonedDateTime;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * todo motozov.
 */
@Entity(name = "ProjectUser")
@Table(name = ProjectUser.TABLE_NAME)
public class ProjectUser extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_project_user";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {

		/**
		 * todo motozov.
		 */
		public static final String PU_CN_USER_ID = "user_id";

		/**
		 * todo motozov.
		 */
		public static final String PU_CN_JOINING_DATE = "joining_date";

		/**
		 * todo motozov.
		 */
		public static final String PU_CN_LEAVING_DATE = "leaving_date";

		/**
		 * todo motozov.
		 */
		public static final String PU_CN_PROJECT_ID = "project_id";
	}

	/**
	 * todo motozov.
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = ColumnName.PU_CN_USER_ID, nullable = false)
	private User user;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.PU_CN_JOINING_DATE, nullable = false)
	private ZonedDateTime joiningDate;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.PU_CN_LEAVING_DATE)
	private ZonedDateTime leavingDate;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = Project.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = ColumnName.PU_CN_PROJECT_ID, nullable = false)
	private Project project;

	/**
	 * todo motozov.
	 */
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role",
			joinColumns = @JoinColumn(name = "project_user"),
			inverseJoinColumns = @JoinColumn(name = "role")
	)
	private Set<Role> roles;

	/**
	 * Constructor.
	 */
	public ProjectUser() {
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
