package com.suarez.testmoby;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TestMobyApplication {

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(TestMobyApplication.class, args);

    }
}
