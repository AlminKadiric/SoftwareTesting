package at.aau.serg.exercises.shapetesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class RectangleTest {


    @Test
    public void testCalculateArea(){
        Rectangle rectangle = new Rectangle(5,7);
        double actualResult = rectangle.calculateArea();
        double expectedResult = rectangle.getLength()*rectangle.getWidth();

        Assertions.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testCalculatePerimeter(){
        Rectangle rectangle = new Rectangle(5,7);
        double actualResult = rectangle.calculatePerimeter();
        double expectedResult = 2 * (rectangle.getLength()+rectangle.getWidth());

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsSquare(){
        Rectangle rectangle = new Rectangle(5,5);
        Assertions.assertTrue(rectangle.isSquare());
    }
    @Test
    public void testIsNotSquare(){
        Rectangle rectangle = new Rectangle(5,5);
        Assertions.assertTrue(rectangle.isSquare());
    }

    @Test
    public void testEquals(){
        Rectangle rectangle = new Rectangle(5,5);
        Rectangle rectangle1 = new Rectangle(5,5);
        Assertions.assertTrue(rectangle.equals(rectangle1));
    }
    @Test
    public void testNotEquals(){
        Rectangle rectangle = new Rectangle(5,5);
        Rectangle rectangle1 = new Rectangle(5,8);
        Assertions.assertFalse(rectangle.equals(rectangle1));
    }

    @Test
    public void testHashCodeEqualRectangles() {
        Rectangle rectangle1 = new Rectangle(5, 8);
        Rectangle rectangle2 = new Rectangle(5, 8);

        Assertions.assertEquals(rectangle1.hashCode(), rectangle2.hashCode());
    }

    @Test
    public void testHashCodeDifferentRectangles() {
        Rectangle rectangle1 = new Rectangle(5, 8);
        Rectangle rectangle2 = new Rectangle(8, 5);

        Assertions.assertNotEquals(rectangle1.hashCode(), rectangle2.hashCode());

}



}
