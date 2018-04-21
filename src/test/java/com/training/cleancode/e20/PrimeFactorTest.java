package com.training.cleancode.e20;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Arya Pishgah (pishgah@gamelectronics.com) 21/04/2018
 */
public class PrimeFactorTest {

    @Test
    public void testPrimeFactors() throws Exception {
        assertPrimeFactors(1, listOf());
        assertPrimeFactors(2, listOf(2));
        assertPrimeFactors(3, listOf(3));
        assertPrimeFactors(4, listOf(2, 2));
        assertPrimeFactors(5, listOf(5));
        assertPrimeFactors(6, listOf(2, 3));
        assertPrimeFactors(7, listOf(7));
        assertPrimeFactors(8, listOf(2, 2, 2));
        assertPrimeFactors(9, listOf(3, 3));
        assertPrimeFactors(2 * 3 * 3  * 5 * 7 * 13 * 13 * 17,
                listOf(2, 3 ,3 ,5, 7, 13, 13 ,17));
    }

    private void assertPrimeFactors(int n, List<Integer> expected) {
        assertEquals(expected, PrimeFactor.of(n));
    }

    private List<Integer> listOf(Integer... numbers) {
        return Arrays.asList(numbers);
    }
}
