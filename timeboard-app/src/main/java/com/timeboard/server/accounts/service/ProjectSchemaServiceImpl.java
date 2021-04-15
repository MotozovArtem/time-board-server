package com.timeboard.server.accounts.service;

import com.timeboard.server.accounts.model.ProjectSchema;
import com.timeboard.server.accounts.repository.ProjectSchemaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectSchemaServiceImpl implements ProjectSchemaService {

	@Autowired
	ProjectSchemaRepository projectSchemaRepository;

	@Override
	public ProjectSchema findByProjectSchema(String schemaName) {
		return projectSchemaRepository.findByProjectSchema(schemaName);
	}

}
