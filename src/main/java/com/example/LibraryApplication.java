package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.sql.DataSource;
import java.util.Objects;

@SpringBootApplication
public class LibraryApplication {
	private final ApplicationContext applicationContext;
	private Environment environment;

	@Autowired
	public LibraryApplication(ApplicationContext applicationContext,Environment environment) {
		this.environment = environment;
		this.applicationContext = applicationContext;
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("spring.datasource.driver-class-name")));
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.datasource.password"));

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}

/*server:
		port: 8080

		spring:
		datasource:
		url: jdbc:postgresql://localhost:5432/postgres
		username: postgres
		password: password
		jpa:
		hibernate:
		ddl-auto: create-drop
		properties:
		hibernate:
		dialect: org.hibernate.dialect.PostgreSQLDialect
		format_sql: true
		show-sql: true
		main:
		wep-application-type: servlet*/
