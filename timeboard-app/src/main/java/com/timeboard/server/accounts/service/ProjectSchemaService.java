package com.timeboard.server.accounts.service;

import com.timeboard.server.accounts.model.ProjectSchema;

public interface ProjectSchemaService {
	ProjectSchema findByProjectSchema(String schemaName);
}
