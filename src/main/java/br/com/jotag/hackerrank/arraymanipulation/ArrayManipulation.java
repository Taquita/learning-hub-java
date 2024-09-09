package br.com.jotag.hackerrank.arraymanipulation;

import java.util.List;

public class ArrayManipulation {

    public static long exec(int n, List<List<Integer>> queries) {
        long[] diffArray = new long[n + 1];
        long result = 0L;

        for (List<Integer> query : queries) {
            int initialIndex = (query.get(0)) - 1;
            int finalIndex = (query.get(1)) - 1;
            int valueToAdd = query.get(2);

            diffArray[initialIndex] += valueToAdd;
            if (finalIndex + 1 < n) {
                diffArray[finalIndex + 1] -= valueToAdd;
            }
        }

        long current = 0L;
        for (int i = 0; i < n; i++) {
            current += diffArray[i];
            if (current > result) {
                result = current;
            }
        }

        return result;
    }

}
