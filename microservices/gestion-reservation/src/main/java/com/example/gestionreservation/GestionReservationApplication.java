package com.example.gestionreservation;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDate;
import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class GestionReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionReservationApplication.class, args);
    }

    @Bean
    ApplicationRunner start(ReservationRepo repo, RepositoryRestConfiguration restConfig) {
        return args -> {
            restConfig.exposeIdsFor(Reservation.class);
            Stream.of(
                            new Reservation(LocalDate.of(2026, 11, 1), LocalDate.of(2026, 11, 5), true, 1L),
                            new Reservation(LocalDate.of(2026, 12, 10), LocalDate.of(2026, 12, 15), false, 2L))
                    .forEach(repo::save);
            repo.findAll().forEach(System.out::println);
        };
    }
}