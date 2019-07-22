package com.kok.config;

import com.kok.annotation.EnableMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author wenjie
 * @description
 * @time 2019/7/1 0001 13:16
 */
@ComponentScan("com.kok")
@Configuration
@EnableMapper
@EnableAspectJAutoProxy
public class AppConfig {
}
