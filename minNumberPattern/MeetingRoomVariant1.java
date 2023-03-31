package minNumberPattern;

import java.util.PriorityQueue;

class Interval{
    int start;
    int end;
    Interval(){
        this.start = 0;
        this.end = 0;
    }
    Interval(int start , int end){
        this.start = start;
        this.end = end;
    }
}
public class MeetingRoomVariant1 {
    public static boolean  find(Interval [] arr){
        PriorityQueue<Interval> pq = new PriorityQueue<>();

       for(int i = 0; i<arr.length; i++){
        pq.offer(new Interval(arr[i].start, arr[i].end));
       }
          
       while(pq.size()>1)
       {
        Interval currentMeeting  =  pq.poll();
        Interval nextMeeting      =  pq.poll();
         if(currentMeeting.end > nextMeeting.start) return false;
       }
       return true;
}
}
