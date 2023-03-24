import java.util.PriorityQueue;

public class KthLargest{
         
      public static int findKthLargest(int [] arr , int kth){


         PriorityQueue<Integer> pq = new PriorityQueue<>();

         for(int i  : arr){
            pq.offer(i);
         }
         // now i want kth element.
         // so what i am going to do  is simplee iterate till kth and remove all the element.
         for(int i = 0; i<kth; i++) pq.poll();
         return pq.peek();


      }
   }