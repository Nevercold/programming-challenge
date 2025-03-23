package de.bcxp.challenge.weather.view;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherRawView {

    @CsvBindByName(column="Day")
    private Integer day;

    @CsvBindByName(column="MxT")
    private Integer mxt;

    @CsvBindByName(column="MnT")
    private Integer mnt;
}
