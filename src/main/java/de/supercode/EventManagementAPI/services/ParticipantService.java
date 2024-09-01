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

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

//    public boolean checkIfParticipantNameExists(String name){
//        if(this.participantRepository.findByName(name).isEmpty())
//            return false;
//        else return true;
//  }
    public Event addParticipantToEvent(long eventID, Participant participant){
        Event toAddEvent = eventRepository.findById(eventID).get();
        toAddEvent.addParticipantToEvent(participant);
        return eventRepository.save(toAddEvent);

    }

    public Participant getParticipantByID(long id){
        return participantRepository.findById(id).get();
    }
    public void deleteParticipant(long id){
        participantRepository.delete(participantRepository.findById(id).orElseThrow());
    }
    public void updateParticipant(long id, Participant participant){
        Participant toUpdateParticipant = participantRepository.findById(id).get();
        toUpdateParticipant.setEmail(participant.getEmail());
        toUpdateParticipant.setConfirmed(participant.isConfirmed());
        toUpdateParticipant.setName(participant.getName());
        participantRepository.save(toUpdateParticipant);
    }

    public List<Participant> getAllParticipants(){
        return participantRepository.findAll();
    }
}
