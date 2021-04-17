CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE timeboard_group_task (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_group_task_pkey PRIMARY KEY (id),
    CONSTRAINT timeboard_group_task_name_ukey UNIQUE (name)
    );

CREATE TABLE timeboard_project_dashboard (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    description VARCHAR(255) NULL,
    project_code VARCHAR(255) NOT NULL,
    project_name VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_project_dashboard_pkey PRIMARY KEY (id),
    CONSTRAINT timeboard_project_dashboard_project_name_ukey UNIQUE (project_name),
    CONSTRAINT timeboard_project_dashboard_project_code_ukey UNIQUE (project_code)
    );

CREATE TABLE timeboard_user (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    email VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    icon_url VARCHAR(255) NULL,
    login VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    second_name VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_user_pkey PRIMARY KEY (id),
    CONSTRAINT timeboard_user_email_ukey UNIQUE (email),
    CONSTRAINT timeboard_user_login_ukey UNIQUE (login)
    );

CREATE TABLE timeboard_personal_task (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    description VARCHAR(255) NULL,
    done_date TIMESTAMP NULL,
    done BOOL NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    group_task_id VARCHAR(255) NULL,
    user_id VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_personal_task_pkey PRIMARY KEY (id),
    CONSTRAINT timeboard_personal_task_group_task_id_fkey FOREIGN KEY (group_task_id) REFERENCES timeboard_group_task (id),
    CONSTRAINT timeboard_personal_task_user_id_fkey FOREIGN KEY (user_id) REFERENCES timeboard_user (id)
    );

CREATE TABLE timeboard_personal_task_attachment (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    attachment_name VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    personal_task_id VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_personal_task_attachment_pkey PRIMARY KEY (id),
    CONSTRAINT timeboard_personal_task_attachment_url_ukey UNIQUE (url),
    CONSTRAINT timeboard_personal_task_attachment_personal_task_id_fkey
        FOREIGN KEY (personal_task_id) REFERENCES timeboard_personal_task (id)
    );

CREATE TABLE timeboard_project_user (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    joining_date TIMESTAMP NOT NULL,
    leaving_date TIMESTAMP NULL,
    project_id VARCHAR(255) NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_project_user_pkey
        PRIMARY KEY (id),
    CONSTRAINT timeboard_project_user_user_id_fkey
        FOREIGN KEY (user_id) REFERENCES timeboard_user (id),
    CONSTRAINT timeboard_project_user_project_id_fkey
        FOREIGN KEY (project_id) REFERENCES timeboard_project_dashboard (id)
    );

CREATE TABLE timeboard_role (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    access_level INT4 NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    project_id VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_role_pkey PRIMARY KEY (id),
    CONSTRAINT timeboard_role_access_level_ukey UNIQUE (access_level),
    CONSTRAINT timeboard_role_name_ukey UNIQUE (name),
    CONSTRAINT timeboard_role_project_id_fkey FOREIGN KEY (project_id) REFERENCES timeboard_project_dashboard (id)
    );

CREATE TABLE timeboard_step (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    project_id VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_step_pkey PRIMARY KEY (id),
    CONSTRAINT timeboard_step_name_ukey UNIQUE (name),
    CONSTRAINT timeboard_step_project_id_fkey FOREIGN KEY (project_id) REFERENCES timeboard_project_dashboard (id)
    );

CREATE TABLE timeboard_task (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    description VARCHAR(255) NOT NULL,
    done_date TIMESTAMP NULL,
    full_code VARCHAR(255) NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "number" INT4 NOT NULL,
    executor_id VARCHAR(255) NOT NULL,
    group_task_id VARCHAR(255) NOT NULL,
    project_id VARCHAR(255) NOT NULL,
    reported_id VARCHAR(255) NOT NULL,
    step_id VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_task_pkey PRIMARY KEY (id),
    CONSTRAINT timeboard_task_full_code_ukey UNIQUE (full_code),
    CONSTRAINT timeboard_task_number_ukey UNIQUE (number),
    CONSTRAINT timeboard_task_executor_id_fkey FOREIGN KEY (executor_id) REFERENCES timeboard_project_user (id),
    CONSTRAINT timeboard_task_group_task_id_fkey FOREIGN KEY (group_task_id) REFERENCES timeboard_group_task (id),
    CONSTRAINT timeboard_task_step_id_fkey FOREIGN KEY (step_id) REFERENCES timeboard_step (id),
    CONSTRAINT timeboard_task_project_id_fkey FOREIGN KEY (project_id) REFERENCES timeboard_project_dashboard (id),
    CONSTRAINT timeboard_task_reported_id_fkey FOREIGN KEY (reported_id) REFERENCES timeboard_project_user (id)
    );


CREATE TABLE timeboard_task_attachment (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    attachment_name VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    task_id VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_task_attachment_pkey PRIMARY KEY (id),
    CONSTRAINT timeboard_task_attachment_url_ukey UNIQUE (url),
    CONSTRAINT timeboard_task_attachment_task_id_fkey FOREIGN KEY (task_id) REFERENCES timeboard_task (id)
    );

CREATE TABLE timeboard_task_observer (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    observer_id VARCHAR(255) NOT NULL,
    task_id VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_task_observer_pkey PRIMARY KEY (id),
    CONSTRAINT timeboard_task_observer_observer_id_ukey UNIQUE (observer_id),
    CONSTRAINT timeboard_task_observer_observer_id_fkey FOREIGN KEY (observer_id) REFERENCES timeboard_project_user (id),
    CONSTRAINT timeboard_task_observer_task_id_fkey FOREIGN KEY (task_id) REFERENCES timeboard_task (id)
    );

CREATE TABLE user_role (
    project_user VARCHAR(255) NOT NULL,
    "role" VARCHAR(255) NOT NULL,
    CONSTRAINT user_role_pkey PRIMARY KEY (project_user, role),
    CONSTRAINT user_role_role_fkey FOREIGN KEY (role) REFERENCES timeboard_role (id),
    CONSTRAINT user_role_project_user_fkey FOREIGN KEY (project_user) REFERENCES timeboard_project_user (id)
    );

CREATE TABLE timeboard_comment (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    comment_text VARCHAR(255) NOT NULL,
    author_id VARCHAR(255) NOT NULL,
    task_id VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_comment_pkey PRIMARY KEY (id),
    CONSTRAINT timeboard_comment_author_id_fkey FOREIGN KEY (author_id) REFERENCES timeboard_project_user (id),
    CONSTRAINT timeboard_comment_task_id_fkey FOREIGN KEY (task_id) REFERENCES timeboard_task (id)
    );


CREATE TABLE timeboard_comment_attachment (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    attachment_name VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    comment_id VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_comment_attachment_pkey PRIMARY KEY (id),
    CONSTRAINT timeboard_comment_attachment_url_ukey UNIQUE (url),
    CONSTRAINT timeboard_comment_attachment_commit_id_fkey FOREIGN KEY (comment_id) REFERENCES timeboard_comment (id)
    );


CREATE TABLE timeboard_commit (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    "date" TIMESTAMP NOT NULL,
    diff_url VARCHAR(255) NOT NULL,
    hash VARCHAR(255) NOT NULL,
    message VARCHAR(255) NOT NULL,
    author_id VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_commit_pkey PRIMARY KEY (id),
    CONSTRAINT timeboard_commit_hash_ukey UNIQUE (hash),
    CONSTRAINT timeboard_commit_author_id_fkey FOREIGN KEY (author_id) REFERENCES timeboard_project_user (id)
    );


CREATE TABLE timeboard_task_commit (
    id VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL,
    last_modified_time TIMESTAMP NULL,
    ts BIGINT NOT NULL,
    commit_id VARCHAR(255) NOT NULL,
    task_id VARCHAR(255) NOT NULL,
    CONSTRAINT timeboard_task_commit_pkey PRIMARY KEY (id),
    CONSTRAINT timeboard_task_commit_commit_id_fkey FOREIGN KEY (commit_id) REFERENCES timeboard_commit (id),
    CONSTRAINT timeboard_task_commit_task_id_fkey FOREIGN KEY (task_id) REFERENCES timeboard_task (id)
    );
