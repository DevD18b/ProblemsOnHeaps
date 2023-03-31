package TopKpatterns;

import java.util.HashSet;
import java.util.PriorityQueue;


public class KthSmallestElementInMatrix {
    public static int kthSmallest(int [][]  grid  , int kth){
        HashSet<Integer> set = new HashSet<>();
        for(int [] arr : grid)
        {
            for(int i  : arr){
                set.add(i);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : set) pq.offer(i);
       

        //  time complexity will be o(n-square).
        //  space complexity will be o( n ).
        for(int i = 0; i<kth; i++) pq.poll();

        return pq.peek();

    }
    public static int shortermCode(int [][] matrix , int kth){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int [] arr : matrix){
            for(int i : arr){
                pq.offer(i);
                if(pq.size()>kth) {
                    pq.poll();
            }
        }
    }
        return pq.peek();

    }
    
}
