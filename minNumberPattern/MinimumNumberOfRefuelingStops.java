package minNumberPattern;

import java.util.PriorityQueue;


public class MinimumNumberOfRefuelingStops {
    
    public static int find(int [][] stations , int cur,  int initialFuel , int target){

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int res = 0;
        int i = 0;
        for(res=0; cur<target;res++){
            // meh woh saare station jaaunga joo mere sabse pass hai aur wha seh petrol bharwaa lunggaaa.
           while(i<stations.length && stations[i][0]<=cur){
            pq.offer(stations[i][1]);
           }
           if(pq.isEmpty()) return -1;
           cur+=pq.peek();
           pq.poll();
        }
        return res;







    }
}
