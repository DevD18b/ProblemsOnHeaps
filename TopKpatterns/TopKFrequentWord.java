package TopKpatterns;
import java.util.*;
public class TopKFrequentWord {
    public static int [] topElement(String [] arr , int k){
        HashMap<String , Integer> map = new HashMap<>();
        for(String word : arr){
            map.put(word , map.put(word, 0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> mpq = new PriorityQueue<>();
           mpq.addAll(map.entrySet());
           
           int [] res =  new int[k];
           for(int i = 0; i<k; i++){
            HashMap.Entry<String , Integer> m = mpq.poll();
             res[i] = m.getValue();
           }
           return res;
    } 
    
}
