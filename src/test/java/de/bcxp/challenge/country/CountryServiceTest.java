package de.bcxp.challenge.country;

import de.bcxp.challenge.countries.service.CountryService;
import de.bcxp.challenge.countries.view.CountryRawView;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryServiceTest {


    @Test
    public void testGetCountryWithHighestPopulationDensity() {
        List<CountryRawView> countryData = List.of(
                new CountryRawView("Germany", "83.234.000,00", 357_386.00),
                new CountryRawView("France", "67.064.000,05", 551_695.00),
                new CountryRawView("Spain", "47.431.256,1", 505_992.00),
                new CountryRawView("Italy", "60.359.546,00", 301_340.00),
                new CountryRawView("United Kingdom", "66.796.807,00", 243_610.00)
        );

        CountryService countryService = new CountryService(countryData);

        CountryRawView countryWithHighestPopulationDensity = countryService.getCountryWithHighestPopulationDensity();

        assertEquals("United Kingdom", countryWithHighestPopulationDensity.getName());
    }

    @Test
    public void testGetPopulationDensity() {
        CountryRawView countryRawViewGermany = new CountryRawView("Germany", "83.234.000,00", 357_386.00);
        CountryRawView countryRawViewFrance = new CountryRawView("France", "67.064.000,05", 551_695.00);
        CountryRawView countryRawViewSpain = new CountryRawView("Spain", "47.431.256,1", 505_992.00);
        CountryRawView countryRawViewItaly = new CountryRawView("Italy", "60.359.546,00", 301_340.00);
        CountryRawView countryRawViewUnitedKingdom = new CountryRawView("United Kingdom", "66.796.807,00", 243_610.00);

        assertEquals(232.89664396478878, CountryService.getPopulationDensity(countryRawViewGermany));
        assertEquals(121.55991997389862, CountryService.getPopulationDensity(countryRawViewFrance));
        assertEquals(93.73914231845563, CountryService.getPopulationDensity(countryRawViewSpain));
        assertEquals(200.30379637618637, CountryService.getPopulationDensity(countryRawViewItaly));
        assertEquals(274.1956693074997, CountryService.getPopulationDensity(countryRawViewUnitedKingdom));
    }

    @Test
    public void testParsePopulation() {
        assertEquals(83234000.0, CountryService.parsePopulation("83.234.000,00"));
        assertEquals(67064000.05, CountryService.parsePopulation("67.064.000,05"));
        assertEquals(47431256.1, CountryService.parsePopulation("47.431.256,1"));
        assertEquals(60359546.0, CountryService.parsePopulation("60.359.546,00"));
        assertEquals(66796807.0, CountryService.parsePopulation("66.796.807,00"));
    }
}