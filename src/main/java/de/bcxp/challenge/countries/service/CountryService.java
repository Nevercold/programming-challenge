package de.bcxp.challenge.countries.service;

import de.bcxp.challenge.countries.view.CountryRawView;

import java.util.Comparator;
import java.util.List;

/**
 * Service class for country data.
 */
public class CountryService {

    private final List<CountryRawView> countryData;

    /**
     * Creates a new instance of the CountryService.
     * @param countryData The country data to work with.
     */
    public CountryService(final List<CountryRawView> countryData) {
        this.countryData = countryData;
    }

    /**
     * Returns the country with the highest population density.
     * @return The country with the highest population density.
     */
    public CountryRawView getCountryWithHighestPopulationDensity() {
        return countryData.stream()
                .max(Comparator.comparing(CountryService::getPopulationDensity))
                .orElseThrow();
    }

    /**
     * Returns the population density for a given country data.
     * @param countryRawView The country data to calculate the population density for.
     * @return The population density.
     */
    public static Double getPopulationDensity(final CountryRawView countryRawView) {
        if(countryRawView.getArea() == 0) {
            throw new IllegalArgumentException("Area is 0.");
        }

        return parsePopulation(countryRawView.getPopulation()) / countryRawView.getArea();
    }

    /**
     * Parses the population string to a double. The population string may contain dots or commas as decimal separators.
     * @param population The population string to parse.
     * @return The parsed population.
     */
    public static Double parsePopulation(final String population) {
        return Double.parseDouble(population.replace(".", "").replace(",", "."));
    }
}
