package com.challenge.GeometricTests;


import com.challenge.Model.Position;
import com.challenge.Helpers.PlanetsAllignment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LineaPointsTest {

    @Before
    public void setup() {
    }

    @Test
    public void PlanetsAlignedWithoutSun() {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(20.00,4.00));
        positions.add(new Position(10.00,4.00));
        positions.add(new Position(5.00,4.00));


        assertTrue(PlanetsAllignment.arePointsColinear(positions));
    }


    @Test
    public void PlanetsAlignedOptimal() {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(20.00,5.00));
        positions.add(new Position(10.00,4.00));
        positions.add(new Position(5.00,4.00));


        assertFalse(PlanetsAllignment.arePointsColinear(positions));
    }


}
