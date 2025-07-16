package com.example.galaxiexplorer.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "galaxy")
public class Galaxy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nom;
    private String description;

    @OneToMany(mappedBy = "galaxy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Planete> planetes;

    public Galaxy() {
    }

    public Galaxy(Long id, String nom, String description, List<Planete> planetes) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.planetes = planetes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Planete> getPlanetes() {
        return planetes;
    }

    public void setPlanetes(List<Planete> planetes) {
        this.planetes = planetes;
    }
}