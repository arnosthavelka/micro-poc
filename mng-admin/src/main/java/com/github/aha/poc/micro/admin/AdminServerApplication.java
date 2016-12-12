package com.github.aha.poc.micro.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.config.EnableAdminServer;

/**
 * Administration servers:
 * <ul>
 * <li>administration console (URL: http://localhost:8888/)</li>
 * <li>configuration server (URL: http://localhost:8888/config/api/applications - ???)</li>
 * <li>example of application configurations (URL: http://localhost:8888/config/discovery/native, http://localhost:8888/config/mycfg/env)</li>
 * </ul>
 */
@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
    }

}
