package com.asseco.aha.poc.micro.district;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DistrictApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistrictApplication.class, args);
    }

}
