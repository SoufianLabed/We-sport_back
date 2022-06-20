package com.example.WeSport.controllers;


import com.example.WeSport.models.Avis;
import com.example.WeSport.models.Participation;
import com.example.WeSport.models.Rencontre;
import com.example.WeSport.payload.request.SignupRequest;
import com.example.WeSport.payload.response.JwtResponse;
import com.example.WeSport.payload.response.MessageResponse;
import com.example.WeSport.repository.AvisRepository;
import com.example.WeSport.repository.ParticipationRepository;
import com.example.WeSport.repository.RencontreRepository;
import com.example.WeSport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.WeSport.models.ERencontre;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    RencontreRepository rencontreRepository;

    @Autowired
    ParticipationRepository participationRepository;

    @Autowired
    AvisRepository avisRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @PostMapping("/createRencontre")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity createRencontre(@Valid @RequestBody Rencontre rencontre) {

        System.out.println("ici "+rencontre.toString());
        rencontreRepository.save(rencontre);
        Participation participation = Participation.builder()
                .rencontreId(rencontre.getId())
                .playerId(rencontre.getOwner())
                .build();

        participationRepository.save(participation);
        return ResponseEntity.ok(new MessageResponse("Meeting registered successfully!"));
    }

    @PostMapping("/createParticipation")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity createParticipation(@Valid @RequestBody Participation participation) {

        System.out.println("participation : "+participation.toString());
        participationRepository.save(participation);

        return ResponseEntity.ok(new MessageResponse("Participation registered successfully!"));
    }

    @PostMapping("/createAvis")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createAvis(@Valid @RequestBody Avis avis) {
        avisRepository.save(avis);
        System.out.println("Avis : "+avis.toString());

        return ResponseEntity.ok(new MessageResponse("Avis registered successfully!"));
    }

    @GetMapping("/meeting")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getAllRencontre() {
        List rencontres = rencontreRepository.findAll();
        return ResponseEntity.ok(rencontres);
    }

    // RENCONTRE REQUEST
    @GetMapping (value = "/getRencontreBySport/{sport}")
    //@PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<?> getRencontreBySport(@PathVariable String sport) {
        System.out.println(sport);

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

        return ResponseEntity.ok(rencontre);

    }

    @GetMapping (value = "/getRencontreById/{id}")
    //@PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<?> getRencontreById(@PathVariable Long id) {
        System.out.println(id);

        Optional<Rencontre> rencontre = rencontreRepository.findRencontreById(id);
        return ResponseEntity.ok(rencontre);
    }


    @GetMapping (value = "/getRencontreByIdUser/{id}")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getRencontreByIdCreator(@PathVariable Long id) {
        System.out.println(id);

        List<Rencontre> rencontre = rencontreRepository.findRencontresByOwner(id);
        return ResponseEntity.ok(rencontre);
    }

    // PARTICIPATION REQUEST


    @GetMapping (value = "/getParticipationByIdUser/{id}")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> findParticipationByUser_id(@PathVariable Long id) {
        System.out.println(id);

        List<Participation> participation = participationRepository.findParticipationsByPlayerId(id);
        return ResponseEntity.ok(participation);
    }


    @GetMapping (value = "/getParticipationByIdRencontre/{id}")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> findParticipationByRencontre_id(@PathVariable Long id) {
        System.out.println(id);

        List<Participation> participation = participationRepository.findParticipationsByRencontreId(id);
        return ResponseEntity.ok(participation);
    }



}