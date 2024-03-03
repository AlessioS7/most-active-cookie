package com.quantcast.interview.util;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DailyLogsTest {
    @Test
    void testFileNotFound() {
        assertThrows(FileNotFoundException.class, () -> new DailyLogs("test"));
    }

    @Test
    void testNoLogOnGivenDay() throws FileNotFoundException {
        DailyLogs dailyLogs = new DailyLogs("cookie_log.csv");

        assertThrows(IllegalArgumentException.class, () -> dailyLogs.getMostActiveCookiesOnGivenDay("2023-03-03"));
    }

    @Test
    void testFileWithNoLogs() throws FileNotFoundException {
        DailyLogs dailyLogs = new DailyLogs("cookie_log.csv");

        assertThrows(IllegalArgumentException.class, () -> dailyLogs.getMostActiveCookiesOnGivenDay("2023-03-03"));
    }

    @Test
    void testSingleMostActiveCookie() throws FileNotFoundException {
        DailyLogs dailyLogs = new DailyLogs("cookie_log.csv");

        assertEquals(List.of("AtY0laUfhglK3lC7"), dailyLogs.getMostActiveCookiesOnGivenDay("2018-12-09"));
    }

    @Test
    void testSingleCookiePerGivenDay() throws FileNotFoundException {
        DailyLogs dailyLogs = new DailyLogs("cookie_log.csv");

        assertEquals(List.of("4sMM2LxV07bPJzwf"), dailyLogs.getMostActiveCookiesOnGivenDay("2018-12-07"));
    }

    @Test
    void testTwoMostActiveCookie() throws FileNotFoundException {
        DailyLogs dailyLogs = new DailyLogs("cookie_log2.csv");

        assertEquals(List.of("AtY0laUfhglK3lC7", "SAZuXPGUrfbcn5UA"), dailyLogs.getMostActiveCookiesOnGivenDay("2018-12-09"));
    }

    @Test
    void testThreeMostActiveCookie() throws FileNotFoundException {
        DailyLogs dailyLogs = new DailyLogs("cookie_log.csv");

        assertEquals(List.of("SAZuXPGUrfbcn5UA", "4sMM2LxV07bPJzwf", "fbcn5UAVanZf6UtG"), dailyLogs.getMostActiveCookiesOnGivenDay("2018-12-08"));
    }

    @Test
    void testBigFileFourMostActiveCookie() throws FileNotFoundException {
        DailyLogs dailyLogs = new DailyLogs("big_cookie_log.csv");

        assertEquals(List.of("AtY0laUfhglK3lC7", "SAZuXPGUrfbcn5UA", "4sMM2LxV07bPJzwf", "fbcn5UAVanZf6UtG"), dailyLogs.getMostActiveCookiesOnGivenDay("2018-11-30"));
    }
}
