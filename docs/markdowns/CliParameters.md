## `public class CliParameters`

Represents the file name and date passed as CLI parameters with the '-f' and '-d' tags, respectively.

* **Author:** Alessio Santangelo
* **Version:** 1.0

## `public CliParameters(String[] args) throws IllegalArgumentException, ParseException`

Parses '-f fileName' and '-d date' from the CLI parameters.

* **Parameters:** `args` — the CLI parameters
* **Exceptions:**
    * `IllegalArgumentException` — If arg is invalid (empty or null) or if args doesn't contain the correct arguments
    * `ParseException` — If args is invalid (wrong syntax)

## `public String getFileName()`

Gets the file name passed as CLI argument.

* **Returns:** A string representing the file name

## `public String getDate()`

Gets the date passed as CLI argument.

* **Returns:** A string representing the date