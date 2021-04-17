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
 */
@Entity(name = "ProjectTask")
@Table(name = Task.TABLE_NAME)
public class Task extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_task";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {

		/**
		 * todo motozov.
		 */
		public static final String T_CN_NUMBER = "number";

		/**
		 * todo motozov.
		 */
		public static final String T_CN_FULL_CODE = "full_code";

		/**
		 * todo motozov.
		 */
		public static final String T_CN_DONE_DATE = "done_date";

		/**
		 * todo motozov.
		 */
		public static final String T_CN_DESCRIPTION = "description";

		/**
		 * todo motozov.
		 */
		public static final String T_CN_NAME = "name";

		/**
		 * todo motozov.
		 */
		public static final String T_CN_PROJECT_ID = "project_id";

		/**
		 * todo motozov.
		 */
		public static final String T_CN_STEP_ID = "step_id";

		/**
		 * todo motozov.
		 */
		public static final String T_CN_GROUP_TASK_ID = "group_task_id";

		/**
		 * todo motozov.
		 */
		public static final String T_CN_EXECUTOR_ID = "executor_id";

		/**
		 * todo motozov.
		 */
		public static final String T_CN_REPORTER_ID = "reported_id";
	}

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.T_CN_NUMBER, unique = true, nullable = false)
	private Integer number;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.T_CN_FULL_CODE, unique = true, nullable = false)
	private String fullCode;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.T_CN_DONE_DATE)
	private ZonedDateTime doneDate;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.T_CN_DESCRIPTION, nullable = false)
	private String description;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.T_CN_NAME, nullable = false)
	private String name;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = Project.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = ColumnName.T_CN_PROJECT_ID, nullable = false)
	private Project project;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = Step.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = ColumnName.T_CN_STEP_ID, nullable = false)
	private Step step;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = GroupTask.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = ColumnName.T_CN_GROUP_TASK_ID)
	private GroupTask groupTask;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = ProjectUser.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = ColumnName.T_CN_EXECUTOR_ID)
	private ProjectUser executor;

	/**
	 * todo motozov.
	 */
	@ManyToOne(targetEntity = ProjectUser.class,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(name = ColumnName.T_CN_REPORTER_ID, nullable = false)
	private ProjectUser reporter;

	/**
	 * Constructor.
	 */
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
