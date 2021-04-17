package com.timeboard.server.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ProjectRole")
@Table(name = Role.TABLE_NAME)
public class Role extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_role";

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "access_level", unique = true, nullable = false)
	private Integer accessLevel;

	@ManyToOne(targetEntity = Project.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<ProjectUser> users;

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
