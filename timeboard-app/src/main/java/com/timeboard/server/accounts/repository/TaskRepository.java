package com.timeboard.server.accounts.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timeboard.server.accounts.model.Task;

@Repository("accountTaskRepository")
public interface TaskRepository extends JpaRepository<Task, UUID> {
}
