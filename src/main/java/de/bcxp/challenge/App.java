package de.bcxp.challenge;

import de.bcxp.challenge.exceptions.CsvException;
import de.bcxp.challenge.utils.CsvReaderUtil;
import de.bcxp.challenge.weather.service.WeatherService;
import de.bcxp.challenge.weather.view.WeatherRawView;

import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) throws CsvException {

        // Weather task
        List<WeatherRawView> weatherData = CsvReaderUtil.readCsvFile("src/main/resources/de/bcxp/challenge/weather.csv", WeatherRawView.class);
        WeatherService weatherService = new WeatherService(weatherData);

        Integer dayWithSmallestTempSpread = weatherService.getDayWithSmallestTempSpread().getDay();
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);


        // density task
        String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
