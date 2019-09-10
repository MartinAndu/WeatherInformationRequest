package com.challenge.Exceptions.validators;

import com.challenge.Model.Consts.Consts;
import com.challenge.Model.Position;

import java.util.List;

public class PositionValidator {
    public static boolean  ValidatePositionsSize(List<Position> positions) {
        if (positions == null) return false;
        return positions.size() == Consts.PLANET_SIZE;
    }
}
