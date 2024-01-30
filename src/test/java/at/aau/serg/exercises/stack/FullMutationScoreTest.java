package at.aau.serg.exercises.stack;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

public class FullMutationScoreTest {
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

    @Test
    public void testAllWorked(){
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);


    }

    @Test
    void testPopWithLessThanQuarterFull() {
        Stack stack = new Stack(10); // Assuming a constructor that sets initial size
        // Fill stack with less than 25% of its capacity, e.g., 2 elements if size is 10
        stack.push(1);
        stack.push(2);
        int poppedElement = stack.peek(); // Replace 'yourMethod' with the actual method name

        Assertions.assertEquals(2, poppedElement, "Popped element should be the top element");
        Assertions.assertEquals(2, stack.size(), "Stack should be resized to half of its original size");
    }



}
