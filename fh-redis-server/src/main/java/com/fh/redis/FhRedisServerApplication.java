package com.fh.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableRedisRepositories
public class FhRedisServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FhRedisServerApplication.class, args);
    }
}
