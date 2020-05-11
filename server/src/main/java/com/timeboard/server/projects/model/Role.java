package com.timeboard.server.projects.model;

import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity(name = "ProjectRole")
@Table(name = "role", schema = "public")
public class Role {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@Type(type = "uuid-char")
	@GeneratedValue
	private UUID id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "access_level", unique = true, nullable = false)
	private Integer accessLevel;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<ProjectUser> users;

	@Version
	@Column(name = "version", nullable = false)
	private Long version;

	public Role() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
}
