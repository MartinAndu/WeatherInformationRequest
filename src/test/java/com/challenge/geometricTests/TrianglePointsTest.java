package com.challenge.geometricTests;

import com.challenge.exceptions.types.PlanetsOutOfBoundsException;
import com.challenge.helpers.PlanetsTriangle;
import com.challenge.model.Position;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrianglePointsTest {


    @Before
    public void setup() {
    }

    @Test
    public void TriangleShapeIncludingCenterTest() {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(5.0,-1.0));
        positions.add(new Position(-5.0,-1.0));
        positions.add(new Position(0.0,5.00));


        assertTrue(PlanetsTriangle.isSunInsideATriangle(positions));
    }

    @Test
    public void UpsideDownTriangleShapeIncludingCenterTest() {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(5.0,5.0));
        positions.add(new Position(-5.0,5.0));
        positions.add(new Position(0.0,-1.00));


        assertTrue(PlanetsTriangle.isSunInsideATriangle(positions));
    }


    @Test
    public void PointingToTheRightTriangleShapeIncludingCenterTest() {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(-1.0,5.0));
        positions.add(new Position(-1.0,-5.0));
        positions.add(new Position(1.0,0.00));


        assertTrue(PlanetsTriangle.isSunInsideATriangle(positions));
    }

    @Test(expected = PlanetsOutOfBoundsException.class)
    public void TriangleShapeWithLessThanThreePlanets() {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(-1.0,5.0));
        positions.add(new Position(-1.0,-5.0));

        assertTrue(PlanetsTriangle.isSunInsideATriangle(positions));
    }

    @Test(expected = PlanetsOutOfBoundsException.class)
    public void TriangleShapeWithNoPlanetsTest() {
        List<Position> positions = new ArrayList<>();

        assertTrue(PlanetsTriangle.isSunInsideATriangle(positions));
    }
}
