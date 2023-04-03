package TopKpatterns;

import java.util.HashMap;
import java.util.*;

public class topKFrequentElement {

    public static ArrayList<Integer> findElement(int[] arr, int kth) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        int index = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (index != kth) {
            Map.Entry<Integer, Integer> m = pq.poll();
            ans.add(m.getKey());
            index++;
        }
        return ans;
    }
}
