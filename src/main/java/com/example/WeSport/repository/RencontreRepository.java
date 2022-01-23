package com.example.WeSport.repository;


import com.example.WeSport.models.Rencontre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RencontreRepository extends JpaRepository<Rencontre, Long> {

    Optional<Rencontre> findRencontreBySport(String sport);
    Optional<Rencontre> findRencontreById(Long id);




}
