package com.solution.bean;

import java.util.List;

/**
 * Created by Ali on 12/31/2016.
 */
public class Track {

    private List<Session> sessions;

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "Track{" +
                "sessions=" + sessions +
                '}';
    }
}
