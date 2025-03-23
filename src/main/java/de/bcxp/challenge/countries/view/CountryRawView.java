package de.bcxp.challenge.countries.view;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CountryRawView {

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "Population")
    private String population;

    @CsvBindByName(column = "Area (km²)")
    private Double area;
}
