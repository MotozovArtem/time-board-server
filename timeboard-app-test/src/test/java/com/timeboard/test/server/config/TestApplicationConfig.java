package com.timeboard.test.server.config;

import com.timeboard.server.config.TimeboardConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Test configuration
 *
 * @author Artem Motozov
 * @since 2021.04.17
 */
@Configuration
@EnableAutoConfiguration
@Import({TimeboardConfig.class})
@EnableConfigurationProperties
public class TestApplicationConfig {
}
