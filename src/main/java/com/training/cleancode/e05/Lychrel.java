package com.training.cleancode.e05;



import java.math.BigInteger;

/**
 * @author Arya Pishgah (pishgah@gamelectronics.com) 18/03/2018
 */
@SuppressWarnings("WeakerAccess")
public class Lychrel {

    public static int convergesAtIteration(int n, int limit) {
        return convergesAtIteration(BigInteger.valueOf(n), 0, limit);
    }

    private static int convergesAtIteration(BigInteger n, int iteration, int limit) {
        if (iteration == limit)
            return -1;
        if (isPalindromic(n))
            return iteration;

        iteration++;
        return convergesAtIteration(n.add(reverse(n)), iteration, limit);
    }

    static boolean isPalindromic(BigInteger n) {
        char[] nDigits = getNumberCharArray(n);
        int lastIndex = nDigits.length - 1;

        for (int i = 0; i <= lastIndex; i++)
            if (nDigits[i] != nDigits[lastIndex - i])
                return false;

        return true;
    }

    static BigInteger reverse(BigInteger n) {
        char[] nDigits = getNumberCharArray(n);
        int lastIndex = nDigits.length - 1;

        for (int i = 0; i <= lastIndex / 2; i++) {
            swap(nDigits, i, lastIndex - i);
        }

        return new BigInteger(String.valueOf(nDigits));
    }

    private static char[] getNumberCharArray(BigInteger n) {
        return String.valueOf(n).toCharArray();
    }

    private static void swap(char[] nDigits, int i, int j) {
        char temp = nDigits[i];
        nDigits[i] = nDigits[j];
        nDigits[j] = temp;
    }

}
