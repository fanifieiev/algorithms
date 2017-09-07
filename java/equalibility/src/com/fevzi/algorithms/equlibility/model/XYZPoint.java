package com.fevzi.algorithms.equlibility.model;

public class XYZPoint extends XYPoint {
    private int z;

    public XYZPoint(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object that) {
        if (that instanceof XYZPoint) {
            final XYZPoint thatPoint = (XYZPoint) that;
            return (thatPoint.canBeEqual(this)) && super.equals(thatPoint) && thatPoint.getZ() == this.z;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 37 * super.hashCode() + this.z;
    }

    @Override
    protected boolean canBeEqual(Object that) {
        return that instanceof XYZPoint;
    }
}
