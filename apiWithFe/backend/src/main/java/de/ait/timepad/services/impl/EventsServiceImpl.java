package de.ait.timepad.services.impl;

import de.ait.timepad.dto.EventDto;
import de.ait.timepad.dto.EventsDto;
import de.ait.timepad.dto.NewEventDto;
import de.ait.timepad.dto.UserDto;
import de.ait.timepad.exceptions.NotFoundException;
import de.ait.timepad.models.Event;
import de.ait.timepad.repositories.EventsRepository;
import de.ait.timepad.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.timepad.dto.EventDto.from;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@Service
public class EventsServiceImpl implements EventsService {

    private final EventsRepository eventsRepository;

    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        Event event = Event.builder().text(newEvent.getText()).build();

        eventsRepository.save(event);

        return from(event);
    }

    @Override
    public EventsDto getEvents() {
        List<Event> events = eventsRepository.findAll();
        return EventsDto.builder().events(from(events)).count(events.size()).build();
    }

    @Override
    public EventDto getEvent(Long id) {
        return EventDto.from(getEventOrThrow(id));
    }


    private Event getEventOrThrow(Long id) {
        return eventsRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Event with id <" + id + "> not found"));
    }
}
