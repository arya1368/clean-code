package com.training.cleancode.e04;

/**
 * @author Arya Pishgah (pishgah@gamelectronics.com) 18/03/2018
 */
public interface Stack {
    boolean isEmpty();

    int size();

    void push(int element);

    int pop();

    int top();

    /**
     * return the index of given element from top
     * of stack, return null if couldn't find element
     * in stack.
     */
    Integer find(int element);

    class OverflowException extends RuntimeException {
    }

    class UnderflowException extends RuntimeException {
    }

    class IllegalCapacityException extends RuntimeException {
    }

    class EmptyException extends RuntimeException {
    }
}
