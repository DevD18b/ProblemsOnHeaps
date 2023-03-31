package minNumberPattern;

import java.util.PriorityQueue;

public class minCostToCombineSticks {

    public static int costOfCombination(int [] cost){

         PriorityQueue<Integer> pq = new PriorityQueue<>();
           int sum = 0;
           int totalSum = 0 ;
           while(pq.size()>1){
            sum = pq.poll()+pq.poll();
            totalSum+=sum;
            pq.offer(sum);
           }
        return totalSum;
    }
    public static void main(String[] args) {
        int [] cost  = {2,4,3};
        System.out.println(costOfCombination(cost));
    }
}
