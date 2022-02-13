package com.example.WeSport.repository;

import com.example.WeSport.models.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {


       //Optional<Participation> findParticipationByUser_id(Long id);
      /* @Query("FROM Participation g where g.user_id = :user_id")
       Optional <Participation> findParticipationByUser_id(@Param("user_id") Long userId);*/

      // @Query("FROM Participation g where g.rencontre_id = :rencontre_id")
      // Optional <Participation> findParticipationByRencontre_id(@Param("rencontre_id") Long rencontreId);

       Optional<Participation> findParticipationById(Long id);






}
