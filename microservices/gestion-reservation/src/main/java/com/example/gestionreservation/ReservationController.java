package com.example.gestionreservation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    // Replaces Lombok's @RequiredArgsConstructor
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public Reservation createReservation(
            @RequestParam Long studentId,
            @RequestParam String yearUniv,
            @RequestParam String startDate,
            @RequestParam String endDate) {

        return reservationService.createReservation(
                studentId,
                yearUniv,
                LocalDate.parse(startDate),
                LocalDate.parse(endDate)
        );
    }
}