package com.timeboard.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * todo motozov.
 */
@Entity(name = "GroupTask")
@Table(name = GroupTask.TABLE_NAME)
public class GroupTask extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_group_task";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {
		/**
		 * todo motozov.
		 */
		public static final String GT_CN_NAME = "name";
	}

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.GT_CN_NAME, unique = true, nullable = false)
	private String name;

	/**
	 * Constructor.
	 */
	public GroupTask() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
