package com.example.gestionreservation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long studentId) {
        super("Etudiant introuvable : id = " + studentId);
    }
}