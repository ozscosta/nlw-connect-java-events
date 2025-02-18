package com.github.ozscosta.events.controller;

import com.github.ozscosta.events.model.Event;
import com.github.ozscosta.events.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public Event createEvent(
            @RequestBody Event request
    ) {
        return eventService.createEvent(request);
    }

    @GetMapping
    public List<Event> listEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("{prettyName}")
    public ResponseEntity<Event> getByPrettyName(@PathVariable String prettyName) {
        Event event = eventService.getByPrettyName(prettyName);

        if (event == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(event);
    }

}
