package org.example.organization;

/**
 * Класс координат
 */
public class Coordinates {
    // Поле [ранящее значение x
    private float x; //Поле не может быть null
    private long y; //Максимальное значение поля: 274

    public Coordinates(float x, long y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
