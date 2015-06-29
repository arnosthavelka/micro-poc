package com.github.aha.poc.micro.district;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.github.aha.poc.micro.district.persistence.domain.District;
import com.github.aha.poc.micro.district.persistence.repository.DistrictRepository;

@Configuration
@EntityScan(basePackageClasses = District.class)
@EnableJpaRepositories(basePackageClasses = DistrictRepository.class)
@Import({ DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, LiquibaseAutoConfiguration.class })
public class TestRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestRepositoryApplication.class, args);
	}
}
