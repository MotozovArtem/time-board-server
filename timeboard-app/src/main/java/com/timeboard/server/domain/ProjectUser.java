package com.timeboard.server.domain;

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

@Entity(name = "ProjectUser")
@Table(name = ProjectUser.TABLE_NAME)
public class ProjectUser extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_project_user";

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_user_id", nullable = false)
	private User user;

	@Column(name = "joining_date", nullable = false)
	private ZonedDateTime joiningDate;

	@Column(name = "leaving_date")
	private ZonedDateTime leavingDate;

	@ManyToOne(targetEntity = Project.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "project", nullable = false)
	private Project project;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role",
			joinColumns = @JoinColumn(name = "project_user"),
			inverseJoinColumns = @JoinColumn(name = "role")
	)
	private Set<Role> roles;

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
