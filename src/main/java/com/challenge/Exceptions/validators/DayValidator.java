package com.challenge.Exceptions.validators;

import com.challenge.Model.Consts.Consts;

public class DayValidator {
    public static boolean  ValidateDay(int day) {
        return day >=0 && day <= Consts.AMOUNT_OF_DAYS;
    }
}
