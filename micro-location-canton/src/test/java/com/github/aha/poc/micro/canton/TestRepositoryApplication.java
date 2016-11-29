package com.github.aha.poc.micro.canton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.github.aha.poc.micro.canton.persistence.repository.CantonRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = CantonRepository.class)
@Import({ DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, LiquibaseAutoConfiguration.class })
public class TestRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestRepositoryApplication.class, args);
	}
}
