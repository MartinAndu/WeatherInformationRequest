package com.challenge.exceptions.types;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class InvalidNumberFormatException extends NumberFormatException {
    public InvalidNumberFormatException(String msg) {
        super(msg);
    }
}
