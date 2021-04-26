package com.timeboard.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

/**
 * Конфигурация REST контроллеров.
 *
 * @author Artem Motozov
 * @since 2021.04.26
 */
@Configuration
public class RestMvcConfig {
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return new RepositoryRestConfigurer() {
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config.setBasePath("/api");
			}
		};
	}
}
