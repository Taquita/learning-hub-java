package br.com.jotag.hackerrank.dynamicarray;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray {

    public static List<Integer> exec(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;
        List<Integer> answers = new ArrayList<>();
        List<List<Integer>> dynamicMatrix = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            dynamicMatrix.add(new ArrayList<>());
        }

        for (List<Integer> query : queries) {
            int command = query.get(0);
            int x = query.get(1);
            int y = query.get(2);
            int index = (x ^ lastAnswer) % n;

            if (command == 1) {
                dynamicMatrix.get(index).add(y);
            } else if (command == 2) {
                lastAnswer = dynamicMatrix.get(index).get(y % dynamicMatrix.get(index).size());
                answers.add(lastAnswer);
            }
        }
        return answers;
    }

}
