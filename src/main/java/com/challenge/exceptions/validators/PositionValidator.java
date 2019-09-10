package com.challenge.exceptions.validators;

import com.challenge.model.consts.Consts;
import com.challenge.model.Position;

import java.util.List;

public class PositionValidator {
    public static boolean  ValidatePositionsSize(List<Position> positions) {
        if (positions == null) return false;
        return positions.size() == Consts.PLANET_SIZE;
    }
}
