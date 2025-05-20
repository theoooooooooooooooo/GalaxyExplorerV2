package com.example.galaxiexplorer.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "planete")
public class Planete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nom;
    private String description;
    private String image;
    private Integer positionX;
    private Integer positionY;
    private Boolean habitable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}