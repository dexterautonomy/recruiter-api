package com.recruiter.devops.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("app.prop")
public class AppProperties {
	private String external;
}
