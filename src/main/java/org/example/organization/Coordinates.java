package org.example.organization;

/**
 * Класс координат
 */
public class Coordinates {
    // Поле [ранящее значение x
    private Integer x; //Поле не может быть null
    private double y; //Максимальное значение поля: 274

    public Coordinates(Integer x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
