package com.fevzi.algorithms.equlibility;

import com.fevzi.algorithms.equlibility.model.XYPoint;
import com.fevzi.algorithms.equlibility.model.XYZPoint;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JoshuaBlochEqualityTest {

    @Test
    public void shouldBeReflexive() {
        final XYPoint point = new XYPoint(0, 0);
        assertTrue(point.equals(point));
    }

    @Test
    public void shouldBeSymmetric() {
        final XYPoint point2d = new XYPoint(0, 0);
        final XYZPoint point3d = new XYZPoint(0, 0, 1);

        assertFalse(point2d.equals(point3d));
        assertFalse(point3d.equals(point2d));
    }

    @Test
    public void shouldBeTransitive() {
        final XYZPoint point3d1 = new XYZPoint(0, 0, 1);
        final XYZPoint point3d2 = new XYZPoint(0, 0, 1);
        final XYZPoint point3d3 = new XYZPoint(0, 0, 1);

        assertTrue(point3d1.equals(point3d2));
        assertTrue(point3d2.equals(point3d3));
        assertTrue(point3d1.equals(point3d3));
    }

    @Test
    public void shouldBeConsistent() {
        final XYPoint point2d = new XYPoint(0, 0);
        final XYZPoint point3d = new XYZPoint(0, 0, 1);

        //multiple invocations of same operation
        assertFalse(point2d.equals(point3d));
        assertFalse(point2d.equals(point3d));
        assertFalse(point2d.equals(point3d));
        assertFalse(point2d.equals(point3d));
        assertFalse(point2d.equals(point3d));
    }
}
