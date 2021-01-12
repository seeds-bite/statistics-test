package by.test.statistics;

import by.test.statistics.config.TestAppConfig;
import by.test.statistics.model.Event;
import by.test.statistics.service.EventService;
import by.test.statistics.util.EventUtil;
import by.test.statistics.util.PagingAndSortingUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfig.class)
@SpringBootTest
public class EventServiceTest {

    private static final Logger log = LoggerFactory.getLogger(EventServiceTest.class);

    @Resource
    private EventService eventService;

    @Test
    public void testSaveEvent() throws Exception {
//        Event event = eventService.saveEvent(EventUtil.createEvent());
//        log.info(event.toString());
    }

    @Test
    public void testFindEvents() throws Exception{
//        List<Event> events = eventService.findEvents(PagingAndSortingUtil.createPagingAndSorting());
//        events.forEach(event -> log.info(event.toString()));
    }
}
