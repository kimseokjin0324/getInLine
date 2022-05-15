package com.example.getInLine.controller.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/events")
    public List<String> getEvents() {
        return List.of("event1", "event2");

    }

    @PostMapping("/events")
    public Boolean createEvent() {
        return true;
    }

    @GetMapping("/events/{eventId}")
    public String getEvent(@PathVariable String eventId) {
        return "event" + eventId;
    }

    @PostMapping("/events/{eventId}")
    public Boolean modifyEvent(@PathVariable String eventId) {
        return true;
    }

    @DeleteMapping("/events/{eventId}")
    public Boolean removeEvent(@PathVariable String eventId) {
        return true;
    }

}
