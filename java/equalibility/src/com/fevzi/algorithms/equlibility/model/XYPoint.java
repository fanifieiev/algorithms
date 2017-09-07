package com.fevzi.algorithms.equlibility.model;

public class XYPoint {
    private int x;
    private int y;

    public XYPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object that) {
        if (that instanceof XYPoint) {
            final XYPoint thatPoint = (XYPoint) that;
            return (thatPoint.canBeEqual(this)) && thatPoint.getX() == this.x && thatPoint.getX() == this.y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = 37 * hashCode + x;
        hashCode = 37 * hashCode + y;
        return hashCode;
    }

    protected boolean canBeEqual(Object that) {
        return that instanceof XYPoint;
    }
}
