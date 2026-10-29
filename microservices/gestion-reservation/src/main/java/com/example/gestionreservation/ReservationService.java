package com.example.gestionreservation;

import feign.FeignException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationService {

    private final StudentClient studentClient;
    private final ReservationRepo reservationRepo;

    // Replaces Lombok's @RequiredArgsConstructor: Spring injects both here
    public ReservationService(StudentClient studentClient, ReservationRepo reservationRepo) {
        this.studentClient = studentClient;
        this.reservationRepo = reservationRepo;
    }

    public Reservation createReservation(Long studentId, String yearUniv, LocalDate startDate, LocalDate endDate) {
        // 1. Check that the student exists, through Feign
        Student student;
        try {
            student = studentClient.getStudentById(studentId);
        } catch (FeignException.NotFound e) {
            throw new StudentNotFoundException(studentId);
        }
        System.out.println("Student recu du MS candidat : " + student);

        // 2. Build the reservation
        Reservation res = new Reservation(startDate, endDate, true, studentId);

        // 3. Save it
        return reservationRepo.save(res);
    }
}