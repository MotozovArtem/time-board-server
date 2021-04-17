package com.timeboard.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2021.04.17
 */
@Configuration
@EnableWebMvc
@EnableJpaAuditing
@Import({})
public class TimeboardConfig {
}
