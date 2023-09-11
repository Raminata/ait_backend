package de.ait.timepad.repositories.impl;

import de.ait.timepad.models.Event;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.EventsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Repository
public class EventsRepositoryListImpl implements EventsRepository {

    private static List<Event> events = new ArrayList<>();

    @Override
    public void save(Event event) {
        event.setId((long) (events.size() + 1));
        events.add(event);
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(events);
    }

    @Override
    public Optional<Event> findById(Long id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return Optional.of(event);
            }
        }

        return Optional.empty();
    }

    @Override
    public void delete(Event entity) {
    }

    @Override
    public void clear() {
        events.clear();
    }
}
