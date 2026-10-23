package com.example.gestionreservation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean estValide;
    private Long studentId;

    // Empty constructor: JPA needs it
    public Reservation() {
    }

    public Reservation(LocalDate startDate, LocalDate endDate, boolean estValide, Long studentId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.estValide = estValide;
        this.studentId = studentId;
    }

    public Long getIdReservation() { return idReservation; }
    public void setIdReservation(Long idReservation) { this.idReservation = idReservation; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public boolean isEstValide() { return estValide; }
    public void setEstValide(boolean estValide) { this.estValide = estValide; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    @Override
    public String toString() {
        return "Reservation{idReservation=" + idReservation + ", startDate=" + startDate
                + ", endDate=" + endDate + ", estValide=" + estValide + ", studentId=" + studentId + "}";
    }
}