package de.ait.tracker.services;

import de.ait.tracker.dto.EventDto;

import java.util.List;

public interface EventsService {
    List<EventDto> getAll();

}
