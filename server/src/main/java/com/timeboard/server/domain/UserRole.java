package com.timeboard.server.domain;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "UserRole")
@Table(name = "user_role")
public class UserRole {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;

	@ManyToOne(targetEntity = ProjectUser.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "project_user", unique = true, nullable = false)
	private ProjectUser project_user;

	@ManyToOne(targetEntity = Role.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "role", unique = true, nullable = false)
	private Role role;

	public UserRole() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ProjectUser getProject_user() {
		return project_user;
	}

	public void setProject_user(ProjectUser project_user) {
		this.project_user = project_user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
