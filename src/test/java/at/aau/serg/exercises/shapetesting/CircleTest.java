package at.aau.serg.exercises.shapetesting;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class CircleTest {
    @Test
    public void testCalculateArea() {
       Circle circle = new Circle(7);
       double actualResult = circle.calculateArea();
       double expectedResult = Math.PI * Math.pow(circle.getRadius(), 2);
        Assertions.assertEquals(expectedResult,actualResult);
    }
    @Test
    public void testCalculatePerimeter() {
        Circle circle = new Circle(7);
        double actualResult = circle.calculatePerimeter();
        double expectedResult = 2 * Math.PI * circle.getRadius();
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testIsSquare(){
        Circle circle = new Circle(7);
        boolean isSquare = circle.isSquare();
        Assertions.assertFalse(circle.isSquare());

    }

    @Test
    public void testEquals(){
        Circle circle = new Circle(7);
        Circle circle1 = new Circle(7);
        Assertions.assertTrue(circle.equals(circle1));
    }
    @Test
    public void testNotEquals(){
        Circle circle = new Circle(7);
        Circle circle1 = new Circle(10);
        Assertions.assertFalse(circle.equals(circle1));
    }
    @Test
    public void testHashCode(){
        Circle circle = new Circle(7);
        Circle circle1 = new Circle(7);
        Assertions.assertEquals(circle.hashCode(),circle1.hashCode());
    }

}