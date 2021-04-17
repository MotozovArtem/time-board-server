package com.timeboard.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "GroupTask")
@Table(name = GroupTask.TABLE_NAME)
public class GroupTask extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_group_task";

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	public GroupTask() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
