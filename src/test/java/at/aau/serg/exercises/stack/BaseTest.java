package at.aau.serg.exercises.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseTest {
    @Test
    public void testPushAndPop() {
        Stack stack = new Stack();
        Assertions.assertTrue(stack.isEmpty());
        stack.push(8);

        Assertions.assertEquals(8,stack.pop());
        Assertions.assertTrue(stack.isEmpty());

    }

    @Test
    public void testPeek() {
        Stack stack = new Stack();
        stack.push(8);
        stack.push(10);

        Assertions.assertEquals(10,stack.peek());
        Assertions.assertEquals(10,stack.peek());

    }

    @Test
    public void testClear() {
        Stack stack = new Stack();
        stack.push(8);
        stack.push(10);
        stack.clear();
        Assertions.assertEquals(0,stack.size());
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        Stack stack = new Stack();

        Assertions.assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);

        Assertions.assertEquals(2, stack.size());

        stack.pop();

        Assertions.assertEquals(1, stack.size());
    }





}
