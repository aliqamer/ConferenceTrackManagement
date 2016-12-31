package com.solution.driver;

import com.solution.bean.Event;
import com.solution.bean.Track;
import com.solution.service.EventManager;
import com.solution.util.InputReader;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ali on 12/31/2016.
 */
public class MainConference {

    private static MainConference mainConference = new MainConference();

    private InputReader reader = new InputReader();

    private EventManager eventManager = new EventManager();

    public static void main(String args[]) {
        mainConference.manageEvents();
    }

    void manageEvents() {

        List<String> input = reader.readInputFile("", "input.txt");

        List<Event> events = eventManager.createEvents(input);
        Collections.sort(events);

        List<Track> tracks = eventManager.arrangeEvents(events);

        eventManager.printEvents(tracks);
    }
}
