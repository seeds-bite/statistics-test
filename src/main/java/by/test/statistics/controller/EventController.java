package by.test.statistics.controller;

import by.test.statistics.constant.Constants;
import by.test.statistics.exception.PagingAndSortingException;
import by.test.statistics.model.Event;
import by.test.statistics.model.GroupedResponseDTO;
import by.test.statistics.model.PagingAndSorting;
import by.test.statistics.model.ResponseDTO;
import by.test.statistics.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> saveEvent(@RequestBody Event event){
        List<Event> createdEvent = eventService.saveEvent(event);
        if (createdEvent == null) {
            return new ResponseEntity<>(new ResponseDTO(null, Constants.FAILED_CREATE_EVENT), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new ResponseDTO(createdEvent, Constants.EVENT_CREATED_SUCCESSFULLY), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupedResponseDTO> getAllEvents (PagingAndSorting pagingAndSorting){
        Map<LocalDate, List<Event>> events;
        try {
            events = eventService.findEvents(pagingAndSorting);
        } catch (PagingAndSortingException ex){
            return new ResponseEntity<>(new GroupedResponseDTO(null, ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new GroupedResponseDTO(events, null), HttpStatus.OK);
    }

}
