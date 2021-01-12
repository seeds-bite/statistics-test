package by.test.statistics;

import by.test.statistics.exception.PagingAndSortingException;
import by.test.statistics.model.Event;
import by.test.statistics.model.PagingAndSorting;
import by.test.statistics.service.EventService;
import by.test.statistics.util.EventUtil;
import by.test.statistics.util.PagingAndSortingUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsApplicationTest {

    @Autowired
    private EventService eventService;

    @Test
    public void testSaveEvent() {
        Event testEvent = EventUtil.createEvent();
        List<Event> events = eventService.saveEvent(testEvent);
        assertEquals(events.get(0), testEvent);

    }

    @Test
    public void testFindEvents() throws PagingAndSortingException {
        Map<LocalDate, List<Event>> groupedEvents = eventService.findEvents(PagingAndSortingUtil.createPagingAndSorting());
        assertNotNull(groupedEvents);
    }

}
