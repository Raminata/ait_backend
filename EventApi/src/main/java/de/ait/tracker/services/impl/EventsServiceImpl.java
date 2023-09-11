package de.ait.tracker.services.impl;

import de.ait.tracker.dto.EventDto;
import de.ait.tracker.repositories.EventRepository;
import de.ait.tracker.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.tracker.dto.EventDto.from;

@Service
@RequiredArgsConstructor
public class EventsServiceImpl implements EventsService {

    private final EventRepository repository;

    @Override
    public List<EventDto> getAll() {
        return from(repository.findAll());
    }
}
