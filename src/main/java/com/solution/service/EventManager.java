package com.solution.service;

import com.solution.bean.Event;
import com.solution.bean.Session;
import com.solution.bean.Track;
import com.solution.constant.SessionType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.solution.constant.SessionType.EVENING;
import static com.solution.constant.SessionType.LUNCH;
import static com.solution.constant.SessionType.MORNING;

/**
 * Created by Ali on 12/31/2016.
 */
public class EventManager {


    public List<Event> createEvents(List<String> input) {
        String temp;
        Integer duration;
        List<Event> events = new ArrayList<>();
        for (String line : input) {
            temp = line.substring(line.lastIndexOf(" ")+1, line.length());
            if("lightning".equalsIgnoreCase(temp)){
                duration = 5;
            }else{
                if(!"min".equalsIgnoreCase(temp.substring(temp.length()-3,temp.length()))){
                    throw new IllegalArgumentException("Invalid input");
                }
                duration = Integer.parseInt(temp.replaceAll("\\D+",""));
            }
            Event event = new Event();
            event.setTitle(line);
            event.setDuration(duration);
            events.add(event);
        }
        return events;
    }


    public List<Track> arrangeEvents(List<Event> events) {
        List<Track> tracks = new ArrayList<>();

        while(!events.isEmpty()){

            Session morningSession = new Session();
            morningSession.setSessionType(MORNING);
            morningSession.setEvents(getEvents(events, 180));

            Session afternoonSession = new Session();
            afternoonSession.setSessionType(LUNCH);
            Event event = new Event();
            event.setTitle("Lunch");
            event.setDuration(60);
            List<Event> events1 = new ArrayList<>();
            events1.add(event);
            afternoonSession.setEvents(events1);

            Session eveningSession = new Session();
            eveningSession.setSessionType(EVENING);
            List<Event> eveningEvents = getEvents(events, 240);
            Event networkEvent = new Event();
            networkEvent.setDuration(60);
            networkEvent.setTitle("Networking Event");
            eveningEvents.add(networkEvent);
            eveningSession.setEvents(eveningEvents);

            List<Session> sessions = new ArrayList<>();
            sessions.add(morningSession);
            sessions.add(afternoonSession);
            sessions.add(eveningSession);

            Track track = new Track();
            track.setSessions(sessions);
            tracks.add(track);
        }
        return tracks;
    }

    public void printEvents(List<Track> tracks){
        for (int i = 0; i < tracks.size(); i++) {
            System.out.println("Track "+(i+1)+":");
            Track track = tracks.get(i);
            int currentHour = 9;
            int currentMin = 0;
            for (Session session : track.getSessions()) {
                for (Event event : session.getEvents()) {
                    String time = formatTime(currentHour, currentMin, session.getSessionType());
                    System.out.println(time + " " + event.getTitle());
                    int t = event.getDuration();
                    while(t>=60){
                        currentHour += 1;
                        t = t-60;
                    }
                    currentMin += t;
                    if(currentMin >= 60){
                        currentMin = currentMin-60;
                        currentHour += 1;
                    }
                }
            }
            System.out.println();
        }
    }

    private String formatTime(int currentHr, int currentMin, SessionType sessionType) {
        String t;
        if(sessionType == MORNING){
            t = "AM";
        }else{
            t = "PM";
        }
        return String.format("%02d", currentHr > 12 ? currentHr - 12 : currentHr)+":"+String.format("%02d", currentMin)+t;
    }


    private List<Event> getEvents(List<Event> events, int timeInMinutes) {
        Iterator<Event> iterator = events.iterator();
        List<Event> eventForGivenSession = new ArrayList<>();
        while (iterator.hasNext()){
            Event event = iterator.next();
            if(timeInMinutes >= event.getDuration()){
                timeInMinutes -= event.getDuration();
                eventForGivenSession.add(event);
                iterator.remove();
            }
        }
        return eventForGivenSession;
    }

}
