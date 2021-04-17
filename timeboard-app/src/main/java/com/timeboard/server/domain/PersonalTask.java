package com.timeboard.server.domain;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Task")
@Table(name = PersonalTask.TABLE_NAME)
public class PersonalTask extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_personal_task";

	@Column(name = "done_date")
	private ZonedDateTime doneDate;

	@Column(name = "is_done", nullable = false)
	private Boolean isDone;

	@Column(name = "description")
	private String description;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne(targetEntity = GroupTask.class,
			fetch = FetchType.LAZY)
	@JoinColumn(name = "group_task", referencedColumnName = "id")
	private GroupTask groupTask;

	@ManyToOne(targetEntity = User.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "account", nullable = false)
	private User user;

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

	public GroupTask getGroupTask() {
		return groupTask;
	}

	public void setGroupTask(GroupTask groupTask) {
		this.groupTask = groupTask;
	}

	public User getAccount() {
		return user;
	}

	public void setAccount(User user) {
		this.user = user;
	}
}
