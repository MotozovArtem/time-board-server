CREATE TABLE group_task
(
	id      VARCHAR(36)  NOT NULL,
	name    VARCHAR(100) NOT NULL,
	version INTEGER      NOT NULL DEFAULT 0,
	PRIMARY KEY (id)
);

CREATE TABLE account
(
	id            VARCHAR(36)  NOT NULL,
	login         VARCHAR(256) NOT NULL,
	password      VARCHAR(100) NOT NULL,
	email         VARCHAR(256) NOT NULL,
	first_name    VARCHAR(256) NOT NULL,
	second_name   VARCHAR(256) NOT NULL,
	creation_date DATE         NOT NULL,
	version       INTEGER      NOT NULL DEFAULT 0,
	icon_url      TEXT         NULL,
	PRIMARY KEY (id)
);

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO account(id, login, password, email, first_name, second_name, creation_date)
VALUES ('bb951eda-a219-4f39-ac90-6af6c0a6af78', 'admin', 'admin', 'motozov.a.v@gmail.com', 'Admin', 'Admin', now());

CREATE TABLE project_schema
(
	id              VARCHAR(36)  NOT NULL,
	account         VARCHAR(36)  NOT NULL
		CONSTRAINT "FK_project_schema__account"
			REFERENCES account
			ON DELETE RESTRICT,
	user_in_project VARCHAR(36)  NULL,
	project_schema  VARCHAR(100) NOT NULL,
	version         INTEGER      NOT NULL DEFAULT 0,
	PRIMARY KEY (id)
);

INSERT INTO project_schema(id, account, user_in_project, project_schema)
VALUES ('f98e0fec-9230-4937-8f39-178f50c04666', 'bb951eda-a219-4f39-ac90-6af6c0a6af78',
		'dccb81a8-c935-4d5e-be81-a522faf692f3', 'project_test');

CREATE TABLE task
(
	id            VARCHAR(36)  NOT NULL,
	creation_date DATE         NOT NULL,
	done_date     DATE         NULL,
	is_done       BOOLEAN      NOT NULL DEFAULT FALSE,
	description   TEXT         NULL,
	name          VARCHAR(100) NOT NULL,
	group_task    VARCHAR(36)  NULL
		CONSTRAINT "FK_task__group"
			REFERENCES group_task
			ON DELETE RESTRICT,
	account       VARCHAR(36)  NOT NULL
		CONSTRAINT "FK_task__account"
			REFERENCES account
			ON DELETE RESTRICT,
	version       INTEGER      NOT NULL DEFAULT 0,
	PRIMARY KEY (id)
);

CREATE TABLE task_attachment
(
	id              VARCHAR(36)  NOT NULL,
	attachment_name VARCHAR(256) NOT NULL,
	url             VARCHAR(256) NOT NULL,
	task            VARCHAR(36)
		CONSTRAINT "FK_task_attachment__task"
			REFERENCES task
			ON DELETE RESTRICT,
	version         INTEGER      NOT NULL DEFAULT 0,
	PRIMARY KEY (id)
);
