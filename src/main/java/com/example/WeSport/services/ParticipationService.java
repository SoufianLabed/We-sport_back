package com.example.WeSport.services;

import com.example.WeSport.models.Participation;
import com.example.WeSport.payload.response.MessageResponse;
import com.example.WeSport.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class ParticipationService {
    @Autowired
    ParticipationRepository participationRepository;

    public List<Participation> findParticipationByUserId(Long id) {
        return participationRepository.findParticipationsByPlayerId(id);
    }

    public List<Participation> findParticipationByRencontreId( Long id) {
        return participationRepository.findParticipationsByRencontreId(id);
    }

    public MessageResponse createParticipation(@Valid @RequestBody Participation participation) {
        participationRepository.save(participation);
        return new MessageResponse("Participation registered successfully!");
    }
}
