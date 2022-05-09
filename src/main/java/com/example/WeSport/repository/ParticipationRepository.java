package com.example.WeSport.repository;

import com.example.WeSport.models.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {


       Optional<Participation> findParticipationById(Long id);

       List<Participation> findParticipationsByPlayerId(Long playerId);

       List<Participation> findParticipationsByRencontreId(Long rencontreId);
}
