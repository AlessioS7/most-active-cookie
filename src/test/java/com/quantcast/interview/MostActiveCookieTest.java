package com.quantcast.interview;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostActiveCookieTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testNoCliParameters() {
        MostActiveCookie.main(new String[]{});

        assertEquals("Error: No parameters\n", outputStreamCaptor.toString());
    }

    @Test
    void testWrongCliParameters() {
        MostActiveCookie.main(new String[]{"test"});

        assertEquals("Error: Wrong cli parameters\n", outputStreamCaptor.toString());
    }

    @Test
    void testFileNotFound() {
        MostActiveCookie.main(new String[]{"-f", "test", "-d", "2018-12-09"});

        assertEquals("Error: test (No such file or directory)\n", outputStreamCaptor.toString());
    }

    @Test
    void testNoLogOnGivenDay() {
        MostActiveCookie.main(new String[]{"-f", "cookie_log.csv", "-d", "2023-03-03"});

        assertEquals("Error: There are no logs on the given day\n", outputStreamCaptor.toString());
    }

    @Test
    void testPrintSingleMostActiveCookie() {
        MostActiveCookie.main(new String[]{"-f", "cookie_log.csv", "-d", "2018-12-09"});

        assertEquals("AtY0laUfhglK3lC7\n", outputStreamCaptor.toString());
    }

    @Test
    void testPrintDoubleMostActiveCookie() {
        MostActiveCookie.main(new String[]{"-f", "cookie_log2.csv", "-d", "2018-12-09"});

        assertEquals("AtY0laUfhglK3lC7\nSAZuXPGUrfbcn5UA\n", outputStreamCaptor.toString());
    }
}
