package com.training.cleancode.e04;

/**
 * @author Arya Pishgah (pishgah@gamelectronics.com) 18/03/2018
 */
@SuppressWarnings("WeakerAccess")
public class StackImpl implements Stack {

    private final int capacity;
    private int[] elements;
    private int size;

    public static Stack newInstance(int capacity) {
        if (capacity == 0)
            return new ImmutableStack();

        return new StackImpl(capacity);
    }

    private StackImpl(int capacity) {
        if(capacity < 0)
            throw new IllegalCapacityException();

        this.capacity = capacity;
        elements = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(int element) {
        if (size == capacity)
            throw new OverflowException();

        this.elements[size++] = element;
    }

    public int pop() {
        if (isEmpty())
            throw new UnderflowException();

        return elements[--size];
    }

    public int top() {
        if (isEmpty())
            throw new EmptyException();

        return elements[size - 1];
    }

    public Integer find(int element) {
        for (int i = size - 1; i >= 0; i--)
            if (element == elements[i])
                return size - (i + 1);

        return null;
    }

    private static class ImmutableStack implements Stack {

        public boolean isEmpty() {
            return true;
        }

        public int size() {
            return 0;
        }

        public void push(int element) {
            throw new OverflowException();
        }

        public int pop() {
            throw new UnderflowException();
        }

        public int top() {
            throw new EmptyException();
        }

        public Integer find(int element) {
            return null;
        }
    }
}
