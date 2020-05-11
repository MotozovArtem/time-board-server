package com.timeboard.server.projects.model;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.timeboard.server.accounts.model.ProjectSchema;

@Entity(name = "ProjectUser")
@Table(name = "project_user", schema = "public")
public class ProjectUser {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue
	private UUID id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_schema", nullable = false)
	private ProjectSchema projectSchema;

	@Column(name = "joining_date", nullable = false)
	private ZonedDateTime joiningDate;

	@Column(name = "leaving_date")
	private ZonedDateTime leavingDate;

	@ManyToOne(targetEntity = ProjectDashboard.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "project", nullable = false)
	private ProjectDashboard project;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role",
			joinColumns = @JoinColumn(name = "project_user"),
			inverseJoinColumns = @JoinColumn(name = "role")
	)
	private List<Role> roles;

	@Column(name = "version", nullable = false)
	private Long version;

	public ProjectUser() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ProjectSchema getProjectSchema() {
		return projectSchema;
	}

	public void setProjectSchema(ProjectSchema projectSchema) {
		this.projectSchema = projectSchema;
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

	public ProjectDashboard getProject() {
		return project;
	}

	public void setProject(ProjectDashboard project) {
		this.project = project;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
