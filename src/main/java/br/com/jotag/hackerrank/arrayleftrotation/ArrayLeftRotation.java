package br.com.jotag.hackerrank.arrayleftrotation;

import java.util.LinkedList;
import java.util.List;

public class ArrayLeftRotation {

    public static List<Integer> exec(int d, List<Integer> arr) {
        LinkedList<Integer> linkedList = new LinkedList<>(arr);
        int n = linkedList.size();

        d = d % n;

        for (int i = 0; i < d; i++) {
            Integer first = linkedList.removeFirst();
            linkedList.addLast(first);
        }

        return linkedList;
    }

}
