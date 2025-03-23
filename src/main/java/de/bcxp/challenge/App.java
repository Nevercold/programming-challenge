package de.bcxp.challenge;

import de.bcxp.challenge.countries.service.CountryService;
import de.bcxp.challenge.countries.view.CountryRawView;
import de.bcxp.challenge.exceptions.CsvException;
import de.bcxp.challenge.reader.CsvReader;
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
        CsvReader csvReader = new CsvReader();

        // Weather task
        List<WeatherRawView> weatherData = csvReader.readCsvFile("src/main/resources/de/bcxp/challenge/weather.csv", WeatherRawView.class);
        WeatherService weatherService = new WeatherService(weatherData);

        Integer dayWithSmallestTempSpread = weatherService.getDayWithSmallestTempSpread().getDay();
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);


        // density task
        csvReader.setSeparator(';');
        List<CountryRawView> countryData = csvReader.readCsvFile("src/main/resources/de/bcxp/challenge/countries.csv", CountryRawView.class);
        CountryService countryService = new CountryService(countryData);

        String countryWithHighestPopulationDensity = countryService.getCountryWithHighestPopulationDensity().getName();
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
