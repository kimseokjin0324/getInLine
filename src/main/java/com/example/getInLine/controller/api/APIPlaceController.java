package com.example.getInLine.controller.api;

import com.example.getInLine.constant.PlaceType;
import com.example.getInLine.dto.APIDataResponse;
import com.example.getInLine.dto.PlaceDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api")
@RestController
public class APIPlaceController {

    @GetMapping("/places")
    public APIDataResponse<List<PlaceDTO>> getPlaces() {
        return APIDataResponse.of(List.of(PlaceDTO.of(
                PlaceType.COMMON,
                "랄라배드민턴장",
                "서울시 강남구 강남대로 1234",
                "010-1234-5678",
                30,
<<<<<<< HEAD
                "신장개업",
                LocalDateTime.now(),
                LocalDateTime.now()
=======
                "신장개업"
>>>>>>> #2-api
        )));
    }

    @PostMapping("/places")
    public Boolean createPlace() {
        return true;
    }

    @GetMapping("/places/{placeId}")
    public APIDataResponse<PlaceDTO> getPlace(@PathVariable String placeId) {
        if (placeId.equals("2")) {
            return APIDataResponse.of(null);
        }
        return APIDataResponse.of(PlaceDTO.of(
                PlaceType.COMMON,
                "랄라배드민턴장",
                "서울시 강남구 강남대로 1234",
                "010-1234-5678",
                30,
<<<<<<< HEAD
                "신장개업",
                LocalDateTime.now(),
                LocalDateTime.now()
=======
                "신장개업"
>>>>>>> #2-api
        ));

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
