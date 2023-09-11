package de.ait.tracker.controllers.api;

import de.ait.tracker.dto.EventDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/events")
public interface EventsApi {

    @GetMapping
    List<EventDto> getAll();
}
