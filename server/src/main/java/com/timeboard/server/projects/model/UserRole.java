package com.timeboard.server.projects.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name = "ProjectUserRole")
@Table(name = "user_role", schema = "public")
public class UserRole {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue
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

	@Version
	@Column(name = "version", nullable = false)
	private Long version;

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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
