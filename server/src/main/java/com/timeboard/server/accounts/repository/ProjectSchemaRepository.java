package com.timeboard.server.accounts.repository;

import java.util.UUID;

import com.timeboard.server.accounts.model.ProjectSchema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectSchemaRepository extends JpaRepository<ProjectSchema, UUID> {

	@Query("SELECT p FROM ProjectSchema p WHERE p.projectSchema = :projectSchema")
	ProjectSchema findByProjectSchema(@Param("projectSchema") String projectSchema);

}
