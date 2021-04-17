package com.timeboard.server.repository;

import com.timeboard.server.model.TaskAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2021.04.18
 */
public interface TaskAttachmentRepository extends JpaRepository<TaskAttachment, UUID> {
}
