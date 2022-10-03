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
import com.example.WeSport.services.AvisService;
import com.example.WeSport.services.ParticipationService;
import com.example.WeSport.services.RencontreService;
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

    @Autowired
    RencontreService rencontreService;

    @Autowired
    ParticipationService participationService;

    @Autowired
    AvisService avisService;

    @PostMapping("/createRencontre")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createRencontre(@Valid @RequestBody Rencontre rencontre) {
        return ResponseEntity.ok(rencontreService.createRencontre(rencontre));
    }

    @PostMapping("/participation")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createParticipation(@Valid @RequestBody Participation participation) {
        return ResponseEntity.ok(participationService.createParticipation(participation));
    }

    @PostMapping("/avis")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createAvis(@Valid @RequestBody Avis avis) {
        return ResponseEntity.ok(avisService.createAvis(avis));
    }

    @GetMapping("/meeting")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getAllRencontre() {
        return ResponseEntity.ok(rencontreService.getAllRencontre());
    }

    @GetMapping (value = "/rencontre/sport/{sport}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getRencontreBySport(@PathVariable String sport) {
        return ResponseEntity.ok(rencontreService.getRencontreBySport(sport));
    }

    @GetMapping (value = "/rencontre/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getRencontreById(@PathVariable Long id) {
        return ResponseEntity.ok(rencontreService.getRencontreById(id));
    }

    @GetMapping (value = "/rencontre/user/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getRencontreByIdCreator(@PathVariable Long id) {
        return ResponseEntity.ok(rencontreService.getRencontreByIdCreator(id));
    }

    @GetMapping (value = "/participation/user/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> findParticipationByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(participationService.findParticipationByUserId(id));
    }

    @GetMapping (value = "/participation/rencontre/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> findParticipationByRencontreId(@PathVariable Long id) {
        return ResponseEntity.ok(participationService.findParticipationByRencontreId(id));
    }
}