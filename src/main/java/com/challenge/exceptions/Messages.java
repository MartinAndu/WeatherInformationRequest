package com.challenge.exceptions;

import com.challenge.model.consts.Consts;

public class Messages {
    public static final String OUT_OF_BOUNDS_PLANETS = "Planets constraint allows only three planets maximum";
    public static final String DAY_NUMBER_EXCEPTION = "Day input format is incorrect. It must be defined in a range between 0 and " + (Consts.AMOUNT_OF_DAYS - 1);
    public static final String NUMBER_FORMAT_EXCEPTION = "The number is not a valid format, it should be an integer number";
}
