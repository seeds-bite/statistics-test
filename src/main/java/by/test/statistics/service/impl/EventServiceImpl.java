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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Map<LocalDate, List<Event>> findEvents(PagingAndSorting pagingAndSorting) throws PagingAndSortingException {
        List<Event> events;
        if(!isPageAndLimitValid(pagingAndSorting)){
            throw new PagingAndSortingException(Constants.INCORRECT_VALUE);
        }
        Pageable pageable = PageRequest.of(pagingAndSorting.getPage() - 1, pagingAndSorting.getLimit(), Sort.by(Constants.SORT_BY_CREATED));
        if (pagingAndSorting.getType() != null) {
            events = eventRepository.findAllByType(pagingAndSorting.getType(), pageable);
        } else {
            events = eventRepository.findAll(Sort.by(Constants.SORT_BY_CREATED));
        }
        return groupEventsByDate(events);
    }

    @Override
    public List<Event> saveEvent(Event event) {
        List<Event> events = new ArrayList<>();
        events.add(eventRepository.save(event));
        return events;
    }

    private boolean isPageAndLimitValid(PagingAndSorting pagingAndSorting){
        return pagingAndSorting.getPage() > 0 && pagingAndSorting.getLimit() > 0;
    }

    private Map<LocalDate, List<Event>> groupEventsByDate(List<Event> events){
        return events.stream()
                .collect(Collectors.groupingBy(k -> k.getCreatedAt().toLocalDate()));
    }
}
