package com.timeboard.server.domain.projects;

import org.hibernate.annotations.Type;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name = "ProjectTask")
@Table(name = "task")
public class Task {

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

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @Type(type = "uuid-char")
    @GeneratedValue
    private UUID id;

    @Column(name = "number", unique = true, nullable = false)
    private Integer number;

    @Column(name = "full_code", unique = true, nullable = false)
    private String fullCode;

    @Column(name = "creation_date", nullable = false)
    private ZonedDateTime creationDate;

    @Column(name = "done_date")
    private ZonedDateTime doneDate;

    @Column(name = "last_modified", nullable = false)
    private ZonedDateTime lastModified;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(targetEntity = ProjectDashboard.class,
            fetch = FetchType.LAZY,
            optional = false)
    @JoinColumn(name = "project", nullable = false)
    private ProjectDashboard project;

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

    @Version
    @Column(name = "ts", nullable = false)
    private Long ts;

    public Task() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public ZonedDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(ZonedDateTime lastModified) {
        this.lastModified = lastModified;
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

    public ProjectDashboard getProject() {
        return project;
    }

    public void setProject(ProjectDashboard project) {
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

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }
}
