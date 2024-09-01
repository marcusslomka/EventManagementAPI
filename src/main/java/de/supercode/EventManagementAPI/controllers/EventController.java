package de.supercode.EventManagementAPI.controllers;

import de.supercode.EventManagementAPI.entities.Event;
import de.supercode.EventManagementAPI.entities.Participant;
import de.supercode.EventManagementAPI.services.EventService;
import de.supercode.EventManagementAPI.services.ParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/events")
public class EventController {

    ParticipantService participantService;
    EventService eventService;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.createEvent(event));
    }
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        return ResponseEntity.status(HttpStatus.FOUND).body(eventService.getAllEvents());
    }

    @GetMapping("/{eventID}")
    public ResponseEntity<Event> getEventDetails(long eventID){
        return ResponseEntity.status(HttpStatus.FOUND).body(eventService.getEventDetails(eventID));
    }
    @DeleteMapping("/{eventID}")
    public ResponseEntity<Void> deleteEvent(long eventID){
        eventService.deleteEvent(eventID);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{eventID}")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event, long eventID){
        return ResponseEntity.ok().body(eventService.updateEvent(event,eventID));
    }
    //-----------------------
    @PostMapping("/{eventID}/participants")
    public ResponseEntity<Participant> AddParticipantToEvent (@PathVariable long eventID, @RequestBody Participant participant){
        return ResponseEntity.ok(participantService.addParticipantToEvent(eventID,participant).orElseThrow());
    }
    @GetMapping
    public ResponseEntity<List<Participant>> getAllParticipants(){
        return participantService
    }
}
