package de.bcxp.challenge.reader;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import de.bcxp.challenge.exceptions.ReadException;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class CsvReader implements IReader {

    @Getter
    @Setter
    private char separator = ',';

    /**
     * Reads a CSV file and maps it to a list of objects of the given class.
     * @param reader The reader of the CSV file
     * @param clazz The class to map the CSV file to
     * @return A list of objects of the given class
     * @param <T> The type of the class
     * @throws ReadException If an error occurs while reading the CSV file
     */
    public <T> List<T> readFile(final Reader reader, final Class<T> clazz) {
        try {
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withType(clazz)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(this.getSeparator())
                    .build();

            return csvToBean.parse();
        } catch (Exception e) {
            throw new ReadException("Error reading CSV file", e);
        }
    }

    /**
     * Reads a CSV file and maps it to a list of objects of the given class.
     * @param path The path to the CSV file
     * @param clazz The class to map the CSV file to
     * @return A list of objects of the given class
     * @param <T> The type of the class
     * @throws ReadException If an error occurs while reading the CSV file
     */
    public <T> List<T> readFile(final String path, final Class<T> clazz) {
        try {
            Reader reader = new BufferedReader(new FileReader(path));

            return readFile(reader, clazz);
        } catch (FileNotFoundException e) {
            throw new ReadException("File not found", e);
        }
    }

}
