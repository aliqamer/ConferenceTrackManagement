package com.solution.util;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ali on 12/31/2016.
 */
public class InputReaderTest {

    private InputReader inputReader;

    @Before
    public void setup(){
        inputReader = new InputReader();
    }

    @Test
    public void souldReturnValidDataWithValidInputFile(){

        List<String> actualFileData = inputReader.readInputFile("", "input.txt");

        assertNotNull(actualFileData);
        assertEquals(actualFileData.get(0), "Writing Fast Tests Against Enterprise Rails 60min");
    }

    @Test
    public void shouldReturnNullForInvalidFile(){

        List<String> actualFileData = inputReader.readInputFile("", "input123.txt");

        assertNull(actualFileData);
    }

}