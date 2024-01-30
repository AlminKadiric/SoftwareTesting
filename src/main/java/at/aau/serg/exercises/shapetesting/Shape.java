package at.aau.serg.exercises.shapetesting;
// Shape.java
/**
 * Interface representing a geometric shape.
 */
public interface Shape {
    /**
     * Calculates the area of the shape.
     *
     * @return The area of the shape.
     */
    double calculateArea();

    /**
     * Calculates the perimeter of the shape.
     *
     * @return The perimeter of the shape.
     */
    double calculatePerimeter();

    /**
     * Returns if the shape is a square.
     *
     * @return true if the shape is a square, false otherwise
     */
    boolean isSquare();
}
