package de.bcxp.challenge.utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import de.bcxp.challenge.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class CsvReaderUtil {

    /**
     * Reads a CSV file and maps it to a list of objects of the given class.
     * @param reader The reader of the CSV file
     * @param clazz The class to map the CSV file to
     * @return A list of objects of the given class
     * @param <T> The type of the class
     * @throws CsvException If an error occurs while reading the CSV file
     */
    public static <T> List<T> readCsvFile(final Reader reader, final Class<T> clazz) throws CsvException {
        try {
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withType(clazz)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        } catch (Exception e) {
            throw new CsvException("Error reading CSV file", e);
        }
    }

    /**
     * Reads a CSV file and maps it to a list of objects of the given class.
     * @param path The path to the CSV file
     * @param clazz The class to map the CSV file to
     * @return A list of objects of the given class
     * @param <T> The type of the class
     * @throws CsvException If an error occurs while reading the CSV file
     */
    public static <T> List<T> readCsvFile(final String path, final Class<T> clazz) throws CsvException {
        try {
            Reader reader = new BufferedReader(new FileReader(path));

            return readCsvFile(reader, clazz);
        } catch (FileNotFoundException e) {
            throw new CsvException("File not found", e);
        }
    }

}
