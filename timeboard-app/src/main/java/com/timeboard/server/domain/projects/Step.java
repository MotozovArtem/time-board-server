package com.timeboard.server.domain.projects;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity(name = "ProjectStep")
@Table(name = "step")
public class Step {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@Type(type = "uuid-char")
	@GeneratedValue
	private UUID id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Version
	@Column(name = "ts", nullable = false)
	private Long ts;

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

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}
}
