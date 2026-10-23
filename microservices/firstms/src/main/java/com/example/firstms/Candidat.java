package com.example.firstms;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Candidat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;

    // Empty constructor: JPA needs it to rebuild a Candidat from the database
    public Candidat() {
    }

    // Our constructor: used to create test candidates in the main class
    public Candidat(String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    // Getters and setters: Spring uses them to read and write the fields (and to make the JSON)
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    // toString: makes the candidate readable when printed in the console
    @Override
    public String toString() {
        return "Candidat{id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + "}";
    }
}