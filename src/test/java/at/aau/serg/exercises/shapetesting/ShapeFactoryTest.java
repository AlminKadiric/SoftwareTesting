package at.aau.serg.exercises.shapetesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class ShapeFactoryTest {
    private ShapeFactory shapeFactory;

    @BeforeEach
    void setUp() {
        shapeFactory = new ShapeFactory();
    }

    @Test
    void testIsSquareForCreatedRectangles() {
        Rectangle squareRectangle = (Rectangle) shapeFactory.create(ShapeType.SQUARE, 5);
        Rectangle nonSquareRectangle = (Rectangle) shapeFactory.create(ShapeType.RECTANGLE, 3, 6);

        Assertions.assertTrue(squareRectangle.isSquare());
        Assertions.assertFalse(nonSquareRectangle.isSquare());
    }

    @Test
    void testCalculatePerimeterForRectanglesAndCircles() {
        Rectangle rectangle = (Rectangle) shapeFactory.create(ShapeType.RECTANGLE, 3, 6);
        Circle circle = (Circle) shapeFactory.create(ShapeType.CIRCLE, 5);

        Assertions.assertEquals(18, rectangle.calculatePerimeter(), 0.0001);
        Assertions.assertEquals(2 * Math.PI * 5, circle.calculatePerimeter(), 0.0001);
    }

    @Test
    void testCalculateAreaForRectanglesAndCircles() {
        Rectangle rectangle = (Rectangle) shapeFactory.create(ShapeType.RECTANGLE, 3, 6);
        Circle circle = (Circle) shapeFactory.create(ShapeType.CIRCLE, 5);

        Assertions.assertEquals(3 * 6, rectangle.calculateArea(), 0.0001);
        Assertions.assertEquals(Math.PI * 5 * 5, circle.calculateArea(), 0.0001);
    }

    @Test
    void testCreateMethodWithValidArguments() {
        Shape square = shapeFactory.create(ShapeType.SQUARE, 4);
        Shape rectangle = shapeFactory.create(ShapeType.RECTANGLE, 3, 6);
        Shape circle = shapeFactory.create(ShapeType.CIRCLE, 5);

        Assertions.assertTrue(square instanceof Rectangle);
        Assertions.assertTrue(rectangle instanceof Rectangle);
        Assertions.assertTrue(circle instanceof Circle);
    }

    @Test
    void testCreateMethodWithInvalidArguments() {
        Assertions.assertThrows(NullPointerException.class, () -> shapeFactory.create(null, 1, 2),
                "Should throw NullPointerException for null shape type");

        Assertions.assertThrows(IllegalArgumentException.class, () -> shapeFactory.create(ShapeType.CIRCLE, 0, 2),
                "Should throw IllegalArgumentException for invalid circle arguments");

        Assertions.assertThrows(IllegalArgumentException.class, () -> shapeFactory.create(ShapeType.SQUARE, -1, 2),
                "Should throw IllegalArgumentException for invalid square arguments");
    }


    @ParameterizedTest
    @CsvSource({"3, 6, 18", "2, 2, 8"})
    void testCalculatePerimeterWithParameterizedValues(int length, int width, double expectedPerimeter) {
        Rectangle rectangle = (Rectangle) shapeFactory.create(ShapeType.RECTANGLE, length, width);
        Assertions.assertEquals(expectedPerimeter, rectangle.calculatePerimeter(), 0.0001);
    }
}