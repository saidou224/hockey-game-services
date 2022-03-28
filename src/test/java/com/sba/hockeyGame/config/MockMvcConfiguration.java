package com.sba.hockeyGame.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;


@TestConfiguration
@ComponentScan(basePackages = "com.sba.hockeyGame.api.infrastructure")
public class MockMvcConfiguration {
}
