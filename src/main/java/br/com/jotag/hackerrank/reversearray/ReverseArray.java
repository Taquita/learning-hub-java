package br.com.jotag.hackerrank.reversearray;

import java.util.List;

class ReverseArray {
    public static List<Integer> exec(List<Integer> a) {
        int size = a.size();
        for (int i=0, mid=size>>1, j=size-1; i<mid; i++, j--) {
            a.set(i, a.set(j, a.get(i)));
        }
        return a;
    }
}