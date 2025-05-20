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
    private Type type;
    private Integer positionX;
    private Integer positionY;
    private Boolean habitable;

    @ManyToOne
    @JoinColumn(name = "galaxy_id")
    private Galaxy galaxy;

    public Planete() {}

    public Planete(Long id, String nom, String description, String image, Type type, Integer positionX, Integer positionY, Boolean habitable, Galaxy galaxy) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.type = type;
        this.positionX = positionX;
        this.positionY = positionY;
        this.habitable = habitable;
        this.galaxy = galaxy;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public Boolean getHabitable() {
        return habitable;
    }

    public void setHabitable(Boolean habitable) {
        this.habitable = habitable;
    }

    public Galaxy getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }
}