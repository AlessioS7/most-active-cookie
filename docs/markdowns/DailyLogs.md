## `public class DailyLogs`

Represents all the cookie logs included in the given file. Such logs are grouped by day, and it is possible to retrieve the most active cookie for a given day.

* **Author:** Alessio Santangelo
* **Version:** 1.0

## Nested class

### `public static class Log`

Represents a single cookie log

### `public Log(String cookie, String timestamp)`

Initializes the log with the cookie and timestamp attributes

* **Parameters:**
    * `cookie` — the cookie id
    * `timestamp` — the timestamp of when log was generated

## `public DailyLogs(String fileName) throws FileNotFoundException`

Reads the csv file named 'fileName' and locally stores all the logs grouping them by day

* **Parameters:** `fileName` — the name of the file
* **Exceptions:** `FileNotFoundException` — If the file name does not match any file

## `public List<String> getMostActiveCookieOnGivenDay(String date) throws IllegalArgumentException`

Gets the most active cookie(s) (one(s) seen in the log the most times) during a given day

* **Parameters:** `date` — the day to consider
* **Returns:** A list of strings representing the most active cookie(s)
* **Exceptions:** `IllegalArgumentException` — If there are no logs on the given day
