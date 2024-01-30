package at.aau.serg.exercises.shapetesting;

public class ShapeFactory {
    /**
     * Creates a shape based on the specified type and parameters.
     *
     * @param type       The type of shape to create (e.g., "Circle" or "Rectangle").
     * @param parameters The parameters for creating the shape.
     * @return An instance of the specified shape.
     * @throws IllegalArgumentException If the type is unknown or the parameters are invalid.
     */
    public Shape create(ShapeType type, int... parameters) {
        switch (type) {
            case CIRCLE:
                if (parameters.length != 1) {
                    throw new IllegalArgumentException("Invalid number of parameters for Circle");
                }
                return new Circle(parameters[0]);
            case SQUARE:
                if (parameters.length != 1) {
                    throw new IllegalArgumentException("Invalid number of parameters for Square");
                }
                return new Rectangle(parameters[0], parameters[0]);
            case RECTANGLE:
                if (parameters.length != 2) {
                    throw new IllegalArgumentException("Invalid number of parameters for Rectangle");
                }
                return new Rectangle(parameters[0], parameters[1]);
            default:
                throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }
}
