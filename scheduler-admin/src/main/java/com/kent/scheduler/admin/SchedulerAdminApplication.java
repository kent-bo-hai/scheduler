package com.kent.scheduler.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Scheduler Admin
 *
 * @author kent
 */
@SpringBootApplication
public class SchedulerAdminApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerAdminApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SchedulerAdminApplication.class);
    }
}
