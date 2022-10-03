package com.example.WeSport.services;

import com.example.WeSport.models.Avis;
import com.example.WeSport.payload.response.MessageResponse;
import com.example.WeSport.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public class AvisService {

    @Autowired
    AvisRepository avisRepository;

    public MessageResponse createAvis(@Valid @RequestBody Avis avis) {
        avisRepository.save(avis);
        return new MessageResponse("Avis registered successfully!");
    }
}
