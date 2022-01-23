package com.example.WeSport.controllers;


import com.example.WeSport.models.Participation;
import com.example.WeSport.models.Rencontre;
import com.example.WeSport.payload.request.SignupRequest;
import com.example.WeSport.payload.response.JwtResponse;
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
    @PreAuthorize("hasRole('MODERATOR')")
    public String createRencontre(@Valid @RequestBody Rencontre rencontre) {

        rencontreRepository.save(rencontre);
        return "Well added";

    }

    @GetMapping("/getAllRencontre")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getAllRencontre() {

        List rencontres = rencontreRepository.findAll();
        return ResponseEntity.ok(rencontres);
    }

    // RENCONTRE REQUEST
    @GetMapping (value = "/getRencontreBySport/{sport}")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<?> getRencontreBySport(@PathVariable String sport) {
        System.out.println(sport);

        Optional<Rencontre> rencontre;

        switch (sport.toLowerCase()) {
            case "football":
                rencontre = rencontreRepository.findRencontreBySport(ERencontre.FOOTBALL.name());
                break;

            case "rugby":
                rencontre = rencontreRepository.findRencontreBySport(ERencontre.RUGBY.name());
                break;

            default:
                rencontre = rencontreRepository.findRencontreBySport(ERencontre.FOOTBALL.name());
        }

        return ResponseEntity.ok(rencontre);

    }

    @GetMapping (value = "/getRencontreById/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<?> getRencontreById(@PathVariable Long id) {
        System.out.println(id);

        Optional<Rencontre> rencontre = rencontreRepository.findRencontreById(id);
        return ResponseEntity.ok(rencontre);
    }

    // PARTICIPATION REQUEST


    @GetMapping (value = "/getParticipationByIdUser/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> findParticipationByUser_id(@PathVariable Long id) {
        System.out.println(id);

        Optional<Participation> participation = participationRepository.findParticipationByUser_id(id);
        return ResponseEntity.ok(participation);
    }

    @GetMapping (value = "/getParticipationByIdRencontre/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> findParticipationByRencontre_id(@PathVariable Long id) {
        System.out.println(id);

        Optional<Participation> participation = participationRepository.findParticipationByRencontre_id(id);
        return ResponseEntity.ok(participation);
    }

    @GetMapping (value = "/getParticipationByIdParticipation/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> findParticipationById(@PathVariable Long id) {
        System.out.println(id);

        Optional<Participation> participation = participationRepository.findParticipationById(id);
        return ResponseEntity.ok(participation);
    }


}