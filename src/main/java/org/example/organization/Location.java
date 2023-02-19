package org.example.organization;

public class Location {
    private long x;
    private long y;
    private float z;

    public Location(long x, long y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
