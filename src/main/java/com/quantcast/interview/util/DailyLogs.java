package com.quantcast.interview.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Represents all the cookie logs included in the given file. Such logs are grouped by day, and it is possible to
 * retrieve the most active cookie for a given day.
 *
 * @author Alessio Santangelo
 * @version 1.0
 */
public class DailyLogs {
    /**
     * Represents a single cookie log
     */
    public static class Log {
        private final String cookie;
        private final String timestamp;

        /**
         * Initializes the log with the cookie and timestamp attributes
         *
         * @param cookie the cookie id
         * @param timestamp the timestamp of when log was generated
         */
        public Log(String cookie, String timestamp) {
            this.cookie = cookie;
            this.timestamp = timestamp;
        }
    }

    private final Map<String, List<Log>> dailyLogs;

    /**
     * Reads the csv file named 'fileName' and locally stores all the logs grouping them by day
     *
     * @param fileName the name of the file
     * @throws FileNotFoundException If the file name does not match any file
     */
    public DailyLogs(String fileName) throws FileNotFoundException {
        dailyLogs = new HashMap<>();

        File csv = new File(fileName);
        Scanner fileScanner = new Scanner(csv);

        fileScanner.nextLine(); // discard first line with headers

        while (fileScanner.hasNext()) {
            String[] lineValues = fileScanner.nextLine().split(",");
            Log log = new Log(lineValues[0], lineValues[1]);
            String date = log.timestamp.substring(0, 10);

            if (!dailyLogs.containsKey(date)) {
                dailyLogs.put(date, new LinkedList<>());
            }

            dailyLogs.get(date).add(log);
        }

        fileScanner.close();
    }

    /**
     * Gets the most active cookie(s) (one(s) seen in the log the most times) during a given day
     *
     * @param date the day to consider
     * @return A list of strings representing the most active cookie(s)
     * @throws IllegalArgumentException If there are no logs on the given day
     */
    public List<String> getMostActiveCookiesOnGivenDay(String date) throws IllegalArgumentException {
        List<Log> cookiesOnGivenDay = dailyLogs.get(date);

        if (cookiesOnGivenDay == null) {
            throw new IllegalArgumentException("There are no logs on the given day");
        }

        List<String> mostActiveCookies = new LinkedList<>();
        Map<String, Integer> cookieCount = new LinkedHashMap<>(); // we could just use a HashMap if we don't care about the order
        int max = 0;

        for (Log log : cookiesOnGivenDay) {
            if (!cookieCount.containsKey(log.cookie)) {
                cookieCount.put(log.cookie, 0);
            }

            int newCount = cookieCount.get(log.cookie) + 1;

            cookieCount.put(log.cookie, newCount);
            max = Math.max(max, newCount);
        }

        for (Map.Entry<String, Integer> entry : cookieCount.entrySet()) {
            if (entry.getValue() == max) {
                mostActiveCookies.add((entry.getKey()));
            }
        }

        return mostActiveCookies;
    }
}
