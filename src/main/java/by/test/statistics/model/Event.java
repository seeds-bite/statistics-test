package by.test.statistics.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private EventType type;

    public Date getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    public Event(){
    }
    public Event(String title, String description, EventType type) {
        this.title = title;
        this.description = description;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id.equals(event.id) &&
                title.equals(event.title) &&
                description.equals(event.description) &&
                type == event.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, type);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}
