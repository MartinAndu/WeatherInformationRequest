package com.challenge.Helpers;

import com.challenge.Model.Position;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.stream.IntStream;


public class PlanetsTriangle {

    PlanetsTriangle() {}

    public static boolean isSunInsideATriangle(Position position1, Position position2, Position position3) {
        Path2D.Double trianglePath = new Path2D.Double();
        trianglePath.moveTo(position1.getCoordinateX(), position1.getCoordinateY());
        trianglePath.lineTo(position2.getCoordinateX(), position2.getCoordinateY());
        trianglePath.lineTo(position3.getCoordinateX(), position3.getCoordinateY());
        trianglePath.closePath();
        return (trianglePath.contains(new Point2D.Double(0, 0)));
    }

    public static Double calculateArea(List<Position> positions) {
        double distance1 = Point2D.Double.distanceSq(positions.get(0).getCoordinateX(), positions.get(0).getCoordinateY(), positions.get(1).getCoordinateX(), positions.get(1).getCoordinateY());
        double distance2 = Point2D.Double.distanceSq(positions.get(1).getCoordinateX(), positions.get(1).getCoordinateY(), positions.get(2).getCoordinateX(), positions.get(2).getCoordinateY());
        double distance3 = Point2D.Double.distanceSq(positions.get(2).getCoordinateX(), positions.get(2).getCoordinateY(), positions.get(0).getCoordinateX(), positions.get(0).getCoordinateY());
        return distance1 + distance2 + distance3;
//        return IntStream.range(0, positions.size() - 1).mapToDouble(
//                i -> Point2D.Double.distanceSq(positions.get(i).getCoordinateX(), positions.get(i).getCoordinateY(), positions.get(i+1).getCoordinateX(), positions.get(i+1).getCoordinateY())
//        ).sum();
    }

}
