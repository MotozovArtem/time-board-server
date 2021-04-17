package com.timeboard.server.repository;

import com.timeboard.server.model.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2021.04.18
 */
public interface StepRepository extends JpaRepository<Step, UUID> {
}
