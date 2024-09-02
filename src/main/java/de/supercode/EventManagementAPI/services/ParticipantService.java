package de.supercode.EventManagementAPI.services;

import de.supercode.EventManagementAPI.entities.Event;
import de.supercode.EventManagementAPI.entities.Participant;
import de.supercode.EventManagementAPI.repositories.EventRepository;
import de.supercode.EventManagementAPI.repositories.ParticipantRepository;
import jakarta.servlet.http.Part;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    ParticipantRepository participantRepository;
    EventRepository eventRepository;

    public ParticipantService(ParticipantRepository participantRepository, EventRepository eventRepository) {
        this.participantRepository = participantRepository;
        this.eventRepository = eventRepository;
    }

    //    public boolean checkIfParticipantNameExists(String name){
//        if(this.participantRepository.findByName(name).isEmpty())
//            return false;
//        else return true;
//  }
    public Event addParticipantToEvent(long eventID, Participant participant){
        Event toAddEvent = eventRepository.findById(eventID).get();
        toAddEvent.addParticipantToEvent(participant);
        participantRepository.save(participant);
        return eventRepository.save(toAddEvent);
    }

    public Participant getParticipantByID(long eventID,long participantID){
        Event event = eventRepository.findById(eventID).orElseThrow();
        return event.getParticipantByID(participantID);
    }
    public void deleteParticipant(long eventID, long participantID){
        Event event = eventRepository.findById(eventID).orElseThrow();
        event.getParticipants().remove(participantID);
    }
    public void updateParticipant(long eventID, long participantID, Participant participant){
        Event event = eventRepository.findById(eventID).get();
        Participant toUpdateParticipant = event.getParticipantByID(participantID);
        toUpdateParticipant.setConfirmed(participant.isConfirmed());
        participantRepository.save(toUpdateParticipant);
    }

    public List<Participant> getAllParticipants(long eventID){
        Event event = eventRepository.findById(eventID).orElseThrow();
        return event.getParticipants();
    }
}
