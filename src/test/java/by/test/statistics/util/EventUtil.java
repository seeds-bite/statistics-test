package by.test.statistics.util;

import by.test.statistics.model.Event;
import by.test.statistics.model.EventType;

public class EventUtil {

    public static Event createEvent() {
        Event event = new Event();
        event.setType(EventType.ERROR);
        event.setDescription("New description about ERROR");
        event.setTitle("New ERROR event");
        return event;
    }

}
