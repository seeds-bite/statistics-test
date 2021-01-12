package by.test.statistics.constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constants {

    private static Properties properties = new Properties();

    static {
        String propFileName = "constants.properties";
        InputStream inputStream = Constants.class.getClassLoader().getResourceAsStream(propFileName);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("No property file found");
        }
    }
    //properties
    public static final String SORT_BY_CREATED = properties.getProperty("sort.created");
    public static final int DEFAULT_PAGE_LIMIT = Integer.parseInt(properties.getProperty("default.limit"));
    public static final int DEFAULT_PAGE_NUMBER = Integer.parseInt(properties.getProperty("default.page"));
    //messages
    public static final String FAILED_CREATE_EVENT = properties.getProperty("failed.create.event");
    public static final String INCORRECT_VALUE = properties.getProperty("incorrect.value");
    public static final String EVENTS_NOT_FOUND = properties.getProperty("events.not.found");
    public static final String EVENT_CREATED_SUCCESSFULLY = properties.getProperty("event.created.successfully");

}
