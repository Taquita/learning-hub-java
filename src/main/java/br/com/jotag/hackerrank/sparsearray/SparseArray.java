package br.com.jotag.hackerrank.sparsearray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SparseArray
{

    public static List<Integer> exec(List<String> stringList, List<String> queries) {
        Map<String, Integer> stringCount = new HashMap<>();
        List<Integer> result = new ArrayList<>(queries.size());

        for (String s : stringList) {
            stringCount.put(s, stringCount.getOrDefault(s, 0) + 1);
        }

        for (String query : queries) {
            result.add(stringCount.getOrDefault(query, 0));
        }

        return result;
    }

}
