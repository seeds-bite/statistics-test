package by.test.statistics.repository;

import by.test.statistics.model.Event;
import by.test.statistics.model.EventType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    List<Event> findAllByType(EventType type, Pageable pageable);
    List<Event> findAll(Sort sort);

}
