package com.suarez.TestMoby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableJpaRepositories
@SpringBootApplication
@EnableSwagger2
@EnableAspectJAutoProxy
public class TestMobyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestMobyApplication.class, args);
	}

}
