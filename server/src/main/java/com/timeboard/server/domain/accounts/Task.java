package com.timeboard.server.domain.accounts;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Task")
@Table(name = "task", schema = "accounts")
public class Task {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;

	@Column(name = "creation_date", nullable = false)
	private ZonedDateTime creationDate;

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

	@ManyToOne(targetEntity = Account.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "account", nullable = false)
	private Account account;

	public Task() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
