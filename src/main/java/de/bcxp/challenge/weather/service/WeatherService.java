package de.bcxp.challenge.weather.service;

import de.bcxp.challenge.weather.view.WeatherRawView;
import de.bcxp.challenge.weather.view.WeatherTempSpreadView;

import java.util.Comparator;
import java.util.List;

/**
 * The WeatherService class provides methods to work with weather data.
 */
public class WeatherService {

    private final List<WeatherRawView> weatherData;

    /**
     * Creates a new instance of the WeatherService.
     * @param weatherData The weather data to work with.
     */
    public WeatherService(final List<WeatherRawView> weatherData) {
        this.weatherData = weatherData;
    }

    /**
     * Returns the day with the smallest temperature spread.
     * @return The day with the smallest temperature spread.
     */
    public WeatherTempSpreadView getDayWithSmallestTempSpread() {
        WeatherRawView weatherRawView = weatherData.stream()
                .min(Comparator.comparing(WeatherService::getTempSpread))
                .orElseThrow();

        return new WeatherTempSpreadView(weatherRawView.getDay(), getTempSpread(weatherRawView));
    }

    /**
     * Returns the temperature spread for a given weather data.
     * @param weatherRawView The weather data to calculate the temperature spread for.
     * @return The temperature spread.
     */
    public static Integer getTempSpread(final WeatherRawView weatherRawView) {
        if(weatherRawView.getMnt() == null || weatherRawView.getMxt() == null) {
            return 0;
        }

        if(weatherRawView.getMnt() > weatherRawView.getMxt()) {
            throw new IllegalArgumentException("Minimum temperature is greater than maximum temperature.");
        }

        return weatherRawView.getMxt() - weatherRawView.getMnt();
    }

}
