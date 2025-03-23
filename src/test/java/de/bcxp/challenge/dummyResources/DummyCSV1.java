package de.bcxp.challenge.dummyResources;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DummyCSV1 {

    @CsvBindByName(column = "column1", required = true)
    public String column1;

    @CsvBindByName(column = "column2", required = true)
    public String column2;

    @CsvBindByName(column = "column3", required = true)
    public Integer column3;
}
