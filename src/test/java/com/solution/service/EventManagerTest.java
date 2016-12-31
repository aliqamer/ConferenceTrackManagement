package com.solution.service;

import com.solution.bean.Event;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ali on 12/31/2016.
 */
public class EventManagerTest {

    private EventManager eventManager;

    @Before
    public void setup() {
        eventManager = new EventManager();
    }

    @Test
    public void shouldReturnValidEventsForGivenInput(){

        List<String> inputString = createInputString();
        List<Event> expectedEvents = createEvents();

        List<Event> actualEvents = eventManager.createEvents(inputString);

        assertTrue(actualEvents.size() == 3);
        assertEquals(actualEvents,expectedEvents);
    }

    @Test
    public void shouldThrowExceptionForInvalidTimeDuration() throws Exception {

        List<String> input = new ArrayList<>();
        input.add("Writing Fast Tests Against Enterprise Rails 60hr");

        try{
            eventManager.createEvents(input);
            fail();
        }catch (Exception e){
            assertEquals(e.getMessage(), "Invalid input");
        }
    }

    @Test
    public void shouldConvertLightningWithValidEvent() throws Exception {

        List<String> input = new ArrayList<>();
        input.add("event1 lightning");

        List<Event> expectedEvents = new ArrayList<>();
        Event event = getEvent("event1", 5);
        expectedEvents.add(event);

        List<Event> events = eventManager.createEvents(input);

        assertEquals(events, expectedEvents);
    }

    private List<String> createInputString() {
        List<String> input = new ArrayList<>();
        input.add("Writing Fast Tests Against Enterprise Rails 60min");
        input.add("Overdoing it in Python 45min");
        input.add("Rails for Python Developers lightning");
        return input;
    }

    private List<Event> createEvents() {
        List<Event> events = new ArrayList<>();
        events.add(getEvent("Writing Fast Tests Against Enterprise Rails",60));
        events.add(getEvent("Overdoing it in Python",45));
        events.add(getEvent("Rails for Python Developers",5));
        return events;
    }

    private Event getEvent(String title, int duration){
        Event event = new Event();
        event.setTitle(title);
        event.setDuration(duration);
        return event;
    }
}