package com.timeboard.test.server.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
//import com.timeboard.server.config.TimeboardConfig;

/**
 * Test configuration
 *
 * @author Artem Motozov
 * @since 2021.04.17
 */
@Configuration
@EnableAutoConfiguration
// fixme: Fix copy sources
//@Import({TimeboardConfig.class})
@EnableConfigurationProperties
public class TestApplicationConfig {
}
