package com.asseco.aha.poc.micro.canton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CantonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CantonApplication.class, args);
    }

}
