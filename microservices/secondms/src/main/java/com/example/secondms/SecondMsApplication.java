package com.example.secondms;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
public class SecondMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondMsApplication.class, args);
    }

    @Bean
    ApplicationRunner start(JobRepo repo, RepositoryRestConfiguration restConfig) {
        return args -> {
            restConfig.exposeIdsFor(Job.class); // show the id in the JSON
            Stream.of(new Job("Informatique", true),
                            new Job("Comptabilite", false),
                            new Job("Marketing", true))
                    .forEach(repo::save);
            repo.findAll().forEach(System.out::println);
        };
    }
}
