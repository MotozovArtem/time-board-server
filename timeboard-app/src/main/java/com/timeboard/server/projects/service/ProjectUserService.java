package com.timeboard.server.projects.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.timeboard.server.projects.model.ProjectUser;

public interface ProjectUserService {
	ProjectUser save(ProjectUser user);

	String findLoggedInUsername();

	@Query("select p from ProjectUser p where p.projectSchema.account.login = :username and p.projectSchema.projectSchema = :projectSchema")
	ProjectUser findByUsernameAndTenantname(@Param("username") String username,
	                                        @Param("projectSchema") String projectSchema);

	List<ProjectUser> findAllUsers();
}
