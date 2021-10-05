package com.suarez.TestMoby;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;

@SpringBootApplication
public class TestMobyApplication {

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(TestMobyApplication.class, args);

    }
}
