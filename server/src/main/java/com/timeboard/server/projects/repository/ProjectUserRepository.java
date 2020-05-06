package com.timeboard.server.projects.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.timeboard.server.projects.model.ProjectUser;

@Repository
public interface ProjectUserRepository extends JpaRepository<ProjectUser, UUID> {
	@Query("select p from ProjectUser p where p.projectSchema.account.login = :login and p.projectSchema.projectSchema = :projectSchema")
	ProjectUser findByUsernameAndTenantname(@Param("login") String username,
	                                        @Param("projectSchema") String projectSchema);
}
