package com.example.bnanum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BnanumApplication {

    public static void main(String[] args) {
        SpringApplication.run(BnanumApplication.class, args);
    }

}
