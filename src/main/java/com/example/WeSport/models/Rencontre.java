package com.example.WeSport.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rencontre")
public class Rencontre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERencontre sport;

    @NotBlank
    private int nombre_joueur;

    private Date createdAt;

    private Date plannedAt;

    private String description;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERencontre getSport() {
        return sport;
    }

    public void setSport(ERencontre sport) {
        this.sport = sport;
    }

    public int getNombre_joueur() {
        return nombre_joueur;
    }

    public void setNombre_joueur(int nombre_joueur) {
        this.nombre_joueur = nombre_joueur;
    }




}
