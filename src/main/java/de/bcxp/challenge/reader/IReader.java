package de.bcxp.challenge.reader;

import java.io.Reader;
import java.util.List;

public interface IReader {

    <T> List<T> readFile(final Reader reader, final Class<T> clazz);

    <T> List<T> readFile(final String path, final Class<T> clazz);

}
