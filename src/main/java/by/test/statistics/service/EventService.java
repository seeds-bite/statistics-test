package by.test.statistics.service;

import by.test.statistics.exception.PagingAndSortingException;
import by.test.statistics.model.Event;
import by.test.statistics.model.PagingAndSorting;

import java.util.List;

public interface EventService {

    List<Event> findEvents(PagingAndSorting pagingAndSorting) throws PagingAndSortingException;
    Event saveEvent(Event event);
}
