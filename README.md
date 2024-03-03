# Most Active Cookie
Java command line program that given a cookie log file in the following format:

    cookie,timestamp
    AtY0laUfhglK3lC7,2018-12-09T14:19:00+00:00
    SAZuXPGUrfbcn5UA,2018-12-09T10:13:00+00:00
    5UAVanZf6UtGyKVS,2018-12-09T07:25:00+00:00
    AtY0laUfhglK3lC7,2018-12-09T06:19:00+00:00
    SAZuXPGUrfbcn5UA,2018-12-08T22:03:00+00:00
    4sMM2LxV07bPJzwf,2018-12-08T21:30:00+00:00
    fbcn5UAVanZf6UtG,2018-12-08T09:30:00+00:00
    4sMM2LxV07bPJzwf,2018-12-07T23:30:00+00:00

returns the most active cookie(s) (the one(s) seen in the log the most times) for a specific day.

## Repository layout

    .
    ├── docs                                     # Documentation 
    │   ├── javadoc                              # javadoc web page 
    │   ├── markdown                             # javadoc converted to markdown
    ├── src                                      # Source code
    │   ├── main
    │   │   ├── java/com/quantcast/interview
    │   │   │   ├── MostActiveCookie.java        # Class containing the main method
    │   │   │   ├── util
    │   │   │   │   ├── CliParameters.java       # Class that parses the CLI parameters
    │   │   │   │   ├── DailyLogs.java           # Class that processes the log file
    │   ├── test
    │   │   ├── java/com/quantcast/interview
    │   │   │   ├── MostActiveCookieTest.java    # Tests for MostActiveCookie.java
    │   │   │   ├── util
    │   │   │   │   ├── CliParametersTest.java   # Tests for CliParametersTest.java
    │   │   │   │   ├── DailyLogsTest.java       # Tests for DailyLogsTest.java
    ├── .gitignore
    ├── *.csv                                    # Sample log files
    ├── pom.xml    
    └── README.md

## Requirements

- Java 17
- Maven

## Usage

In order to build, test and generate the associated jar file, you need to run the following command:

    mvn clean package

After having created the jar file, the command to run the program is:

    java -jar target/assignment-1.0-SNAPSHOT.jar -f [fileName] -d [date]

where [fileName] is the name of the file we want to read and [date] is the date (in UTC time zone) of the day we want to consider.

### Example

With reference to the file depicted at the beginning, the following command:

    java -jar target/assignment-1.0-SNAPSHOT.jar -f cookie_log.csv -d 2018-12-09

would write to stdout:

    AtY0laUfhglK3lC7

## Documentation

Classes and methods have been documented utilizing the javadoc syntax. The generated documentation web page can be found by opening the *docs/javadoc/index.html* file with a web browser (it is required to clone the repo. It will not work from GitHub).

In case you want to access the documentation without cloning the repo, the javadoc has been converted to markdown files that can be accessed, even from GitHub, at the following links:
- com.quantcast.interview
    - util
      - [CliParameters](docs/markdowns/CliParameters.md)
      - [DailyLogs](docs/markdowns/DailyLogs.md)
    - [MostActiveCookie](docs/markdowns/MostActiveCookie.md)


## Note

All the code has been written considering cleanliness, maintainability, and extendability over performance. For instance, instead of saving only the logs of the given date in memory, it has been decided to save all logs and group them by date. This approach ensures that the code is easily extendable to perform additional processing on logs from other days.