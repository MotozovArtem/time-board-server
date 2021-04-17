package com.timeboard.server.domain;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ProjectTask")
@Table(name = Task.TABLE_NAME)
public class Task extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_task";

	public static class ColumnName {
		public static final String T_CN_ID = "id";
		public static final String T_CN_NUMBER = "id";
		public static final String T_CN_FULL_CODE = "id";
		public static final String T_CN_CREATION_DATE = "id";
		public static final String T_CN_DONE_DATE = "id";
		public static final String T_CN_LAST_MODIFIED = "id";
		public static final String T_CN_DESCRIPTION = "id";
		public static final String T_CN_NAME = "id";
		public static final String T_CN_PROJECT = "id";
		public static final String T_CN_STEP = "id";
		public static final String T_CN_GROUP_TASK = "id";
		public static final String T_CN_REPORTER = "id";
	}

	@Column(name = "number", unique = true, nullable = false)
	private Integer number;

	@Column(name = "full_code", unique = true, nullable = false)
	private String fullCode;

	@Column(name = "done_date")
	private ZonedDateTime doneDate;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne(targetEntity = Project.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "project", nullable = false)
	private Project project;

	@ManyToOne(targetEntity = Step.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "step", nullable = false)
	private Step step;

	@ManyToOne(targetEntity = GroupTask.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "group_task")
	private GroupTask groupTask;

	@ManyToOne(targetEntity = ProjectUser.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "executor")
	private ProjectUser executor;

	@ManyToOne(targetEntity = ProjectUser.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "reporter", nullable = false)
	private ProjectUser reporter;

	public Task() {
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getFullCode() {
		return fullCode;
	}

	public void setFullCode(String fullCode) {
		this.fullCode = fullCode;
	}

	public ZonedDateTime getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(ZonedDateTime doneDate) {
		this.doneDate = doneDate;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Step getStep() {
		return step;
	}

	public void setStep(Step step) {
		this.step = step;
	}

	public GroupTask getGroupTask() {
		return groupTask;
	}

	public void setGroupTask(GroupTask groupTask) {
		this.groupTask = groupTask;
	}

	public ProjectUser getExecutor() {
		return executor;
	}

	public void setExecutor(ProjectUser executor) {
		this.executor = executor;
	}

	public ProjectUser getReporter() {
		return reporter;
	}

	public void setReporter(ProjectUser reporter) {
		this.reporter = reporter;
	}

}
