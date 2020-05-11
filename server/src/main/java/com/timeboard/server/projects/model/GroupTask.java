package com.timeboard.server.projects.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name = "ProjectGroupTask")
@Table(name = "group_task", schema = "public")
public class GroupTask {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue
	private UUID id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Version
	@Column(name = "version", nullable = false)
	private Long version;

	public GroupTask() {
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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
