package com.example.gestionreservation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "reservations")
public interface ReservationRepo extends CrudRepository<Reservation, Long> {

    // GET /API/reservations/search/findByStudentId?studentId=1
    List<Reservation> findByStudentId(@Param("studentId") Long studentId);
}