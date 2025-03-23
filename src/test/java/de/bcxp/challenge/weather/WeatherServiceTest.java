package de.bcxp.challenge.weather;

import de.bcxp.challenge.weather.service.WeatherService;
import de.bcxp.challenge.weather.view.WeatherRawView;
import de.bcxp.challenge.weather.view.WeatherTempSpreadView;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeatherServiceTest {

    @Test
    public void testGetDayWithSmallestTempSpread() {
        List<WeatherRawView> weatherData = List.of(
                new WeatherRawView(1, 23, 10),
                new WeatherRawView(2, 25, 15),
                new WeatherRawView(3, 30, 20),
                new WeatherRawView(4, 20, 17),
                new WeatherRawView(5, 15, 10)
        );
        WeatherService weatherService = new WeatherService(weatherData);


        WeatherTempSpreadView dayWithSmallestTempSpread = weatherService.getDayWithSmallestTempSpread();

        assertEquals(4, dayWithSmallestTempSpread.getDay());
        assertEquals(3, dayWithSmallestTempSpread.getTempSpread());
    }

    @Test
    public void testTempSpread() {
        List<WeatherRawView> weatherData = List.of(
                new WeatherRawView(1, 23, 10),
                new WeatherRawView(2, 25, 15),
                new WeatherRawView(3, 30, 20),
                new WeatherRawView(4, 20, 17),
                new WeatherRawView(5, 15, 10)
        );

        assertEquals(13, WeatherService.getTempSpread(weatherData.get(0)));
        assertEquals(10, WeatherService.getTempSpread(weatherData.get(1)));
        assertEquals(10, WeatherService.getTempSpread(weatherData.get(2)));
        assertEquals(3, WeatherService.getTempSpread(weatherData.get(3)));
        assertEquals(5, WeatherService.getTempSpread(weatherData.get(4)));
    }

    @Test
    public void testTempSpreadInvalid() {
        List<WeatherRawView> weatherData = List.of(
                new WeatherRawView(1, 23, 10),
                new WeatherRawView(2, 15, 25)
        );

        assertEquals(13, WeatherService.getTempSpread(weatherData.get(0)));
        assertThrows(IllegalArgumentException.class, () -> WeatherService.getTempSpread(weatherData.get(1)));
    }


}
