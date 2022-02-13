package com.example.WeSport.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rencontre")
public class Rencontre {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERencontre sport;

    @NotBlank
    private int nombre_joueur;

    private Date createdAt;

    private Date plannedAt;

    private String description;

    @Override
    public String toString() {
        return "Rencontre{" +
                "id=" + id +
                ", sport=" + sport +
                ", nombre_joueur=" + nombre_joueur +
                ", createdAt=" + createdAt +
                ", plannedAt=" + plannedAt +
                ", description='" + description + '\'' +
              //  ", id_owner=" + id_owner +
                '}';
    }
}
