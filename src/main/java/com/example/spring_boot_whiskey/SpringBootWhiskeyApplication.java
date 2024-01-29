package com.example.spring_boot_whiskey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootWhiskeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWhiskeyApplication.class, args);
    }

}
