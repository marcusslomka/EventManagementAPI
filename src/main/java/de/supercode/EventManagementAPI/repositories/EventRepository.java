package de.supercode.EventManagementAPI.repositories;

import de.supercode.EventManagementAPI.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
