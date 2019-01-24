package com.wz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

//@Configuration
////@EnableAsync
////public class TestConfig {
////    @Bean
////    public Executor executor(){
////        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
////        executor.setMaxPoolSize(100);
////        executor.setCorePoolSize(10);
////        executor.setQueueCapacity(10);
////        executor.initialize();
////        return executor;
////    }
////}
