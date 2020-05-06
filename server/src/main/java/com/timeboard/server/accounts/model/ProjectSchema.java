package com.timeboard.server.accounts.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.timeboard.server.projects.model.ProjectUser;

@Entity(name = "ProjectSchema")
@Table(name = "project_schema", schema = "public")
public class ProjectSchema {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue
	private UUID id;

	@ManyToOne(targetEntity = Account.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "account", referencedColumnName = "id", nullable = false)
	private Account account;

	@OneToOne(targetEntity = ProjectUser.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "user_in_project", referencedColumnName = "id", unique = true, nullable = false)
	private ProjectUser userInProject;

	@Column(name = "project_schema", nullable = false)
	private String projectSchema;

	public ProjectSchema() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public ProjectUser getUserInProject() {
		return userInProject;
	}

	public void setUserInProject(ProjectUser userInProject) {
		this.userInProject = userInProject;
	}

	public String getProjectSchema() {
		return projectSchema;
	}

	public void setProjectSchema(String projectSchema) {
		this.projectSchema = projectSchema;
	}
}
