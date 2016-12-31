package com.solution.bean;

/**
 * Created by Ali on 12/31/2016.
 */
public class Event implements Comparable<Event> {

    private String title;
    private Integer duration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }

    @Override
    public int compareTo(Event other) {
        return other.duration - this.duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (!title.equals(event.title)) return false;
        return duration.equals(event.duration);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + duration.hashCode();
        return result;
    }
}
