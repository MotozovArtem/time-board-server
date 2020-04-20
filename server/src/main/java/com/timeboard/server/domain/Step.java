package com.timeboard.server.domain;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ProjectStep")
@Table(name = "step")
public class Step {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	public Step() {
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
}
