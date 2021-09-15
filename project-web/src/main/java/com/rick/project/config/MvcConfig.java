package com.rick.project.config;

import com.rick.common.http.exception.ApiExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Rick
 * @createdAt 2021-09-15 23:52:00
 */
@Configuration
@ComponentScan(basePackageClasses = {ApiExceptionHandler.class})
public class MvcConfig implements WebMvcConfigurer {}
