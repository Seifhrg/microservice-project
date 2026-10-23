package com.example.firstms;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesApplication.class, args);
    }

    @Bean
    ApplicationRunner start(CandidatRepo repo) {
        return args -> {
            Stream.of(new Candidat("Rihab", "Idoudi", "Tunis"),
                            new Candidat("Ahmed", "Mrabet", "Tunis"))
                    .forEach(repo::save);
            repo.findAll().forEach(System.out::println);
        };
    }
}