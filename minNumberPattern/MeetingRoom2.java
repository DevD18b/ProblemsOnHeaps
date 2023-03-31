package minNumberPattern;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    public static int countMeetingRoom(Interval [] arr){
        if(arr.length==0 || arr==null) return 0;

       PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->a.end-b.end); // sort according to the end time.
       Arrays.sort(arr,(a,b)->a.start-b.start);   // sort according to the start time.
           pq.offer(arr[0]);
       for(int i  =1; i<arr.length; i++){
          Interval current  = arr[i];
          Interval onGoing = pq.poll();
          if(current.start >= onGoing.end){
         onGoing.end = current.end;
          }
          else{
            pq.offer(current);
          }
          pq.offer(onGoing);
       }
       return pq.size();
    }
    
}
