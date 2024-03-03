package com.quantcast.interview;

import com.quantcast.interview.util.CliParameters;
import com.quantcast.interview.util.DailyLogs;

import java.util.List;

/**
 * Class containing the main method
 *
 * @author Alessio Santangelo
 * @version 1.0
 */
public class MostActiveCookie {
    /**
     * Given the CSV file and date passed as CLI parameters, it prints the most active cookie(s) on the given day.
     *
     * @param args the CLI parameters
     */
    public static void main(String[] args) {
        try {
            CliParameters cliParameters = new CliParameters(args);
            DailyLogs dailyLogs = new DailyLogs(cliParameters.getFileName());
            List<String> mostActiveCookiesOnGivenDay = dailyLogs.getMostActiveCookiesOnGivenDay(cliParameters.getDate());

            for (String cookie : mostActiveCookiesOnGivenDay) {
                System.out.println(cookie);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}