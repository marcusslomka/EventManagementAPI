package de.supercode.EventManagementAPI.services;

import de.supercode.EventManagementAPI.entities.Event;
import de.supercode.EventManagementAPI.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    EventRepository eventRepository;

    public Event createEvent(Event event){
        return eventRepository.save(event);
    }
    public Event getEventDetails(long id){
        return eventRepository.findById(id).orElse(null);
    }
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }
    public void deleteEvent(long id){
        eventRepository.deleteById(id);
    }
    public Event updateEvent(Event event, long id){
        Event toUpdatedEvent = eventRepository.findById(id).orElseThrow();
        toUpdatedEvent.setDate(event.getDate());
        toUpdatedEvent.setLocation(event.getLocation());
        toUpdatedEvent.setName(event.getName());
        return eventRepository.save(toUpdatedEvent);
    }
}
