package at.aau.serg.exercises.stack;

import java.util.EmptyStackException;

/**
 * This class implements a Stack using a regular array.
 *
 * <p>
 * A stack is an abstract data type that serves as a collection of elements, with two principal operations:
 * push, which adds an element to the collection, and pop, which removes the most recently added element that was not yet removed.
 * The order in which elements come off a stack gives rise to its alternative name, LIFO (for last in, first out).
 * Additionally, a peek operation may give access to the top without modifying the stack.
 */
public class Stack {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Empty stack indicator
     */
    private static final int EMPTY_STACK_INDICATOR = -1;

    /**
     * The max size of the Stack
     */
    private int size;

    /**
     * The array representation of the Stack
     */
    private int[] stackArray;

    /**
     * The top of the stack
     */
    private int top;

    /**
     * init Stack with DEFAULT_CAPACITY
     */
    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor
     *
     * @param size Size of the Stack
     */
    public Stack(int size) {
        this.size = size;
        this.stackArray = new int[this.size];
        this.top = EMPTY_STACK_INDICATOR;
    }

    /**
     * Adds an element to the top of the stack
     *
     * @param value The element added
     */
    public void push(int value) {
        if (isFull()) {
            resize(size * 2);
            push(value); // don't forget push after resizing
        } else {
            top++;
            stackArray[top] = value;
        }
    }

    /**
     * Removes the top element of the stack and returns the value you've removed
     *
     * @return value popped off the Stack
     * @throws EmptyStackException if the stack is empty
     */
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        if (top < size / 4) {
            resize(size / 2);
            return pop(); // don't forget pop after resizing
        } else {
            return stackArray[top--];
        }
    }

    /**
     * Returns the element at the top of the stack
     *
     * @return element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    private void resize(int newSize) {
        int[] transferArray = new int[newSize];

        int elementsToCopy = Math.min(stackArray.length, newSize);
        System.arraycopy(stackArray, 0, transferArray, 0, elementsToCopy);

        stackArray = transferArray;
        size = newSize;
    }

    /**
     * Returns true if the stack is empty
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == EMPTY_STACK_INDICATOR;
    }

    /**
     * Returns true if the stack is full
     *
     * @return true if the stack is full, false otherwise
     */
    public boolean isFull() {
        return size() == size;
    }

    /**
     * Clears the Stack
     */
    public void clear() {
        top = EMPTY_STACK_INDICATOR;
    }

    /**
     * Return size of stack
     *
     * @return size of stack
     */
    public int size() {
        return top + 1;
    }
}