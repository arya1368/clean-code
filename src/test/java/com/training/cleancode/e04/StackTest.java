package com.training.cleancode.e04;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Arya Pishgah (pishgah@gamelectronics.com) 18/03/2018
 */
public class StackTest {

    private Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = StackImpl.newInstance(3);
    }

    @Test
    public void newlyStackIsEmpty() throws Exception {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void pushIntoStackIncreaseTheSizeOfStack() throws Exception {
        stack.push(1);
        assertEquals(1 , stack.size());
        stack.push(4);
        assertEquals(2, stack.size());
    }

    @Test
    public void popFromStackDecreaseTheSizeOfStack() throws Exception {
        stack.push(3);
        stack.push(8);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void pushOneAndTwo_popTwoAndOne() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testTop() throws Exception {
        stack.push(4);
        assertEquals(4, stack.top());
        stack.push(2);
        assertEquals(2, stack.top());
    }

    @Test
    public void testFind() throws Exception {
        stack.push(3);
        stack.push(6);
        stack.push(45);

        find(45, 0);
        find(6, 1);
        find(3, 2);
        assertNull(stack.find(20));
    }

    private void find(int element, int expectedIndex) {
        int index = stack.find(element);
        assertEquals(expectedIndex, index);
    }

    @Test
    public void findFromEmptyStack() throws Exception {
        assertNull(stack.find(1));
    }

    @Test(expected = Stack.OverflowException.class)
    public void pushMoreThanStackCapacity_throwStackOverflowException() throws Exception {
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(8);
        stack.push(23);
    }

    @Test(expected = Stack.UnderflowException.class)
    public void popFromEmptyStack_throwStackUnderflowException() throws Exception {
        stack.pop();
    }

    @Test(expected = Stack.IllegalCapacityException.class)
    public void creatingStackWithNegativeCapacity_throwStackIllegalCapacityException() throws Exception {
        StackImpl.newInstance(-3);
    }

    @Test(expected = Stack.EmptyException.class)
    public void topFromEmptyStack() throws Exception {
        stack.top();
    }

    public static class ImmutableStackTest {
        private Stack immutableStack;

        @Before
        public void setUp() {
            immutableStack = StackImpl.newInstance(0);
        }

        @Test
        public void immutableStackIsEmpty() throws Exception {
            assertTrue(immutableStack.isEmpty());
            assertEquals(0, immutableStack.size());
        }

        @Test
        public void find_returnNll() throws Exception {
            assertNull(immutableStack.find(3));
        }

        @Test(expected = Stack.OverflowException.class)
        public void push_throwStackOverflowException() throws Exception {
            immutableStack.push(8);
        }
        @Test(expected = Stack.UnderflowException.class)
        public void pop_throwUnderflowException() throws Exception {
            immutableStack.pop();
        }

        @Test(expected = Stack.EmptyException.class)
        public void top_throwEmptyException() throws Exception {
            immutableStack.top();
        }

    }
}
