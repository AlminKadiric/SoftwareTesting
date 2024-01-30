package at.aau.serg.exercises.shapetesting;// Circle.java

import java.util.Objects;

/**
 * Represents a circle, implementing the Shape interface.
 */
public class Circle implements Shape {
    private final int radius;

    /**
     * Constructs a circle with the specified radius.
     *
     * @param radius The radius of the circle.
     */
    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean isSquare() {
        return false;
    }

    /**
     * Gets the radius of the circle.
     *
     * @return The radius of the circle.
     */
    public double getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
