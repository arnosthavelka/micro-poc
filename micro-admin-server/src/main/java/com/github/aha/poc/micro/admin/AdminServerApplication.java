package com.github.aha.poc.micro.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Administration servers:
 * <ul>
 * <li>administration console (URL: ???)</li>
 * <li>configuration server (URL: http://localhost:8888/mycfg/env)</li>
 * </ul>
 */
@SpringBootApplication
@EnableConfigServer
public class AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
    }

}
