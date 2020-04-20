CREATE SCHEMA IF NOT EXISTS accounts;

CREATE SCHEMA IF NOT EXISTS project_test;

CREATE TABLE accounts.group_task
(
	id   VARCHAR(36)  NOT NULL,
	name VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE accounts.account
(
	id            VARCHAR(36)  NOT NULL,
	login         VARCHAR(256) NOT NULL,
	password      VARCHAR(100) NOT NULL,
	email         VARCHAR(256) NOT NULL,
	first_name    VARCHAR(256) NOT NULL,
	second_name   VARCHAR(256) NOT NULL,
	creation_date DATE         NOT NULL,
	PRIMARY KEY (id)
);

-- Сдвинуть в конец
-- TODO: Чекнуть как работать со схемой и ограничениями по схеме
CREATE TABLE accounts.project_schema
(
	id              VARCHAR(36)  NOT NULL,
	account         VARCHAR(36)  NOT NULL
		CONSTRAINT "FK_accounts.project_schema__accounts.account"
			REFERENCES accounts.account
			ON DELETE RESTRICT,
	user_in_project VARCHAR(36)  NULL,
	project_schema  VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE accounts.task
(
	id            VARCHAR(36)  NOT NULL,
	creation_date DATE         NOT NULL,
	done_date     DATE         NULL,
	is_done       BOOLEAN      NOT NULL DEFAULT FALSE,
	description   TEXT         NULL,
	name          VARCHAR(100) NOT NULL,
	group_task    VARCHAR(36)  NULL
		CONSTRAINT "FK_accounts.task__accounts.group"
			REFERENCES accounts.group_task
			ON DELETE RESTRICT,
	account       VARCHAR(36)  NOT NULL
		CONSTRAINT "FK_accounts.task__accounts.account"
			REFERENCES accounts.account
			ON DELETE RESTRICT,
	PRIMARY KEY (id)
);

CREATE TABLE accounts.task_attachment
(
	id              VARCHAR(36)  NOT NULL,
	attachment_name VARCHAR(256) NOT NULL,
	url             VARCHAR(256) NOT NULL,
	task            VARCHAR(36)
		CONSTRAINT "FK_accounts.task_attachment__accounts.task"
			REFERENCES accounts.task
			ON DELETE RESTRICT,
	PRIMARY KEY (id)
);


/*#################################################################################################################################*/

CREATE TABLE project_test.project_dashboard
(
	id            VARCHAR(36)  NOT NULL,
	project_name  VARCHAR(256) NOT NULL,
	project_code  VARCHAR(10)  NOT NULL UNIQUE,
	creation_date DATE         NOT NULL,
	description   TEXT         NULL,
	PRIMARY KEY (id)
);

CREATE TABLE project_test.project_user
(
	id             VARCHAR(36) NOT NULL,
	project_schema VARCHAR(36) NOT NULL,
	joining_date   DATE        NOT NULL,
	leaving_date   DATE        NULL,
	project        VARCHAR(36) NOT NULL
		CONSTRAINT "FK_project_test.project_user__project_test.project_dashboard"
			REFERENCES project_test.project_dashboard
			ON DELETE RESTRICT,
	PRIMARY KEY (id)
);

CREATE TABLE project_test.role
(
	id           VARCHAR(36)  NOT NULL,
	name         VARCHAR(100) NOT NULL UNIQUE,
	access_level INTEGER      NOT NULL UNIQUE,
	PRIMARY KEY (id)
);

CREATE TABLE project_test.user_role
(
	id           VARCHAR(36) NOT NULL,
	project_user VARCHAR(36) NOT NULL
		CONSTRAINT "FK_project_test.user_role__project_test.project_user"
			REFERENCES project_test.project_user
			ON DELETE RESTRICT,
	role         VARCHAR(36) NOT NULL
		CONSTRAINT "FK_project_test.user_role__project_test.role"
			REFERENCES project_test.role
			ON DELETE RESTRICT,
	PRIMARY KEY (id)
);

CREATE TABLE project_test.step
(
	id   VARCHAR(36) NOT NULL,
	name VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE project_test.group_task
(
	id   VARCHAR(36) NOT NULL,
	name VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE project_test.task
(
	id            VARCHAR(36)  NOT NULL,
	number        INTEGER      NOT NULL,
	full_code     VARCHAR(50)  NOT NULL UNIQUE,
	creation_date DATE         NOT NULL,
	done_date     DATE         NULL,
	last_modified DATE         NOT NULL,
	description   TEXT         NULL,
	name          VARCHAR(256) NOT NULL,
	project       VARCHAR(36)  NOT NULL
		CONSTRAINT "FK_project_test.task__project_test.project_dashboard"
			REFERENCES project_test.project_dashboard
			ON DELETE RESTRICT,
	step          VARCHAR(36)  NOT NULL
		CONSTRAINT "FK_project_test.task__project_test.step"
			REFERENCES project_test.step
			ON DELETE RESTRICT,
	group_task    VARCHAR(36)  NOT NULL
		CONSTRAINT "FK_project_test.task__project_test.group_task"
			REFERENCES project_test.group_task
			ON DELETE RESTRICT,
	executor      VARCHAR(36)  NOT NULL
		CONSTRAINT "FK_project_test.task__project_test.project_user_executor"
			REFERENCES project_test.project_user
			ON DELETE RESTRICT,
	reporter      VARCHAR(36)  NOT NULL
		CONSTRAINT "FK_project_test.task__project_test.project_user_reporter"
			REFERENCES project_test.project_user
			ON DELETE RESTRICT,
	PRIMARY KEY (id)
);

CREATE TABLE project_test.task_observer
(
	id       VARCHAR(36) NOT NULL,
	task     VARCHAR(36) NULL
		CONSTRAINT "FK_project_test.task_observer__project_test.task"
			REFERENCES project_test.task
			ON DELETE RESTRICT,
	observer VARCHAR(36) NOT NULL
		CONSTRAINT "FK_project_test.task_observer__project_test.project_user"
			REFERENCES project_test.project_user
			ON DELETE RESTRICT,
	PRIMARY KEY (id)
);

CREATE TABLE project_test.comment
(
	id                 VARCHAR(36) NOT NULL,
	creation_date      DATE        NOT NULL,
	last_modified_date DATE        NOT NULL,
	author             VARCHAR(36) NOT NULL
		CONSTRAINT "FK_project_test.commit__project_test.project_user"
			REFERENCES project_test.project_user
			ON DELETE SET NULL,
	task               VARCHAR(36) NOT NULL
		CONSTRAINT "FK_project_test.commit__project_test.task"
			REFERENCES project_test.task
			ON DELETE SET NULL,
	comment_text       TEXT        NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE project_test.task_attachment
(
	id              VARCHAR(36)  NOT NULL,
	task            VARCHAR(36)  NULL
		CONSTRAINT "FK_project_test.task_attachment__project_test.task"
			REFERENCES project_test.task
			ON DELETE RESTRICT,
	attachment_name VARCHAR(256) NOT NULL,
	url             VARCHAR(256) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE project_test.comment_attachment
(
	id              VARCHAR(36)  NOT NULL,
	comment         VARCHAR(36)  NULL
		CONSTRAINT "FK_project_test.task_attachment__project_test.comment"
			REFERENCES project_test.comment
			ON DELETE SET NULL,
	attachment_name VARCHAR(256) NOT NULL,
	url             VARCHAR(256) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE project_test.commit
(
	id       VARCHAR(36)  NOT NULL,
	date     DATE         NOT NULL,
	hash     VARCHAR(16)  NOT NULL,
	diff_url VARCHAR(256) NOT NULL,
	message  TEXT         NOT NULL,
	author   VARCHAR(36)  NOT NULL
		CONSTRAINT "FK_project_test.commit__project_test.project_user"
			REFERENCES project_test.project_user
			ON DELETE SET NULL,
	PRIMARY KEY (id)
);

CREATE TABLE project_test.task_commit
(
	id     VARCHAR(36) NOT NULL,
	task   VARCHAR(36) NULL
		CONSTRAINT "FK_project_test.task_commit__project_test.task"
			REFERENCES project_test.task
			ON DELETE RESTRICT,
	commit VARCHAR(36) NULL
		CONSTRAINT "FK_project_test.task_commit__project_test.commit"
			REFERENCES project_test.commit
			ON DELETE SET NULL,
	PRIMARY KEY (id)
);