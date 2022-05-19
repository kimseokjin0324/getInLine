package com.example.getInLine.dto;

import com.example.getInLine.constant.PlaceType;

<<<<<<< HEAD
import java.time.LocalDateTime;

=======
>>>>>>> #2-api
public record PlaceDTO(
        PlaceType placeType,
        String placeName,
        String address,
        String phoneNumber,
        Integer capacity,
<<<<<<< HEAD
        String memo,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) {
=======
        String memo){

>>>>>>> #2-api
    public static PlaceDTO of(
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            Integer capacity,
<<<<<<< HEAD
            String memo,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {
        return new PlaceDTO(placeType, placeName, address, phoneNumber, capacity, memo, createdAt, modifiedAt);
    }
}
=======
            String memo
    ) {
     return new PlaceDTO(placeType, placeName, address, phoneNumber, capacity, memo);
    }
}
>>>>>>> #2-api
