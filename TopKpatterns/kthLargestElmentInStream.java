package TopKpatterns;

import java.util.PriorityQueue;

public class kthLargestElmentInStream {

      int kth;
      PriorityQueue<Integer> pq ;
      kthLargestElmentInStream(int kth , int [] nums){
        pq = new PriorityQueue<>();
        this.kth =kth;
        for(int i :nums){
            pq.offer(i);
        }
        if(pq.size()>kth) pq.poll();
      }
      int add(int val){
        pq.offer(val);
        if(pq.size()>kth) pq.poll();
        return pq.peek();
      }



    
}
