package de.bcxp.challenge.reader;

import de.bcxp.challenge.dummyResources.DummyCSV1;
import de.bcxp.challenge.exceptions.ReadException;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CsvReaderUtilTest {

    @Test
    public void testReadCsv() throws ReadException, IOException {
        Reader reader = new BufferedReader(new FileReader("src/test/resources/dummyCSV1.csv"));
        CsvReader csvReader = new CsvReader();

        List<DummyCSV1> dummyCSV1List = csvReader.readFile(reader, DummyCSV1.class);

        assertEquals(3, dummyCSV1List.size());

        assertEquals("value1", dummyCSV1List.get(0).getColumn1());
        assertEquals("value2", dummyCSV1List.get(0).getColumn2());
        assertEquals(3, dummyCSV1List.get(0).getColumn3());

        assertEquals("value4", dummyCSV1List.get(1).getColumn1());
        assertEquals("value5", dummyCSV1List.get(1).getColumn2());
        assertEquals(6, dummyCSV1List.get(1).getColumn3());

        assertEquals("value7", dummyCSV1List.get(2).getColumn1());
        assertEquals("value8", dummyCSV1List.get(2).getColumn2());
        assertEquals(9, dummyCSV1List.get(2).getColumn3());
    }


    @Test
    public void testReadInvalidCsv() throws IOException {
        Reader reader = new BufferedReader(new FileReader("src/test/resources/dummyCSV2.csv"));
        CsvReader csvReader = new CsvReader();

        assertThrows(ReadException.class, () -> {
            csvReader.readFile(reader, DummyCSV1.class);
        });

        Reader reader2 = new BufferedReader(new FileReader("src/test/resources/dummyCSV3.csv"));

        assertThrows(ReadException.class, () -> {
            csvReader.readFile(reader2, DummyCSV1.class);
        });
    }


}
