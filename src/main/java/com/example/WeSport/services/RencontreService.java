package com.example.WeSport.services;

import com.example.WeSport.models.ERencontre;
import com.example.WeSport.models.Participation;
import com.example.WeSport.models.Rencontre;
import com.example.WeSport.payload.response.MessageResponse;
import com.example.WeSport.repository.ParticipationRepository;
import com.example.WeSport.repository.RencontreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class RencontreService {


    @Autowired
    RencontreRepository rencontreRepository;

    @Autowired
    ParticipationRepository participationRepository;

    public MessageResponse createRencontre(Rencontre rencontre) {
        rencontreRepository.save(rencontre);
        Participation participation = Participation.builder()
                .rencontreId(rencontre.getId())
                .playerId(rencontre.getOwner())
                .build();

        participationRepository.save(participation);
        return new MessageResponse("Meeting registered successfully!");
    }

    public List<Rencontre> getAllRencontre() {
        return rencontreRepository.findAll();
    }

    public List<Rencontre> getRencontreBySport(String sport) {
        List<Rencontre> rencontre;
        switch (sport.toLowerCase()) {
            case "football":
                rencontre = rencontreRepository.findRencontreBySport(ERencontre.FOOTBALL);
                break;
            case "rugby":
                rencontre = rencontreRepository.findRencontreBySport(ERencontre.RUGBY);
                break;
            default:
                rencontre = rencontreRepository.findRencontreBySport(ERencontre.FOOTBALL);
        }
        return rencontre;
    }

    public Optional<Rencontre> getRencontreById(Long id) {
        return rencontreRepository.findRencontreById(id);
    }

    public List<Rencontre> getRencontreByIdCreator(Long id) {
        return rencontreRepository.findRencontresByOwner(id);
    }

}
