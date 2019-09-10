package com.challenge.exceptions.validators;

import com.challenge.model.consts.Consts;

public class DayValidator {
    public static boolean  ValidateDay(int day) {
        return day >=0 && day < Consts.AMOUNT_OF_DAYS;
    }
}
