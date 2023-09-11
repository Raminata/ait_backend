package de.ait.timepad.services;

import de.ait.timepad.dto.*;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface EventsService {
    EventDto addEvent(NewEventDto newEvent);

    EventsDto getEvents();

    EventDto getEvent(Long id);

}
