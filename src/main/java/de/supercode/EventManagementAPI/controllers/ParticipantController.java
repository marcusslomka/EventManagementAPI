package de.supercode.EventManagementAPI.controllers;

import de.supercode.EventManagementAPI.entities.Participant;
import de.supercode.EventManagementAPI.services.ParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/participant")
public class ParticipantController {

    ParticipantService participantService;

    @PostMapping
    public Optional<ResponseEntity<Participant>> createParticipant(@RequestBody Participant participant){
        return ResponseEntity.status(HttpStatus.CREATED).body(participantService.createParticipant(participant));
    }
}
