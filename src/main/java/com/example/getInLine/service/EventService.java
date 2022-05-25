package com.example.getInLine.service;

import com.example.getInLine.constant.ErrorCode;
import com.example.getInLine.constant.EventStatus;
import com.example.getInLine.dto.EventDTO;
import com.example.getInLine.exception.GeneralException;
import com.example.getInLine.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;

    public List<EventDTO> getEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime) {
        try {
            return eventRepository.findEvents(
                    placeId,
                    eventName,
                    eventStatus,
                    eventStartDatetime,
                    eventEndDatetime
            );
        } catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR);
        }
    }


    public Optional<EventDTO> getEvent(Long eventId) {
        return eventRepository.findEvent(eventId);

    }

    public boolean createEvent(EventDTO eventDTO) {
        return eventRepository.insertEvent(eventDTO);
    }

    public boolean modifyEvent(Long eventId, EventDTO eventDTO) {
        return eventRepository.updateEvent(eventId, eventDTO);
    }

    public boolean removeEvent(Long eventId) {
        return eventRepository.deleteEvent(eventId);
    }

}
