package de.bcxp.challenge.exceptions;

public class CsvException extends Exception {

    public CsvException(String message, Exception e) {
        super(message, e);
    }
}
