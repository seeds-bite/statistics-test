package by.test.statistics.controller;

import by.test.statistics.constant.Constants;
import by.test.statistics.exception.PagingAndSortingException;
import by.test.statistics.model.Event;
import by.test.statistics.model.PagingAndSorting;
import by.test.statistics.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveEvent(@RequestBody(required = true) Event event){
        Event createdEvent = eventService.saveEvent(event);
        if (createdEvent == null) {
            return new ResponseEntity<Object>(Constants.FAILED_CREATE_EVENT, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(event, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllEvents (PagingAndSorting pagingAndSorting){
        List<Event> events;
        try {
            events = eventService.findEvents(pagingAndSorting);
        } catch (PagingAndSortingException ex){
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        if(events.isEmpty()){
            return new ResponseEntity<Object>(Constants.EVENTS_NOT_FOUND, HttpStatus.OK);
        }
        return new ResponseEntity<Object>(events, HttpStatus.OK);
    }

}
