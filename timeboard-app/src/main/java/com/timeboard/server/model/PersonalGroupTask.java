package com.timeboard.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * todo motozov.
 */
@Entity(name = "PersonalGroupTask")
@Table(name = PersonalGroupTask.TABLE_NAME)
public class PersonalGroupTask extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_personal_group_task";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {
		/**
		 * todo motozov.
		 */
		public static final String PGT_CN_NAME = "name";
	}

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.PGT_CN_NAME, unique = true, nullable = false)
	private String name;

	/**
	 * Constructor.
	 */
	public PersonalGroupTask() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
