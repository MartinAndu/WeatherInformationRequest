package com.challenge.Helpers;

import com.challenge.Exceptions.Messages;
import com.challenge.Exceptions.types.PlanetsOutOfBoundsException;
import com.challenge.Exceptions.validators.PositionValidator;
import com.challenge.Model.Position;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.List;


public class PlanetsTriangle {

    public static boolean isSunInsideATriangle(List<Position> positions) {
        if (!PositionValidator.ValidatePositionsSize(positions)) throw new PlanetsOutOfBoundsException(Messages.OUT_OF_BOUNDS_PLANETS);

        Path2D.Double trianglePath = new Path2D.Double();
        trianglePath.moveTo(positions.get(0).getCoordinateX(), positions.get(0).getCoordinateY());
        trianglePath.lineTo(positions.get(1).getCoordinateX(), positions.get(1).getCoordinateY());
        trianglePath.lineTo(positions.get(2).getCoordinateX(), positions.get(2).getCoordinateY());
        trianglePath.closePath();
        return (trianglePath.contains(new Point2D.Double(0, 0)));
    }

    public static Double calculateArea(List<Position> positions) {

        if (!PositionValidator.ValidatePositionsSize(positions)) throw new PlanetsOutOfBoundsException(Messages.OUT_OF_BOUNDS_PLANETS);

        // TODO: use Intstream
        double distance1 = Point2D.Double.distanceSq(positions.get(0).getCoordinateX(), positions.get(0).getCoordinateY(), positions.get(1).getCoordinateX(), positions.get(1).getCoordinateY());
        double distance2 = Point2D.Double.distanceSq(positions.get(1).getCoordinateX(), positions.get(1).getCoordinateY(), positions.get(2).getCoordinateX(), positions.get(2).getCoordinateY());
        double distance3 = Point2D.Double.distanceSq(positions.get(2).getCoordinateX(), positions.get(2).getCoordinateY(), positions.get(0).getCoordinateX(), positions.get(0).getCoordinateY());
        return distance1 + distance2 + distance3;
//        return IntStream.range(0, positions.size() - 1).mapToDouble(
//                i -> Point2D.Double.distanceSq(positions.get(i).getCoordinateX(), positions.get(i).getCoordinateY(), positions.get(i+1).getCoordinateX(), positions.get(i+1).getCoordinateY())
//        ).sum();
    }

}
