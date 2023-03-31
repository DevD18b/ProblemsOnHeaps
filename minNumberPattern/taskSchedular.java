package minNumberPattern;
import java.util.*;

public class taskSchedular {
    public static int find(char [] arr , int n){

        HashMap<Character,Integer> map =  new HashMap<>();

        for(char ch : arr){
            map.put(ch , map.getOrDefault(ch, 0)+1);
        }
 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());

        int cycles= 0;
        while(pq.isEmpty()==false){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i<n+1; i++){
                if(!pq.isEmpty()) temp.add(pq.poll());
            }
            for(int i : temp){
                if(--i>0){
                    pq.offer(i);
                }
            }
            cycles+=pq.isEmpty()?temp.size():n+1;
        }
        return cycles;
    }
    
}
