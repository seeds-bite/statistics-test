package by.test.statistics.service;

import by.test.statistics.exception.PagingAndSortingException;
import by.test.statistics.model.Event;
import by.test.statistics.model.PagingAndSorting;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EventService {

    Map<LocalDate, List<Event>> findEvents(PagingAndSorting pagingAndSorting) throws PagingAndSortingException;
    List<Event> saveEvent(Event event);
}
