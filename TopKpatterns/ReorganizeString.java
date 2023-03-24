package TopKpatterns;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static String reorganize(String str){
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
            }

            PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
               
            pq.addAll(map.keySet());



StringBuilder sb = new StringBuilder();
           while(!pq.isEmpty())
        {
              char current  = pq.poll();
               char next = pq.poll();
               sb.append(current);
                sb.append(next);
              
                map.put(current, map.getOrDefault(current, 0)-1);
                map.put(next, map.getOrDefault(next, 0)-1);
                if(map.get(current)>0)
                {
                    pq.offer(current);
                }
                if(map.get(next)>0){
                    pq.offer(next);
                }
            }

            while(!pq.isEmpty()){
                char last  = pq.peek();
                pq.poll();
                if(map.get(last)>1) return " ";
                else sb.append(last);
            }            
            return sb.toString();
         








    }
    
}
