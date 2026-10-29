package com.example.gestionreservation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "candidat-service")
public interface StudentClient {

    @GetMapping(value = "/API/candidats/{student-id}", produces = "application/json")
    Student getStudentById(@PathVariable("student-id") Long studentId);
}