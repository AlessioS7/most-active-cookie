package com.quantcast.interview.util;

import org.apache.commons.cli.*;

/**
 * Represents the file name and date passed as CLI parameters with the '-f' and '-d' tags, respectively.
 *
 * @author Alessio Santangelo
 * @version 1.0
 */
public class CliParameters {
    private final String fileName;
    private final String date;

    /**
     * Parses '-f fileName' and '-d date' from the CLI parameters.
     *
     * @param args the CLI parameters
     * @throws IllegalArgumentException If arg is invalid (empty or null) or if args doesn't contain the correct arguments
     * @throws ParseException           If args is invalid (wrong syntax)
     */
    public CliParameters(String[] args) throws IllegalArgumentException, ParseException {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("No parameters");
        }

        Options options = new Options();
        options.addOption("f", true, "file name");
        options.addOption("d", true, "date");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        fileName = cmd.getOptionValue("f");
        date = cmd.getOptionValue("d");

        if (fileName == null || date == null) {
            throw new IllegalArgumentException("Wrong cli parameters");
        }
    }

    /**
     * Gets the file name passed as CLI argument.
     *
     * @return A string representing the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Gets the date passed as CLI argument.
     *
     * @return A string representing the date
     */
    public String getDate() {
        return date;
    }
}
