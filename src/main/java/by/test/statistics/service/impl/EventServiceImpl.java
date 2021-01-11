package by.test.statistics.service.impl;

import by.test.statistics.constant.Constants;
import by.test.statistics.exception.PagingAndSortingException;
import by.test.statistics.model.Event;
import by.test.statistics.model.PagingAndSorting;
import by.test.statistics.repository.EventRepository;
import by.test.statistics.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> findEvents(PagingAndSorting pagingAndSorting) throws PagingAndSortingException {
        List<Event> events;
        if(pagingAndSorting.getPage() < 0 || pagingAndSorting.getLimit() < 1){
            throw new PagingAndSortingException(Constants.INCORRECT_VALUE);
        }
        Pageable pageable = PageRequest.of(pagingAndSorting.getPage(), pagingAndSorting.getLimit(), Sort.by(Constants.SORT_BY_CREATED));
        if (pagingAndSorting.getType() != null) {
            events = eventRepository.findAllByType(pagingAndSorting.getType(), pageable);
        } else {
            events = eventRepository.findAll(Sort.by(Constants.SORT_BY_CREATED));
        }
        return events;
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
}
