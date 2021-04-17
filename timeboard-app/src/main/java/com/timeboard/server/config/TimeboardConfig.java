package com.timeboard.server.config;

import com.timeboard.server.security.SecurityConfig;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
@EnableJpaRepositories("com.timeboard.server.repository")
@EntityScan("com.timeboard.server.model")
@Import({SecurityConfig.class})
public class TimeboardConfig {
}
