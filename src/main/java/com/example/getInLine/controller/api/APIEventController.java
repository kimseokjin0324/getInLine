package com.example.getInLine.controller.api;

import com.example.getInLine.exception.GeneralException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/events")
    public List<String> getEvents() throws Exception{
        throw new HttpRequestMethodNotSupportedException("GET");
//        return List.of("event1", "event2");

    }

    @PostMapping("/events")
    public Boolean createEvent() {
        throw new GeneralException("장군님");
//        return true;
    }

    @GetMapping("/events/{eventId}")
    public String getEvent(@PathVariable String eventId) {
        throw new RuntimeException("런타임에러");
        //        return "event" + eventId;
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
