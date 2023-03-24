package TopKpatterns;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static int [] find(int [] arr , int k){
        // i need frequency. 
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
          
        PriorityQueue<HashMap.Entry<Integer,Integer>> mpq = new PriorityQueue<>();
          mpq.addAll(map.entrySet());
          int [] result = new int[k];
          for(int i = 0; i<k; i++){
               HashMap.Entry<Integer,Integer> m = mpq.poll();
                result[i] = m.getKey();
          }  
          return result;

    }
}
