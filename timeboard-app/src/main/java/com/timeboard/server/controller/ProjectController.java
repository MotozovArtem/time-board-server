package com.timeboard.server.controller;

import com.timeboard.server.model.Project;
import com.timeboard.server.repository.ProjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2021.04.18
 */
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	/**
	 * Репозиторий для работы с проектами.
	 */
	private final ProjectRepository projectRepository;

	/**
	 * Constructor.
	 *
	 * @param projectRepository репозиторий для работы с проектами.
	 */
	public ProjectController(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@GetMapping
	public Iterable<Project> findAll() {
		return projectRepository.findAll();
	}


}
