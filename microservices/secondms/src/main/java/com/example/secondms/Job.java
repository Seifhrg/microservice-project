package com.example.secondms;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String service;
    private Boolean etat; // true = oui (poste disponible), false = non (poste occupe)

    // Empty constructor: JPA needs it to rebuild a Job from the database
    public Job() {
    }

    // Our constructor: used to create test jobs in the main class
    public Job(String service, Boolean etat) {
        this.service = service;
        this.etat = etat;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getService() { return service; }
    public void setService(String service) { this.service = service; }

    public Boolean getEtat() { return etat; }
    public void setEtat(Boolean etat) { this.etat = etat; }

    @Override
    public String toString() {
        return "Job{id=" + id + ", service=" + service + ", etat=" + (etat ? "oui" : "non") + "}";
    }
}
