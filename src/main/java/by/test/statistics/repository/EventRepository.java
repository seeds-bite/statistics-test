package by.test.statistics.repository;

import by.test.statistics.model.Event;
import by.test.statistics.model.EventType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByType(EventType type, Pageable pageable);

}
