package com.example.getInLine.controller.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIPlaceController {

    @GetMapping("/places")
    public List<String> getPlaces() {
        return List.of("place1", "place2");
    }

    @PostMapping("/places")
    public Boolean createPlace() {
        return true;
    }

    @GetMapping("/places/{placeId}")
    public String getPlace(@PathVariable String placeId) {
        return "place" + placeId;
    }

    @PostMapping("/places/{placeId}")
    public Boolean modifyPlace(@PathVariable String placeId) {
        return true;
    }

    @DeleteMapping("/places/{placeId}")
    public Boolean removePlace(@PathVariable String placeId) {
        return true;
    }
}
