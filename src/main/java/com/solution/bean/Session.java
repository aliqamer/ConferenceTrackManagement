package com.solution.bean;

import com.solution.constant.SessionType;

import java.util.List;

/**
 * Created by Ali on 12/31/2016.
 */
public class Session {

    private List<Event> events;
    private SessionType sessionType;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    @Override
    public String toString() {
        return "Session{" +
                "events=" + events +
                ", sessionType=" + sessionType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Session session = (Session) o;

        if (!events.equals(session.events)) return false;
        return sessionType == session.sessionType;

    }

    @Override
    public int hashCode() {
        int result = events.hashCode();
        result = 31 * result + sessionType.hashCode();
        return result;
    }
}
