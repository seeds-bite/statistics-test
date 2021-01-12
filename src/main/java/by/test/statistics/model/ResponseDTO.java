package by.test.statistics.model;

import java.util.List;

public class ResponseDTO {

    private List<Event> events;
    private String message;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseDTO(){}

    public ResponseDTO(List<Event> events, String message) {
        this.events = events;
        this.message = message;
    }
}
