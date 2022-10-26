package com.gremio.salesconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SalesConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SalesConsumerApplication.class, args);
    }
}
