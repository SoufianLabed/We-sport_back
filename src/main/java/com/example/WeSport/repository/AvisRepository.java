package com.example.WeSport.repository;

import com.example.WeSport.models.Avis;
import com.example.WeSport.models.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvisRepository extends JpaRepository<Avis, Long> {
/*
    @Override
    Optional<Avis> findById(Long id);

    Optional<Avis> findAvisByNote_joueur(Long id);*/
}
