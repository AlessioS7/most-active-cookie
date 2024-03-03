package com.quantcast.interview.util;

import org.apache.commons.cli.MissingArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CliParametersTest {
    @Test
    void testNullArgument() {
        assertThrows(IllegalArgumentException.class, () -> new CliParameters(null));
    }

    @Test
    void testNoParameters() {
        assertThrows(IllegalArgumentException.class, () -> new CliParameters(new String[]{}));
    }

    @Test
    void testWrongParameters() {
        assertThrows(IllegalArgumentException.class, () -> new CliParameters(new String[]{"test"}));
    }

    @Test
    void testMissingDateParameter() {
        assertThrows(IllegalArgumentException.class, () -> new CliParameters(new String[]{"-f", "cookie_log.csv"}));
    }

    @Test
    void testMissingFileNameParameter() {
        assertThrows(IllegalArgumentException.class, () -> new CliParameters(new String[]{"-d", "2018-12-09"}));
    }

    @Test
    void testWrongParametersOrder() {
        assertThrows(MissingArgumentException.class, () -> new CliParameters(new String[]{"-d", "-f", "2018-12-09", "cookie_log.csv"}));
    }

    @Test
    void testCorrectParameters() throws Exception {
        CliParameters cliParameters = new CliParameters(new String[]{"-f", "cookie_log.csv", "-d", "2018-12-09"});

        assertTrue(cliParameters.getFileName().equals("cookie_log.csv") && cliParameters.getDate().equals("2018-12-09"));
    }

    @Test
    void testCorrectInvertedParameters() throws Exception {
        CliParameters cliParameters = new CliParameters(new String[]{"-d", "2018-12-09", "-f", "cookie_log.csv",});

        assertTrue(cliParameters.getFileName().equals("cookie_log.csv") && cliParameters.getDate().equals("2018-12-09"));
    }
}
