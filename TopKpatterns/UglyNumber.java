package TopKpatterns;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumber {
    // we are given n we need to find nth ugly number;

    public static int find(int n){
         int [] arr  = {2,3,5};
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // first ugly number is 1 itself.
        pq.offer(1);
        set.add(1);
        int count = 0;
        int res = 0;
        while(!pq.isEmpty()){
           if(count==n) break;
            int number  = pq.peek();
            pq.poll();
             count+=1;
              res = number;
              for(int i : arr){
                number*=i;
                if(set.contains(number*i)==false){
                    set.add(number*i);
                      pq.offer(number*i);
                }
              }
        }
        return res;
        
    }
    
}
