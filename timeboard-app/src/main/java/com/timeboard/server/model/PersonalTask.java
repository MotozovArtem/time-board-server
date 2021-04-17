package com.timeboard.server.model;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * todo motozov.
 * TODO: Do it with descriptor and extends GroupTask (for all projects)
 */
@Entity(name = "Task")
@Table(name = PersonalTask.TABLE_NAME)
public class PersonalTask extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_personal_task";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {
		/**
		 * todo motozov.
		 */
		public static final String PT_CN_DONE_DATE = "done_date";

		/**
		 * todo motozov.
		 */
		public static final String PT_CN_DONE = "done";

		/**
		 * todo motozov.
		 */
		public static final String PT_CN_DESCRIPTION = "description";

		/**
		 * todo motozov.
		 */
		public static final String PT_CN_NAME = "name";

		/**
		 * todo motozov.
		 */
		public static final String PT_CN_PERSONAL_GROUP_TASK_ID = "personal_group_task_id";

		/**
		 * todo motozov.
		 */
		public static final String PT_CN_USER_ID = "user_id";
	}
	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.PT_CN_DONE_DATE)
	private ZonedDateTime doneDate;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.PT_CN_DONE, nullable = false)
	private Boolean isDone;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.PT_CN_DESCRIPTION)
	private String description;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.PT_CN_NAME, nullable = false)
	private String name;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = PersonalGroupTask.class,
			fetch = FetchType.LAZY)
	@JoinColumn(name = ColumnName.PT_CN_PERSONAL_GROUP_TASK_ID, referencedColumnName = "id")
	private PersonalGroupTask groupTask;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = User.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = ColumnName.PT_CN_USER_ID, nullable = false)
	private User user;

	/**
	 * todo motozov.
	 */
	public PersonalTask() {
	}

	public ZonedDateTime getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(ZonedDateTime doneDate) {
		this.doneDate = doneDate;
	}

	public Boolean getDone() {
		return isDone;
	}

	public void setDone(Boolean done) {
		isDone = done;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonalGroupTask getGroupTask() {
		return groupTask;
	}

	public void setGroupTask(PersonalGroupTask groupTask) {
		this.groupTask = groupTask;
	}

	public User getAccount() {
		return user;
	}

	public void setAccount(User user) {
		this.user = user;
	}
}
