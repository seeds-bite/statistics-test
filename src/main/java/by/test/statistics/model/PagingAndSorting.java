package by.test.statistics.model;

import by.test.statistics.constant.Constants;


public class PagingAndSorting {
    private int page = Constants.DEFAULT_PAGE_NUMBER;
    private int limit = Constants.DEFAULT_PAGE_LIMIT;
    private EventType type;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public PagingAndSorting(){}

}
