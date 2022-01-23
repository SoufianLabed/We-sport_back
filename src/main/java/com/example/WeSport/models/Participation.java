package com.example.WeSport.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "participation")
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long rencontre_id;

    private Long user_id;

    public Participation(Long id, Long rencontre_id, Long user_id) {
        this.id = id;
        this.rencontre_id = rencontre_id;
        this.user_id = user_id;
    }

    public Participation(Long rencontre_id, Long user_id) {
        this.rencontre_id = rencontre_id;
        this.user_id = user_id;
    }

    public Participation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRencontre_id() {
        return rencontre_id;
    }

    public void setRencontre_id(Long rencontre_id) {
        this.rencontre_id = rencontre_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
