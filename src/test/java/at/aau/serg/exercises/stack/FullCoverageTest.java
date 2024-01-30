package at.aau.serg.exercises.stack;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

public class FullCoverageTest {
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

    @Test
    public void testPopEmptyStack() {
        Stack stack = new Stack();

        Assertions.assertThrows(EmptyStackException.class, ()->{
            stack.pop();
        });
    }

    @Test
    public void testIsFull() {
        Stack stack = new Stack(3);

        Assertions.assertFalse(stack.isFull());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assertions.assertTrue(stack.isFull());
    }

    @Test
    public void testPeekEmptyStack() {
        Stack stack = new Stack();

        Assertions.assertThrows(EmptyStackException.class, () -> {
            stack.peek();
        });
    }

        @Test
        public void testPopAfterResize() {
            Stack stack = new Stack(2);

            stack.push(1);
            stack.push(2);

            stack.pop();
            stack.pop();

            Assertions.assertThrows(EmptyStackException.class, stack::pop);
        }


    }





