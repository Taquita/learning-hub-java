package br.com.jotag.hackerrank.hourglasssum;

import java.util.ArrayList;
import java.util.List;

public class HourglassSum {

    public static int exec(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < arr.size() - 1; i++) {
            List<Integer> prevRow = arr.get(i - 1);
            List<Integer> currRow = arr.get(i);
            List<Integer> nextRow = arr.get(i + 1);

            for (int j = 1; j < currRow.size() - 1; j++) {
                int top = prevRow.get(j - 1) + prevRow.get(j) + prevRow.get(j + 1);
                int middle = currRow.get(j);
                int bottom = nextRow.get(j - 1) + nextRow.get(j) + nextRow.get(j + 1);
                int total = top + middle + bottom;
                if (total > maxSum) {
                    maxSum = total;
                }
            }
        }
        return maxSum;
    }

}
