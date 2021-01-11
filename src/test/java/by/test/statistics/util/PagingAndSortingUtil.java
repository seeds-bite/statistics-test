package by.test.statistics.util;

import by.test.statistics.model.Event;
import by.test.statistics.model.EventType;
import by.test.statistics.model.PagingAndSorting;

public class PagingAndSortingUtil {

    public static PagingAndSorting createPagingAndSorting() {
        PagingAndSorting pagingAndSorting = new PagingAndSorting();
        pagingAndSorting.setLimit(4);
        pagingAndSorting.setPage(2);
        pagingAndSorting.setType(EventType.INFO);
        return pagingAndSorting;
    }
}
