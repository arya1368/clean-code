package com.training.cleancode.e05;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Arya Pishgah (pishgah@gamelectronics.com) 18/03/2018
 */
public class LychrelTest {

    private static final int LIMIT = 1000;

    @Test
    public void facts() throws Exception {
        convergesAtIteration(1, 0);
        convergesAtIteration(5, 0);
        convergesAtIteration(10, 1);
        convergesAtIteration(19, 2);
        convergesAtIteration(78, 4);
        convergesAtIteration(89, 24);

        assertEquals(-1, Lychrel.convergesAtIteration(196, LIMIT));
    }

    private void convergesAtIteration(int n, int iteration) {
        assertEquals(iteration, Lychrel.convergesAtIteration(n, LIMIT));
    }

    @Test
    public void palindromicNumbers() throws Exception {
        palindromic(1);
        palindromic(11);
        palindromic(121);
        palindromic(12321);
        palindromic(1234321);
    }

    private void palindromic(int n) {
        assertTrue(Lychrel.isPalindromic(BigInteger.valueOf(n)));
    }

    @Test
    public void nonPalindromicNumbers() throws Exception {
        nonPalindromic(13);
        nonPalindromic(132);
        nonPalindromic(1321);
        nonPalindromic(12431);
        nonPalindromic(135431);
    }

    private void nonPalindromic(int n) {
        assertFalse(Lychrel.isPalindromic(BigInteger.valueOf(n)));
    }

    @Test
    public void testReverse() throws Exception {
        reverse(1, 1);
        reverse(23, 32);
        reverse(238, 832);
        reverse(50, 5);
        reverse(1240, 421);
    }

    private void reverse(int n, int expected) {
        assertEquals(expected, Lychrel.reverse(BigInteger.valueOf(n)).intValue());
    }
}
