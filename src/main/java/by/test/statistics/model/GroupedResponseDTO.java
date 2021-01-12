package by.test.statistics.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class GroupedResponseDTO {

    private Map<LocalDate, List<Event>> events;
    private String message;

    public Map<LocalDate, List<Event>> getEvents() {
        return events;
    }

    public void setEvents(Map<LocalDate, List<Event>> events) {
        this.events = events;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GroupedResponseDTO(){}

    public GroupedResponseDTO(Map<LocalDate, List<Event>> events, String message) {
        this.events = events;
        this.message = message;
    }
}
